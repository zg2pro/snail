package com.systar.printers;

import com.systar.animals.ISnail;

/**
 * Object with methods to generate plain text or html nailed matrix
 *
 */
public class SnailPrinter {

    private ISnail snail;

    /**
     *
     * @param snail
     */
    public SnailPrinter(ISnail snail) {
        if (snail == null) {
            throw new IllegalArgumentException("the size of the matrix must be strictly positive");
        }
        this.snail = snail;
    }

    /**
     * with a null or positive n, returns the snail in html
     *
     * printHtml(1): 1 printHtml(2): 1 2 4 3 printHtml(3): 1 2 3 8 9 4 7 6 5
     *
     * @return
     */
    public String printHtml() {
        StringBuilder sb = new StringBuilder("<table border=\"1\">");
        sb.append(printHtmlTableBody())
                .append("</table>").toString();
        return sb.toString();
    }

    /**
     *
     * @param size
     * @return built String with tr and td
     */
    private String printHtmlTableBody() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < snail.getMatrix().length; i++) {
            sb.append("<tr>");
            for (int j = 0; j < snail.getMatrix().length; j++) {
                sb.append("<td>")
                        .append(snail.getMatrix()[i][j])
                        .append("</td>");
            }
            sb.append("</tr>");
        }
        return sb.toString();
    }

    /**
     * for standard output printing
     *
     * @return built String
     */
    public String printPlainText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < snail.getMatrix().length; i++) {
            if (i > 0) {
                sb.append("\n");
            }
            for (int j = 0; j < snail.getMatrix().length; j++) {
                if (j > 0) {
                    sb.append(" ");
                }
                sb.append(snail.getMatrix()[i][j]);
            }//for
        }//for
        return sb.toString();
    }

}
