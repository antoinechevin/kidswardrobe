import Link from "next/link";

export default function Home() {
    return (
        <main className="flex min-h-screen flex-col items-center justify-between p-24">
            <h1 className="text-4xl font-bold mb-8">Kids Wardrobe Gap Analysis</h1>
            <p className="mb-8">Bienvenue sur l'application.</p>

            <Link href="/children" className="bg-indigo-600 text-white px-6 py-3 rounded-lg hover:bg-indigo-700 transition">
                Gérer les Profils Enfants
            </Link>
        </main>
    );
}
