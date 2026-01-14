"use client";

import { useState } from "react";
import QuickAddForm from "../../components/QuickAddForm";
import { InventoryItem } from "../../types/inventory";

export default function InventoryPage() {
    const [recentItems, setRecentItems] = useState<InventoryItem[]>([]);

    const handleItemAdded = (item: InventoryItem) => {
        setRecentItems([item, ...recentItems]);
    };

    return (
        <main className="max-w-4xl mx-auto p-4 md:p-8">
            <h1 className="text-3xl font-extrabold mb-8 text-indigo-950">Inventaire Batch</h1>

            <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
                {/* Left Column: Input */}
                <div className="lg:col-span-2">
                    <QuickAddForm onItemAdded={handleItemAdded} />
                </div>

                {/* Right Column: Recent Activity */}
                <div className="bg-white p-6 rounded-2xl border border-gray-100 shadow-sm">
                    <h3 className="text-lg font-bold mb-4 text-gray-800">Derniers ajouts</h3>
                    <div className="space-y-3">
                        {recentItems.length === 0 ? (
                            <p className="text-gray-400 text-sm italic">Aucun ajout récent.</p>
                        ) : (
                            recentItems.slice(0, 10).map((item) => (
                                <div key={item.id} className="p-3 bg-indigo-50 rounded-lg flex justify-between items-center text-sm border border-indigo-100 animate-in fade-in slide-in-from-top-2">
                                    <div className="flex flex-col">
                                        <span className="font-semibold text-indigo-900">{item.clothingType.name}</span>
                                        <span className="text-gray-500 text-xs">{item.child.name} • {item.size}</span>
                                    </div>
                                    <div className="bg-white px-2 py-1 rounded-md border border-indigo-200 font-bold text-indigo-600">
                                        x{item.quantity}
                                    </div>
                                </div>
                            ))
                        )}
                    </div>
                    {recentItems.length > 10 && (
                        <p className="text-center mt-4 text-xs text-gray-400">Voir plus...</p>
                    )}
                </div>
            </div>
        </main>
    );
}
