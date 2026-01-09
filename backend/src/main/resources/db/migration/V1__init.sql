-- Migration initiale
-- Cette migration sera complétée au fur et à mesure du développement

-- Table de sanity check
CREATE TABLE IF NOT EXISTS flyway_test (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);
