"use client";

import { useState, useEffect } from "react";
import Link from "next/link";

interface Pack {
    id: string;
    name: string;
    isActive: boolean;
    isSystem: boolean;
}

export default function PacksPage() {
    const [packs, setPacks] = useState<Pack[]>([]);
    const [loading, setLoading] = useState(true);
    const [isCreating, setIsCreating] = useState(false);
    const [newPackName, setNewPackName] = useState("");
    const [error, setError] = useState("");

    // Fetch Packs
    const fetchPacks = async () => {
        try {
            const res = await fetch("http://localhost:8080/api/packs");
            if (res.ok) {
                const data = await res.json();
                setPacks(data);
            }
        } catch (err) {
            console.error("Failed to fetch packs", err);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchPacks();
    }, []);

    // Toggle Active Status
    const togglePack = async (pack: Pack) => {
        // Optimistic update
        const originalPacks = [...packs];
        setPacks(packs.map(p => p.id === pack.id ? { ...p, isActive: !p.isActive } : p));

        try {
            const res = await fetch(`http://localhost:8080/api/packs/${pack.id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name: pack.name, isActive: !pack.isActive })
            });
            if (!res.ok) throw new Error("Update failed");
        } catch (err) {
            setPacks(originalPacks); // Revert
            console.error(err);
        }
    };

    // Create Pack
    const handleCreate = async (e: React.FormEvent) => {
        e.preventDefault();
        if (!newPackName.trim()) return;

        try {
            const res = await fetch("http://localhost:8080/api/packs", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name: newPackName, isActive: true })
            });

            if (res.ok) {
                setNewPackName("");
                setIsCreating(false);
                fetchPacks(); // Refresh list to get new ID
            }
        } catch (err) {
            setError("Erreur lors de la création");
        }
    };

    // Delete Pack
    const handleDelete = async (id: string) => {
        if (!confirm("Supprimer ce pack ?")) return;

        try {
            const res = await fetch(`http://localhost:8080/api/packs/${id}`, {
                method: "DELETE"
            });
            if (res.ok) {
                setPacks(packs.filter(p => p.id !== id));
            }
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <main className="min-h-screen bg-slate-50 p-4 pb-24">
            <header className="mb-6 flex items-center justify-between">
                <div>
                    <h1 className="text-2xl font-bold text-slate-900">Gérer mes Packs</h1>
                    <p className="text-slate-500 text-sm">Organisez vos listes par contexte</p>
                </div>
                <Link href="/" className="text-indigo-600 font-medium">Fermer</Link>
            </header>

            {loading ? (
                <div className="text-center py-10 opacity-50">Chargement...</div>
            ) : (
                <div className="space-y-4">
                    {packs.map(pack => (
                        <div key={pack.id} className={`bg-white p-4 rounded-xl shadow-sm border ${pack.isActive ? "border-indigo-100" : "border-slate-100 opacity-75"
                            } flex items-center justify-between transition-all`}>

                            <div className="flex items-center gap-3">
                                <div className={`w-10 h-10 rounded-full flex items-center justify-center ${pack.isActive ? "bg-indigo-100 text-indigo-600" : "bg-slate-100 text-slate-400"
                                    }`}>
                                    {pack.isSystem ? "★" : "📦"}
                                </div>
                                <div>
                                    <h3 className={`font-semibold ${pack.isActive ? "text-slate-900" : "text-slate-500"}`}>{pack.name}</h3>
                                    {pack.isSystem && <span className="text-[10px] uppercase tracking-wider text-slate-400 font-bold">Système</span>}
                                </div>
                            </div>

                            <div className="flex items-center gap-3">
                                {/* Toggle Switch */}
                                <button
                                    onClick={() => togglePack(pack)}
                                    className={`w-12 h-6 rounded-full p-1 transition-colors ${pack.isActive ? "bg-indigo-600" : "bg-slate-200"
                                        }`}
                                >
                                    <div className={`w-4 h-4 bg-white rounded-full transition-transform ${pack.isActive ? "translate-x-6" : ""
                                        }`} />
                                </button>

                                {/* Delete Button */}
                                {!pack.isSystem && (
                                    <button
                                        onClick={() => handleDelete(pack.id)}
                                        className="w-8 h-8 flex items-center justify-center text-slate-300 hover:text-red-500 transition-colors"
                                    >
                                        ×
                                    </button>
                                )}
                            </div>
                        </div>
                    ))}

                    {/* Add Button / Form */}
                    {!isCreating ? (
                        <button
                            onClick={() => setIsCreating(true)}
                            className="w-full py-4 border-2 border-dashed border-indigo-200 rounded-xl text-indigo-500 font-medium hover:bg-indigo-50 transition-colors flex items-center justify-center gap-2"
                        >
                            <span>+ Créer un nouveau pack</span>
                        </button>
                    ) : (
                        <form onSubmit={handleCreate} className="bg-white p-4 rounded-xl shadow-lg border border-indigo-200 animate-in fade-in slide-in-from-bottom-4">
                            <h3 className="font-semibold text-slate-900 mb-2">Nouveau Pack</h3>
                            <input
                                autoFocus
                                type="text"
                                placeholder="Nom (ex: Vacances Ski)"
                                className="w-full p-3 bg-slate-50 border border-slate-200 rounded-lg mb-3 focus:outline-none focus:ring-2 focus:ring-indigo-500"
                                value={newPackName}
                                onChange={e => setNewPackName(e.target.value)}
                            />
                            <div className="flex gap-2">
                                <button
                                    type="button"
                                    onClick={() => setIsCreating(false)}
                                    className="flex-1 py-2 text-slate-500 font-medium hover:bg-slate-50 rounded-lg"
                                >
                                    Annuler
                                </button>
                                <button
                                    type="submit"
                                    disabled={!newPackName.trim()}
                                    className="flex-1 py-2 bg-indigo-600 text-white font-bold rounded-lg hover:bg-indigo-700 disabled:opacity-50"
                                >
                                    Créer
                                </button>
                            </div>
                        </form>
                    )}
                </div>
            )}
        </main>
    );
}
