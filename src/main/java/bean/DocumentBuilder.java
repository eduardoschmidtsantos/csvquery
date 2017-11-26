package bean;

import java.util.ArrayList;
import java.util.List;

public final class DocumentBuilder {

    private List<Row> rows = new ArrayList<Row>();
    private List<Header> headers = new ArrayList<Header>();

    private DocumentBuilder() {
    }

    public static DocumentBuilder aDocument() {
        return new DocumentBuilder();
    }

    public DocumentBuilder addRow(Row row) {
        this.rows.add(row);
        return this;
    }

    public DocumentBuilder addRows(List<Row> rows) {
        this.rows.addAll(rows);
        return this;
    }

    public DocumentBuilder addHeaders(List<Header> headers) {
        this.headers.addAll(headers);
        return this;
    }

    public DocumentBuilder addHeader(Header headers) {
        this.headers.add(headers);
        return this;
    }

    public Document build() {
        Document document = new Document();
        document.setRows(rows);
        document.setHeaders(headers);
        return document;
    }
}
