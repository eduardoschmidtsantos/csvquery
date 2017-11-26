package bean;

import java.util.ArrayList;
import java.util.List;

public class Document {

  private List<Row> rows;
  private List<Header> headers;

  public Document(){
    this.headers = new ArrayList<Header>();
    this.rows = new ArrayList<Row>();
  }

  public Document(List<Header> headers, List<Row> rows) {
    this.headers = headers;
    this.rows = rows;
  }

  public List<Row> getRows() {
    return rows;
  }

  public void setRows(List<Row> rows) {
    this.rows = rows;
  }

  public List<Header> getHeaders() {
    return headers;
  }

  public void setHeaders(List<Header> headers) {
    this.headers = headers;
  }
}
