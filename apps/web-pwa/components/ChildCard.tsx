"use client";

import { Child } from "../types/child";
import { useState } from "react";

interface ChildCardProps {
    child: Child;
    onUpdate: (id: string, name: string, size: string) => void;
    onDelete: (id: string) => void;
}

const SIZES = ["1M", "3M", "6M", "9M", "12M", "18M", "24M", "36M", "4A", "6A", "8A", "10A", "12A"];

export default function ChildCard({ child, onUpdate, onDelete }: ChildCardProps) {
    const [isEditingSize, setIsEditingSize] = useState(false);
    const [isEditingName, setIsEditingName] = useState(false);
    const [tempName, setTempName] = useState(child.name);

    const handleSaveName = () => {
        onUpdate(child.id, tempName, child.currentSize);
        setIsEditingName(false);
    };

    return (
        <div className="border rounded-lg p-4 shadow-sm bg-white hover:shadow-md transition-shadow">
            <div className="flex justify-between items-start mb-2">
                {isEditingName ? (
                    <div className="flex gap-2">
                        <input
                            type="text"
                            className="border rounded p-1 text-lg font-bold w-32"
                            value={tempName}
                            onChange={(e) => setTempName(e.target.value)}
                            autoFocus
                        />
                        <button onClick={handleSaveName} className="text-green-600 text-sm">OK</button>
                        <button onClick={() => setIsEditingName(false)} className="text-gray-500 text-sm">X</button>
                    </div>
                ) : (
                    <h3
                        className="text-xl font-bold text-gray-800 cursor-pointer hover:text-indigo-600"
                        onClick={() => {
                            setTempName(child.name);
                            setIsEditingName(true);
                        }}
                        title="Cliquez pour renommer"
                    >
                        {child.name}
                    </h3>
                )}

                <button
                    onClick={() => onDelete(child.id)}
                    className="text-red-500 hover:text-red-700 text-sm"
                >
                    Supprimer
                </button>
            </div>

            <div className="mt-4">
                <p className="text-gray-600 text-sm mb-1">Taille actuelle</p>
                {isEditingSize ? (
                    <select
                        className="border rounded p-1 w-full bg-white"
                        value={child.currentSize}
                        onChange={(e) => {
                            onUpdate(child.id, child.name, e.target.value);
                            setIsEditingSize(false);
                        }}
                        onBlur={() => setIsEditingSize(false)}
                        autoFocus
                    >
                        {SIZES.map(size => (
                            <option key={size} value={size}>{size}</option>
                        ))}
                    </select>
                ) : (
                    <div
                        className="flex items-center gap-2 cursor-pointer group"
                        onClick={() => setIsEditingSize(true)}
                    >
                        <span className="text-2xl font-semibold text-blue-600">{child.currentSize}</span>
                        <span className="text-xs text-gray-400 opacity-0 group-hover:opacity-100 transition-opacity">Modifier</span>
                    </div>
                )}
            </div>
        </div>
    );
}
