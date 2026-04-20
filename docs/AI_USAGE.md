# AI Usage

I used AI tools to help generate the initial class structure, suggest unit tests, and refactor movement and collision logic. AI was useful for speeding up boilerplate code and identifying edge cases such as wall collisions, coin collection, monster collisions, and health-pack restoration limits.

I reviewed all generated code manually, adjusted the design to keep monster movement deterministic for reproducible tests, and verified the final behavior by running JUnit tests and checking JaCoCo coverage.