import Link from "next/link";

export default function Home() {
    return (
        <main className="flex min-h-screen flex-col items-center justify-between p-24">
            <h1 className="text-4xl font-bold mb-8">Kids Wardrobe Gap Analysis</h1>
            <p className="mb-8">Bienvenue sur l'application.</p>

            <div className="flex gap-4">
                <Link href="/children" className="bg-indigo-600 text-white px-6 py-3 rounded-lg hover:bg-indigo-700 transition">
                    Gérer les Profils Enfants
                </Link>
                <Link href="/clothing-types" className="bg-gray-600 text-white px-6 py-3 rounded-lg hover:bg-gray-700 transition">
                    Mes Types de Vêtements
                </Link>
            </div>
        </main>
    );
}
