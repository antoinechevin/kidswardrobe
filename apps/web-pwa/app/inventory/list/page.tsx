"use client";

import { useState, useEffect } from "react";
import { Child } from "../../../types/child";
import { InventoryItem } from "../../../types/inventory";
import { SEASONALITY_ICONS } from "../../../types/clothing-type";

export default function InventoryListPage() {
    const [children, setChildren] = useState<Child[]>([]);
    const [selectedChildId, setSelectedChildId] = useState("");
    const [inventory, setInventory] = useState<InventoryItem[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchChildren = async () => {
            try {
                const res = await fetch("http://localhost:8080/api/children");
                if (res.ok) {
                    const data = await res.json();
                    setChildren(data);
                    if (data.length > 0) setSelectedChildId(data[0].id);
                }
            } catch (error) {
                console.error("Failed to fetch children", error);
            } finally {
                setLoading(false);
            }
        };
        fetchChildren();
    }, []);

    useEffect(() => {
        if (!selectedChildId) return;

        const fetchInventory = async () => {
            try {
                const res = await fetch(`http://localhost:8080/api/inventory?childId=${selectedChildId}`);
                if (res.ok) {
                    const data = await res.json();
                    setInventory(data);
                }
            } catch (error) {
                console.error("Failed to fetch inventory", error);
            }
        };
        fetchInventory();
    }, [selectedChildId]);

    if (loading) return <div className="p-8 text-center uppercase tracking-widest text-gray-400">Chargement...</div>;

    return (
        <main className="max-w-4xl mx-auto p-4 md:p-8">
            <h1 className="text-3xl font-extrabold mb-8 text-indigo-950">Mon Inventaire</h1>

            <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 mb-8">
                <label className="block text-sm font-semibold text-gray-600 mb-2">Sélectionner un enfant</label>
                <div className="flex gap-2 flex-wrap">
                    {children.map(child => (
                        <button
                            key={child.id}
                            onClick={() => setSelectedChildId(child.id)}
                            className={`px-4 py-2 rounded-full text-sm font-bold transition-all ${selectedChildId === child.id
                                ? "bg-indigo-600 text-white shadow-md scale-105"
                                : "bg-gray-100 text-gray-600 hover:bg-gray-200"
                                }`}
                        >
                            {child.name}
                        </button>
                    ))}
                </div>
            </div>

            {inventory.length === 0 ? (
                <div className="text-center py-20 bg-gray-50 rounded-3xl border-2 border-dashed border-gray-200">
                    <p className="text-gray-400">Aucun vêtement dans l'inventaire pour cet enfant.</p>
                </div>
            ) : (
                <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                    {inventory.map(item => (
                        <div key={item.id} className="bg-white p-4 rounded-xl border border-gray-100 shadow-sm flex items-center gap-4">
                            <div className="w-12 h-12 bg-indigo-50 rounded-full flex items-center justify-center text-2xl shadow-inner">
                                {SEASONALITY_ICONS[item.clothingType.seasonality]}
                            </div>
                            <div className="flex-1">
                                <h4 className="font-bold text-gray-900">{item.clothingType.name}</h4>
                                <div className="flex gap-3 text-xs text-gray-500 mt-1">
                                    <span className="bg-gray-100 px-2 py-0.5 rounded uppercase">{item.size}</span>
                                    <span className="bg-indigo-100 text-indigo-700 px-2 py-0.5 rounded font-bold">Qté: {item.quantity}</span>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            )}
        </main>
    );
}
