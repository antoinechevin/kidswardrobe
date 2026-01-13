import type { Metadata } from "next";

export const metadata: Metadata = {
    title: "Kids Wardrobe Gap Analysis",
    description: "Manage your kids' wardrobe inventory efficiently",
};

export default function RootLayout({
    children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <html lang="fr">
            <body>{children}</body>
        </html>
    );
}
