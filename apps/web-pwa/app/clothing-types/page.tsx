"use client";

import { useState, useEffect } from "react";
import { ClothingType, SEASONALITY_LABELS, SEASONALITY_ICONS } from "../../types/clothing-type";

export default function ClothingTypesPage() {
    const [types, setTypes] = useState<ClothingType[]>([]);
    const [newName, setNewName] = useState("");
    const [newSeasonality, setNewSeasonality] = useState<string>("ALL_YEAR");
    const [loading, setLoading] = useState(true);

    const API_URL = "http://localhost:8080/api/clothing-types";

    useEffect(() => {
        fetchTypes();
    }, []);

    const fetchTypes = async () => {
        try {
            const res = await fetch(API_URL);
            if (res.ok) {
                const data = await res.json();
                setTypes(data);
            }
        } catch (error) {
            console.error("Failed to fetch clothing types", error);
        } finally {
            setLoading(false);
        }
    };

    const handleAddType = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const res = await fetch(API_URL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name: newName, seasonality: newSeasonality }),
            });
            if (res.ok) {
                const created = await res.json();
                setTypes([...types, created]);
                setNewName("");
                setNewSeasonality("ALL_YEAR");
            }
        } catch (error) {
            console.error("Failed to add clothing type", error);
        }
    };

    if (loading) return <div className="p-8 text-center">Chargement...</div>;

    return (
        <div className="max-w-4xl mx-auto p-4">
            <h1 className="text-3xl font-bold mb-8 text-indigo-900">Mes Types de Vêtements</h1>

            {/* Form */}
            <form onSubmit={handleAddType} className="bg-indigo-50 p-6 rounded-xl mb-8 flex gap-4 items-end">
                <div className="flex-1">
                    <label className="block text-sm font-medium text-indigo-700 mb-1">Nom du type</label>
                    <input
                        type="text"
                        value={newName}
                        onChange={(e) => setNewName(e.target.value)}
                        className="w-full p-2 border rounded-md"
                        placeholder="Ex: Body Manches Courtes"
                        required
                    />
                </div>
                <div className="w-48">
                    <label className="block text-sm font-medium text-indigo-700 mb-1">Saisonnalité</label>
                    <select
                        value={newSeasonality}
                        onChange={(e) => setNewSeasonality(e.target.value)}
                        className="w-full p-2 border rounded-md"
                    >
                        {Object.entries(SEASONALITY_LABELS).map(([key, label]) => (
                            <option key={key} value={key}>
                                {SEASONALITY_ICONS[key]} {label}
                            </option>
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
                {types.map(type => (
                    <div key={type.id} className="bg-white border rounded-lg p-4 shadow-sm flex justify-between items-center">
                        <span className="font-semibold text-gray-800">{type.name}</span>
                        <span className="px-2 py-1 bg-gray-100 rounded text-sm" title={SEASONALITY_LABELS[type.seasonality]}>
                            {SEASONALITY_ICONS[type.seasonality]}
                        </span>
                    </div>
                ))}
            </div>

            {types.length === 0 && (
                <p className="text-center text-gray-500 py-12">Aucun type de vêtement défini.</p>
            )}
        </div>
    );
}
