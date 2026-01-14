
# Story 2.1: Gestion des Types de Vêtements et Saisonnalité

Status: backlog

## Story

As a Parent,
I want to define types of clothing (e.g., "Bodysuit", "Sweater") and their seasonality,
so that I can categorize my inventory and set specific quotas for each season.

## Acceptance Criteria

1.  **Create Type**: Can add a new clothing type with a Name (e.g., "Bodysuit", "T-Shirt").
2.  **Seasonality**: Each type must have a seasonality tag: ❄️ Cold (Winter), ☀️ Hot (Summer), ⛅ Mid-Season (Spring/Autumn), or 📅 All-Year/Permanent.
3.  **List Types**: Can view a list of all clothing types filtered by season.
4.  **Predefined Data**: System should initialize with a common set of default types (e.g., Bodysuits, Pyjamas, Socks...).
5.  **Edit/Delete**: Can rename or remove a type (unless used in inventory).

## Tasks / Subtasks

- [x] Backend Implementation
  - [x] Create `ClothingType` domain entity (ID, Name, Seasonality).
  - [x] Implement `ClothingTypeRepository` and Service.
  - [x] Create DB migration/initialization script for default types.
  - [x] Create REST API endpoints (`POST /types`, `GET /types`).
- [x] Frontend Implementation
  - [x] Create `ClothingType` management page (Settings view).
  - [x] Implement display of Season icons (❄️/☀️/⛅).
  - [x] Integrate with Backend API.
- [x] Testing
  - [x] Unit tests for `ClothingType` domain.
  - [x] Integration tests for API.

## Dev Notes

- **Data Structure**: 
  - `Seasonality`: Enum (WINTER, SUMMER, MID_SEASON, ALL_YEAR).
- **Architecture**: Use existing Hexagonal structure.
- **Frontend**: Use a simple list or grid for now. Visual cues for seasons are important.
