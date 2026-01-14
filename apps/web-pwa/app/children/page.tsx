"use client";

import { useState, useEffect } from "react";
import { Child } from "../../types/child";
import ChildCard from "../../components/ChildCard";

export default function ChildrenPage() {
    const [children, setChildren] = useState<Child[]>([]);
    const [newName, setNewName] = useState("");
    const [newSize, setNewSize] = useState("3M");
    const [loading, setLoading] = useState(true);

    const API_URL = "http://localhost:8080/api/children";

    useEffect(() => {
        fetchChildren();
    }, []);

    const fetchChildren = async () => {
        try {
            const res = await fetch(API_URL);
            if (res.ok) {
                const data = await res.json();
                setChildren(data);
            }
        } catch (error) {
            console.error("Failed to fetch children", error);
        } finally {
            setLoading(false);
        }
    };

    const handleAddChild = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const res = await fetch(API_URL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name: newName, currentSize: newSize }),
            });
            if (res.ok) {
                const created = await res.json();
                setChildren([...children, created]);
                setNewName("");
                setNewSize("3M");
            }
        } catch (error) {
            console.error("Failed to add child", error);
        }
    };

    const handleUpdate = async (id: string, name: string, size: string) => {
        // Optimistic update
        setChildren(children.map(c => c.id === id ? { ...c, name, currentSize: size } : c));

        try {
            await fetch(`${API_URL}/${id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name, currentSize: size }),
            });
        } catch (error) {
            console.error("Failed to update child", error);
            fetchChildren(); // Revert on error
        }
    };

    const handleDelete = async (id: string) => {
        try {
            const res = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
            if (res.ok) {
                setChildren(children.filter(c => c.id !== id));
            }
        } catch (error) {
            console.error("Failed to delete child", error);
        }
    };

    if (loading) return <div className="p-8 text-center">Chargement...</div>;

    return (
        <div className="max-w-4xl mx-auto p-4">
            <h1 className="text-3xl font-bold mb-8 text-indigo-900">Mes Enfants</h1>

            {/* Form */}
            <form onSubmit={handleAddChild} className="bg-indigo-50 p-6 rounded-xl mb-8 flex gap-4 items-end">
                <div className="flex-1">
                    <label className="block text-sm font-medium text-indigo-700 mb-1">Prénom</label>
                    <input
                        type="text"
                        value={newName}
                        onChange={(e) => setNewName(e.target.value)}
                        className="w-full p-2 border rounded-md"
                        placeholder="Ex: Alice"
                        required
                    />
                </div>
                <div className="w-32">
                    <label className="block text-sm font-medium text-indigo-700 mb-1">Taille</label>
                    <select
                        value={newSize}
                        onChange={(e) => setNewSize(e.target.value)}
                        className="w-full p-2 border rounded-md"
                    >
                        {["1M", "3M", "6M", "9M", "12M", "18M", "24M", "36M", "4A", "6A", "8A", "10A", "12A"].map(s => (
                            <option key={s} value={s}>{s}</option>
                        ))}
                    </select>
                </div>
                <button
                    type="submit"
                    className="bg-indigo-600 text-white px-6 py-2 rounded-md hover:bg-indigo-700 transition-colors"
                >
                    Ajouter
                </button>
            </form>

            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {children.map(child => (
                    <ChildCard
                        key={child.id}
                        child={child}
                        onUpdate={handleUpdate}
                        onDelete={handleDelete}
                    />
                ))}
            </div>

            {children.length === 0 && (
                <p className="text-center text-gray-500 py-12">Aucun profil enfant pour le moment. Ajoutez-en un !</p>
            )}
        </div>
    );
}
