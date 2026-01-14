# Story 2.2: Add Clothing to Inventory (Batch Mode)

**Status:** Backlog
**Epic:** Epic 2 - Inventaire et Mode Batch

## Description
Allow users to populate a child's wardrobe by adding clothing items.
To reduce the mental load of inventory management, we need a **"Batch Mode"** (or Quick Add) feature that allows adding multiple items in a row rapidly (e.g., a pile of clean laundry or a new shopping haul).
The system should remember the context (Child, Size) between additions so the user only has to select the Category/Type and Quantity.

## Acceptance Criteria

1.  **Add Item**: Can add an inventory item linking a **Child**, a **ClothingType** (which gives the Season), and a **Size** (e.g., "12M").
2.  **Quantity Management**: Can specify a quantity (e.g., "3" Bodysuits) in a single action.
3.  **Batch Entry UI**:
    *   A modal or form that stays open after submission.
    *   **Context Memory**: After adding an item, the "Child" and "Size" fields remain selected for the next entry.
    *   **Feedback**: A small "toast" or list confirms "3 Bodysuits added" without blocking flow.
4.  **List Inventory**: Can see the list of items for a specific child (basic view for verification).

## Tasks / Subtasks

- [x] Backend Implementation
  - [x] Create `InventoryItem` entity (Id, ChildId, ClothingTypeId, Size, Quantity).
  - [x] Implement `InventoryRepository` (Postgres).
  - [x] Implement `InventoryService` (add item, list by child).
  - [x] Create REST API `POST /api/inventory` and `GET /api/inventory?childId={id}`.
- [x] Frontend Implementation
  - [x] Create `InventoryItem` TypeScript interface.
  - [x] Create `QuickAddForm` component with "Batch Mode" logic (state persistence).
  - [x] Integrate on Child Profile page (or dedicated Inventory tab).
- [x] Testing
  - [x] Unit tests for `InventoryService`.
  - [x] Integration tests for Inventory API.

## Dev Notes

- **Entity Relationship**:
  - `InventoryItem` -> `Child` (Many-to-One)
  - `InventoryItem` -> `ClothingType` (Many-to-One)
- **Batch Logic**: Frontend state should hold `selectedChild` and `selectedSize`. Reset only `selectedType` and `quantity` after submit.
- **Mocking**: For now, just a list of added items is enough. Gap Analysis (Dashboards) is Epic 4.
