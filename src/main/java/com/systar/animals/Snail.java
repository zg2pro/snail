package com.systar.animals;

enum Direction {

    RIGHT,
    DOWN,
    LEFT,
    UP;
}

/**
 * Object representing a snail of numbers
 *
 */
public class Snail {

    private int size;
    private int[][] array;
    private int row, col;
    private Direction track;

    /**
     * 
     * @param size: is the width or height of the table
     */
    public Snail(int size) {
	this.size = size;
	this.array = new int[size][size];
	this.row = 0;
	this.col = 0;
	this.track = Direction.RIGHT;
	this.array = getArray();
    }

    /**
     * avec n entier positif ou nul, renvoyant sous forme de tableau HTML le
     * "colimaçon" tel que :
     *
     * snail(1): 1
     *
     * snail(2): 1 2 4 3
     *
     * snail(3): 1 2 3 8 9 4 7 6 5
     *
     * @return
     */
    public String snail() throws Exception {
	if (size < 0) {
	    throw new Exception("beware: illicit parameter");
	}
	StringBuilder sb = new StringBuilder();
	sb.append("<table border=\"1\">");
	sb.append(printBody());
	sb.append("</table>");
	return sb.toString();
    }

    /**
     * for standard output printing
     * @return built String with HTML table
     */
    public String easyPrint() throws Exception {
	if (size < 0) {
	    throw new Exception("beware: illicit parameter");
	}
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < size; i++) {
	    sb.append("\n");
	    for (int j = 0; j < size; j++) {
		sb.append(" ");
		sb.append(array[i][j]);
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
		sb.append("<td>");
		sb.append(array[i][j]);
		sb.append("</td>");
	    }
	    sb.append("</tr>");
	}
	return sb.toString();
    }

    /**
     * table construction
     */
    private int[][] getArray() {
	int nb = size * size;
	int i = 1;
	for (i = 1; i < nb; i++) {
	    array[row][col] = i;
	    testSnail();
	}
	array[row][col] = i;
	return array;
    }

    /**
     * recursion to determinate the direction to walk through the snail
     */
    private void testSnail() {
	if (track.equals(Direction.RIGHT)) {
	    if (col + 1 < size && array[row][col + 1] == 0) {
		col++;
	    } else {
		track = Direction.DOWN;
	    }
	}
	if (track.equals(Direction.DOWN)) {
	    if (row + 1 < size && array[row + 1][col] == 0) {
		row++;
	    } else {
		track = Direction.LEFT;
	    }
	}
	if (track.equals(Direction.LEFT)) {
	    if (col - 1 > -1 && array[row][col - 1] == 0) {
		col--;
	    } else {
		track = Direction.UP;
	    }
	}
	if (track.equals(Direction.UP)) {
	    if (row - 1 > -1 && array[row - 1][col] == 0) {
		row--;
	    } else {
		track = Direction.RIGHT;
		testSnail();
	    }
	}
    }
}
