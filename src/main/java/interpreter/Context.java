package interpreter;

import bean.Document;

public class Context {

    private String query;
    private Document output = new Document();
    private Document document;

    public Context(Document document, String query){
        this.query = query;
        this.document = document;
    }

    public String getQuery() {
        return query;
    }

    public Document getOutput() {
        return output;
    }

    public void setOutput(Document output) {
        this.output = output;
    }

    public Document getDocument() {
        return document;
    }

}
