package com.systar.animals;

enum Direction {
    RIGHT,
    DOWN,
    LEFT,
    UP;
}

/**
 * Object representing a printHtml of numbers
 *
 */
public class Snail {

    private int size;
    private int[][] matrix;
    private int row, col;
    private Direction track;

    /**
     *
     * @param size: is the width or height of the table
     */
    public Snail(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("the size of the matrix must be positive");
        }
        this.size = size;
        this.matrix = new int[size][size];
        this.row = 0;
        this.col = 0;
        this.track = Direction.RIGHT;
        this.matrix = matrix();
    }

    /**
     * with a null or positive n, returns the snail in html
     *
     * printHtml(1): 1
     * printHtml(2): 1 2 4 3
     * printHtml(3): 1 2 3 8 9 4 7 6 5
     *
     * @return
     */
    public String printHtml() {
        StringBuilder sb = new StringBuilder("<table border=\"1\">");
        sb.append(printBody())
                .append("</table>").toString();
        return sb.toString();
    }

    /**
     * for standard output printing
     *
     * @return built String
     */
    public String printPlainText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("\n");
            }
            for (int j = 0; j < size; j++) {
                if (j > 0) {
                    sb.append(" ");
                }
                sb.append(matrix[i][j]);
            }//for
        }//for
        return sb.toString();
    }

    /**
     *
     * @param size
     * @return built String with tr and td
     */
    private String printBody() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("<tr>");
            for (int j = 0; j < size; j++) {
                sb.append("<td>")
                        .append(matrix[i][j])
                        .append("</td>");
            }
            sb.append("</tr>");
        }
        return sb.toString();
    }

    /**
     * table construction
     */
    private int[][] matrix() {
        int nb = size * size;
        int i = 1;
        while (i < nb) {
            matrix[row][col] = i;
            stepForward();
            i++;
        }
        matrix[row][col] = i;
        return matrix;
    }

    /**
     * recursion to determinate the direction to walk through the printHtml
     */
    private void stepForward() {
        switch (track) {
            case RIGHT:
                if (col + 1 < size && matrix[row][col + 1] == 0) {
                    col++;
                } else {
                    track = Direction.DOWN;
                }
                break;
            case DOWN:
                if (row + 1 < size && matrix[row + 1][col] == 0) {
                    row++;
                } else {
                    track = Direction.LEFT;
                }
                break;
            case LEFT:
                if (col - 1 > -1 && matrix[row][col - 1] == 0) {
                    col--;
                } else {
                    track = Direction.UP;
                }
                break;
            case UP:
                if (row - 1 > -1 && matrix[row - 1][col] == 0) {
                    row--;
                } else {
                    track = Direction.RIGHT;
                    stepForward();
                }
                break;
            default:
                break;
        }
    }
}
