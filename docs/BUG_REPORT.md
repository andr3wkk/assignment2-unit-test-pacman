# Bug Report / Improvement Comments

1. Monster movement should be deterministic so automated tests remain reproducible.
2. Collision handling should be centralized in the game engine to avoid duplicated logic.
3. Player lives must never exceed the maximum after using a health pack.
4. The map should validate that exactly one player start exists.
5. Coin tiles must be cleared immediately after collection.
6. Level completion should depend on remaining coins and not just player position.
7. Out-of-bounds movement should always be rejected before reading the tile.
8. Health pack logic should consume the pack after one use.