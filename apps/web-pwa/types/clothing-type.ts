export interface ClothingType {
    id: string;
    name: string;
    seasonality: 'WINTER' | 'SUMMER' | 'MID_SEASON' | 'ALL_YEAR';
}

export const SEASONALITY_LABELS: Record<string, string> = {
    WINTER: 'Hiver',
    SUMMER: 'Été',
    MID_SEASON: 'Mi-saison',
    ALL_YEAR: 'Toute l\'année'
};

export const SEASONALITY_ICONS: Record<string, string> = {
    WINTER: '❄️',
    SUMMER: '☀️',
    MID_SEASON: '⛅',
    ALL_YEAR: '📅'
};
