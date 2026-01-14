"use client";

import { useState, useEffect } from "react";
import { Child } from "../types/child";
import { ClothingType, SEASONALITY_ICONS } from "../types/clothing-type";

interface QuickAddFormProps {
    onItemAdded: (item: any) => void;
}

export default function QuickAddForm({ onItemAdded }: QuickAddFormProps) {
    const [children, setChildren] = useState<Child[]>([]);
    const [clothingTypes, setClothingTypes] = useState<ClothingType[]>([]);

    // Batch context
    const [selectedChildId, setSelectedChildId] = useState("");
    const [selectedSize, setSelectedSize] = useState("6M");

    // Changing per entry
    const [selectedTypeId, setSelectedTypeId] = useState("");
    const [quantity, setQuantity] = useState(1);

    const [loading, setLoading] = useState(true);
    const [submitting, setSubmitting] = useState(false);
    const [message, setMessage] = useState("");

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [cRes, tRes] = await Promise.all([
                    fetch("http://localhost:8080/api/children"),
                    fetch("http://localhost:8080/api/clothing-types")
                ]);

                if (cRes.ok && tRes.ok) {
                    const cData = await cRes.json();
                    const tData = await tRes.json();
                    setChildren(cData);
                    setClothingTypes(tData);

                    if (cData.length > 0) setSelectedChildId(cData[0].id);
                    if (tData.length > 0) setSelectedTypeId(tData[0].id);
                }
            } catch (error) {
                console.error("Failed to fetch form data", error);
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, []);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setSubmitting(true);
        setMessage("");

        try {
            const res = await fetch("http://localhost:8080/api/inventory", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    childId: selectedChildId,
                    clothingTypeId: selectedTypeId,
                    size: selectedSize,
                    quantity: quantity
                }),
            });

            if (res.ok) {
                const data = await res.json();
                onItemAdded(data);
                setMessage(`Ajouté : ${quantity} x ${clothingTypes.find(t => t.id === selectedTypeId)?.name}`);

                // Keep selectedChildId and selectedSize (Batch Mode)
                // Reset type and quantity
                setQuantity(1);

                // Clear message after 3 seconds
                setTimeout(() => setMessage(""), 3000);
            }
        } catch (error) {
            console.error("Failed to add inventory item", error);
            setMessage("Erreur lors de l'ajout");
        } finally {
            setSubmitting(false);
        }
    };

    if (loading) return <div className="text-center p-4">Chargement des données...</div>;

    if (children.length === 0) return (
        <div className="bg-yellow-50 p-4 rounded-lg border border-yellow-200">
            <p className="text-yellow-800">Veuillez d'abord créer un profil enfant.</p>
        </div>
    );

    return (
        <div className="bg-white p-6 rounded-2xl shadow-lg border border-indigo-100">
            <h2 className="text-xl font-bold mb-4 text-indigo-900">Saisie Rapide (Mode Batch)</h2>

            <form onSubmit={handleSubmit} className="space-y-4">
                <div className="grid grid-cols-2 gap-4">
                    <div>
                        <label className="block text-sm font-medium text-gray-700 mb-1">Enfant</label>
                        <select
                            value={selectedChildId}
                            onChange={(e) => setSelectedChildId(e.target.value)}
                            className="w-full p-2 border rounded-lg focus:ring-2 focus:ring-indigo-500"
                        >
                            {children.map(c => (
                                <option key={c.id} value={c.id}>{c.name}</option>
                            ))}
                        </select>
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700 mb-1">Taille</label>
                        <select
                            value={selectedSize}
                            onChange={(e) => setSelectedSize(e.target.value)}
                            className="w-full p-2 border rounded-lg focus:ring-2 focus:ring-indigo-500"
                        >
                            {["1M", "3M", "6M", "9M", "12M", "18M", "24M", "36M", "4A", "6A", "8A", "10A", "12A"].map(s => (
                                <option key={s} value={s}>{s}</option>
                            ))}
                        </select>
                    </div>
                </div>

                <div className="grid grid-cols-3 gap-4 items-end">
                    <div className="col-span-2">
                        <label className="block text-sm font-medium text-gray-700 mb-1">Article</label>
                        <select
                            value={selectedTypeId}
                            onChange={(e) => setSelectedTypeId(e.target.value)}
                            className="w-full p-2 border rounded-lg focus:ring-2 focus:ring-indigo-500"
                        >
                            {clothingTypes.map(t => (
                                <option key={t.id} value={t.id}>
                                    {SEASONALITY_ICONS[t.seasonality]} {t.name}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700 mb-1">Quantité</label>
                        <input
                            type="number"
                            min="1"
                            value={quantity}
                            onChange={(e) => setQuantity(parseInt(e.target.value))}
                            className="w-full p-2 border rounded-lg focus:ring-2 focus:ring-indigo-500"
                        />
                    </div>
                </div>

                <button
                    type="submit"
                    disabled={submitting}
                    className={`w-full py-3 rounded-xl font-bold text-white transition-all ${submitting ? "bg-indigo-300 cursor-not-allowed" : "bg-indigo-600 hover:bg-indigo-700"
                        }`}
                >
                    {submitting ? "Ajout..." : "Valider & Continuer"}
                </button>
            </form>

            {message && (
                <div className={`mt-4 p-2 text-center rounded-lg text-sm font-medium ${message.includes("Erreur") ? "bg-red-50 text-red-700" : "bg-green-50 text-green-700"
                    }`}>
                    {message}
                </div>
            )}
        </div>
    );
}
