package console;

import bean.Document;
import bean.Header;
import bean.Row;

public class DocumentSimplePrinter implements Printer {

    public static final String VERTICAL_BAR = " | ";
    public static final String BROKEN_LINE = "\n";

    public String print(Document output) {
        String headers = getPrintableHeader(output);
        String rows = getPrintableRows(output);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(headers);
        stringBuilder.append(rows);
        return stringBuilder.toString();
    }

    private String getPrintableRows(Document output) {
        StringBuilder outBuilder = new StringBuilder();
        for (Row row : output.getRows()){
            outBuilder.append(BROKEN_LINE);
            for (Header header : output.getHeaders()){
                outBuilder.append(row.getObject(header.getHeader())).append(VERTICAL_BAR);
            }
        }
        return outBuilder.toString();
    }

    private String getPrintableHeader(Document output) {
        StringBuilder headerOutput = new StringBuilder();
        for (Header header : output.getHeaders()){
            headerOutput.append(header.getHeader()).append(VERTICAL_BAR);

        }
        return headerOutput.toString();
    }

}
