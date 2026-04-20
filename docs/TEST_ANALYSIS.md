# Test Analysis

## Equivalence Partitions

### Player movement
- valid move into empty tile
- invalid move into wall
- invalid move outside map
- valid move into special tile

### Coin collection
- tile contains coin
- tile does not contain coin
- last remaining coin
- multiple coins remain

### Monster collision
- no collision
- collision while player has more than 1 life
- collision when player has exactly 1 life

### Health restoration
- player below max lives
- player already at max lives
- health pack consumed
- no health pack on tile

### Level completion
- 0 coins left
- 1 coin left
- more than 1 coin left

## Boundary Values

### Map boundaries
- top edge
- bottom edge
- left edge
- right edge

### Lives
- 0
- 1
- max
- max - 1

### Coins
- 0
- 1
- multiple