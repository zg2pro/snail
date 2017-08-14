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
        this.size = size;
        this.matrix = new int[size][size];
        this.row = 0;
        this.col = 0;
        this.track = Direction.RIGHT;
        this.matrix = matrix();
    }

    /**
     * avec n entier positif ou nul, renvoyant sous forme de tableau HTML le
     * "colimaçon" tel que :
     *
     * printHtml(1): 1
     *
     * printHtml(2): 1 2 4 3
     *
     * printHtml(3): 1 2 3 8 9 4 7 6 5
     *
     * @return
     */
    public String printHtml() {
        checkInputLength();
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
        checkInputLength();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("\n");
            for (int j = 0; j < size; j++) {
                sb.append(" ");
                sb.append(matrix[i][j]);
            }//for
        }//for
        return sb.toString();
    }

    private void checkInputLength() throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("the size of the matrix must be positive");
        }
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
                sb.append("<td>");
                sb.append(matrix[i][j]);
                sb.append("</td>");
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
        for (i = 1; i < nb; i++) {
            matrix[row][col] = i;
            stepForward();
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
