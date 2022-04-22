//package FirstApproach;
//
//import java.util.Random;
//
//public class SlidingTilePuzzle {
//    private int[] tiles = {
//            1,  2,  3,  4,
//            5,  6,  7,  8,
//            9, 10, 11, 12,
//            13, 14, 15,  0
//    };
//    private final int size;
//    private int hole;                       // Index of the "0" tile
//
//    public SlidingTilePuzzle() {
//        this.size = (int)Math.sqrt(this.tiles.length);
//        assert size * size == this.tiles.length;
//
//        this.hole = this.tiles.length - 1;
//        assert this.tiles[this.hole] == 0;
//    }
//
//    public void shuffle(int moves) {
//        Random rand = new Random();
//        int[] neighborOffsets = { -size, +size, -1, +1 }; // up down left right
//        while (moves-- > 0) {
//            int neighbor;
//            do {
//                neighbor = this.hole + neighborOffsets[rand.nextInt(4)];
//            } while (!this.canMove(neighbor));
//            this.move(neighbor);
//        }
//    }
//
//    /**
//     * Tests whether a tile at the specified position can be moved into a
//     * neighboring hole (i.e. whether the hole can be moved to the specified
//     * position).
//     */
//    public boolean canMove(int pos) {
//        if (pos < 0 || pos >= size * size) {
//            return false;                   // No such position
//        }
//        int diff = this.hole - pos;
//        if (diff == -1) {                   // Slide tile left (hole goes right)
//            return pos % size != 0;         // ... unless tile is on left edge
//        } else if (diff == +1) {            // Slide tile right (hole goes left)
//            return this.hole % size != 0;   // ... unless hole is on left edge
//        } else {
//            return Math.abs(diff) == size;  // Slide vertically
//        }
//    }
//
//    /**
//     * Move the tile at the specified position into the neighboring hole (i.e.
//     * move the hole to the specified position).
//     */
//    public void move(int pos) {
//        if (!this.canMove(pos)) {
//            throw new IllegalArgumentException("Illegal move");
//        }
//        assert this.tiles[this.hole] == 0;
//        this.tiles[this.hole] = this.tiles[pos];
//        this.tiles[this.hole = pos] = 0;
//    }
//
//    public int tileAt(int pos) {
//        try {
//            return this.tiles[pos];
//        } catch (ArrayIndexOutOfBoundsException badPos) {
//            throw new IllegalArgumentException("No such position");
//        }
//    }
//
//    public int getHole() {
//        return this.hole;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder(size * size * 4);
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                int tile = this.tileAt(i * this.size + j);
//                sb.append(String.format("%2s ", (tile == 0) ? "" : tile));
//            }
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//
//    // Demonstration
//    public static void main(String[] args) {
//        SlidingTilePuzzle p = new SlidingTilePuzzle();
//        for (int i = 0; i < 2; i++) {
//            System.out.println(p);
//            p.shuffle(50);
//        }
//    }
//}
