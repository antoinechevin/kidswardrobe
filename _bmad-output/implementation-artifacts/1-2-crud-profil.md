
# Story 1.2: CRUD Profil Enfant et modification de taille

Status: backlog

## Story

As a Parent,
I want to create child profiles and manage their clothing sizes,
so that the gap analysis is accurate for each child.

## Acceptance Criteria

1. **Create Profile**: Can add a new child with Name and Current Size.
2. **Read Profile**: Can view list of children with their details.
3. **Update Profile**: Can update child's name.
4. **Update Size**: Can quickly update child's size with a single click/action (critical for growing kids).
5. **Delete Profile**: Can remove a child profile.
6. **Size Validation**: Size must be selected from a predefined list (e.g., 1M, 3M, 6M...).

## Tasks / Subtasks

- [ ] Backend Implementation
  - [x] Create `Child` domain entity (ID, Name, SizeId)
  - [x] Implement `ChildService` ports and adapters
  - [x] Create REST API endpoints (`POST /children`, `GET /children`, `PUT /children/{id}`)
  - [x] Implement "Quick Size Update" endpoint (`PATCH /children/{id}/size`)
- [ ] Frontend Implementation
  - [x] Create Child Profile Card Component
  - [x] Create Child Management Page
  - [x] Integrate with Backend API
- [ ] Testing
  - [x] Unit tests for Domain logic
  - [x] Integration tests for API

## Dev Notes

- Use JSONB/Enum for sizes if not a separate table yet (Check Architecture).
- Hexagonal architecture compliance is mandatory.

