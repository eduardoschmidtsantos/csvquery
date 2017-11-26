package interpreter.filter;

import bean.PropertyValue;
import bean.Row;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterByPropertyAndValueFilterRowTest {

    @Test
    public void testFilterByPropertyAndValueWhenValueAreStringReturnValidData(){
        List<Row> rows = Arrays.asList(
                Row.aRow().addProperty("id", 1).addProperty("name", "Envolvido"),
                Row.aRow().addProperty("id", 2).addProperty("name", "Envolvido"),
                Row.aRow().addProperty("id", 3).addProperty("name", "Envolvido"),
                Row.aRow().addProperty("id", 4).addProperty("name", "Não Envolvido"),
                Row.aRow().addProperty("id", 5).addProperty("name", "Ser ou não ser Envolvido")
        );
        FilterByPropertyAndValueFilterRow filter = new FilterByPropertyAndValueFilterRow();
        List<Row> results = filter.doFilter(rows, new PropertyValue("name", "Envolvido"));
        assertEquals(results.size(), 3);
        assertEquals(results.get(0).getObject("name"), "Envolvido");
        assertEquals(results.get(0).getObject("name"), "Envolvido");
        assertEquals(results.get(0).getObject("name"), "Envolvido");
    }

    @Test
    public void testFilterByPropertyAndValueWhenValueAreEmptyReturnEmptyData(){
        List<Row> rows = Arrays.asList();
        FilterByPropertyAndValueFilterRow filter = new FilterByPropertyAndValueFilterRow();
        List<Row> results = filter.doFilter(rows, new PropertyValue("name", "Envolvido"));
        assertEquals(results.size(), 0);
    }
}
