package console;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bean.Document;
import bean.Header;
import bean.HeaderBuilder;
import bean.Row;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DocumentSimplePrinterTest {

  @Test
  public void testSimplePrinterWhenRowsAreValidReturnValidOutput(){
    List<Row> rows = Arrays.asList(
        Row.aRow().addProperty("name", "envolvido"),
        Row.aRow().addProperty("name", "envolvido"));
    List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());
    Document document = new Document(headers, rows);
    DocumentSimplePrinter documentSimplePrinter = new DocumentSimplePrinter();
    String output = documentSimplePrinter.print(document);

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("name | \n");
    stringBuilder.append("envolvido | \n");
    stringBuilder.append("envolvido | ");

    assertEquals(stringBuilder.toString(), output);
  }

}
