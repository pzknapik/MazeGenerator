
# Maze Generator

Simple project, that generates random square maze and prints it's graphical representation using basic text output.
The maze is generated with Aldous-Broder algorithm:

     Steps:
     * 1. Choose random cell and set as (A).
     * 2. Choose a neighbor connected to cell (A) and:
     *      a) If the neighbor has not yet been visited, connect it to (A) (delete wall between them).
     *      OR
     *      b) If the neighbor has been visited, do not connect it to (A) (leave the wall between them).
     * 3. Set the neighbor as new (A).
     * 4. Repeat steps 2-3 until all cells have been visited.


The maze created with this method is "perfect" and complete - it has exactly one solution,
and the generated path covers all cells of the maze. The program allows generation of relatively
big mazes (100x100) in a few seconds.

Implemented data structures used for maze representation allow to extend the program with
more efficient Wilson's algorithm.

## Visualization

Starting/default state of 7x7 maze:

```text
+   ++---++---++---++---++---++---+
| # || # || # || # || # || # || # |
+---++---++---++---++---++---++---+
+---++---++---++---++---++---++---+
| # || # || # || # || # || # || # |
+---++---++---++---++---++---++---+
+---++---++---++---++---++---++---+
| # || # || # || # || # || # || # |
+---++---++---++---++---++---++---+
+---++---++---++---++---++---++---+
| # || # || # || # || # || # || # |
+---++---++---++---++---++---++---+
+---++---++---++---++---++---++---+
| # || # || # || # || # || # || # |
+---++---++---++---++---++---++---+
+---++---++---++---++---++---++---+
| # || # || # || # || # || # || # |
+---++---++---++---++---++---++---+
+---++---++---++---++---++---++---+
| # || # || # || # || # || # || # |
+---++---++---++---++---++---++   +
```
Maze (7x7) generated with Aldous-Broder algorithm:
```text
+   ++---++---++---++---++---++---+
|   ||        ||   ||             |
+   ++---++   ++   ++---++   ++   +
+   ++---++   ++   ++---++   ++   +
|   ||   ||                  ||   |
+   ++   ++---++---++   ++   ++---+
+   ++   ++---++---++   ++   ++---+
|                       ||        |
+---++---++   ++   ++---++   ++---+
+---++---++   ++   ++---++   ++---+
|        ||   ||   ||             |
+   ++   ++   ++   ++   ++---++   +
+   ++   ++   ++   ++   ++---++   +
|   ||   ||   ||   ||   ||        |
+   ++---++   ++---++---++---++---+
+   ++---++   ++---++---++---++---+
|                  ||             |
+   ++   ++---++   ++   ++---++   +
+   ++   ++---++   ++   ++---++   +
|   ||        ||             ||   |
+---++---++---++---++---++---++   +
```

## Sources

[wikipedia](https://en.wikipedia.org/wiki/Maze_generation_algorithm)

[dev.to](https://dev.to/marksasp95/introducing-maze-generator-java-320g)

[weblog.jamisbuck.org](http://weblog.jamisbuck.org/2011/1/17/maze-generation-aldous-broder-algorithm)
