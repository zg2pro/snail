package com.systar.animals;

/**
 * Object with methods to generate plain text or html nailed matrix
 *
 */
public class Snail {

    private int size;
    private int[][] matrix;
    private int row, col;
    private Direction track;

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
                goRight();
                break;
            case DOWN:
                goDown();
                break;
            case LEFT:
                goLeft();
                break;
            case UP:
                goUp();
                break;
            default:
                break;
        }
    }

    private void goUp() {
        if (row - 1 > -1 && matrix[row - 1][col] == 0) {
            row--;
        } else {
            track = Direction.RIGHT;
            stepForward();
        }
    }

    private void goLeft() {
        if (col - 1 > -1 && matrix[row][col - 1] == 0) {
            col--;
        } else {
            track = Direction.UP;
        }
    }

    private void goDown() {
        if (row + 1 < size && matrix[row + 1][col] == 0) {
            row++;
        } else {
            track = Direction.LEFT;
        }
    }

    private void goRight() {
        if (col + 1 < size && matrix[row][col + 1] == 0) {
            col++;
        } else {
            track = Direction.DOWN;
        }
    }

    /**
     *
     * @param size: is the width or height of the table
     */
    public Snail(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("the size of the matrix must be strictly positive");
        }
        this.size = size;
        this.matrix = new int[size][size];
        this.row = 0;
        this.col = 0;
        this.track = Direction.RIGHT;
        this.matrix = matrix();
    }

    public int[][] getMatrix() {
        return matrix;
    }
    
}
