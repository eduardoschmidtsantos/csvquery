package interpreter.filter;

import bean.PropertyValue;
import bean.Row;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDistinctByPropertyFilterRowTest {

    @Test
    public void testCountDistinctByPropertyWhenValueAreStringReturnValidData(){
        List<Row> rows = Arrays.asList(
                            Row.aRow().addProperty("name", "Envolvido"),
                            Row.aRow().addProperty("name", "Envolvido"),
                            Row.aRow().addProperty("name", "Envolvido"),
                            Row.aRow().addProperty("name", "Não Envolvido"),
                            Row.aRow().addProperty("name", "Ser ou não ser Envolvido")
                         );
        CountDistinctByPropertyFilterRow filter = new CountDistinctByPropertyFilterRow();
        List<Object> results = filter.doFilter(rows, new PropertyValue("name"));
        assertEquals(results.size(), 3);
    }

    @Test
    public void testCountDistinctByPropertyWhenValueAreIntegerReturnValidData(){
        List<Row> rows = Arrays.asList(
                Row.aRow().addProperty("age", 28),
                Row.aRow().addProperty("age", 28),
                Row.aRow().addProperty("age", 29),
                Row.aRow().addProperty("age", 29),
                Row.aRow().addProperty("age", 1)
        );
        CountDistinctByPropertyFilterRow filter = new CountDistinctByPropertyFilterRow();
        List<Object> results = filter.doFilter(rows, new PropertyValue("age"));
        assertEquals(results.size(), 3);
    }

    @Test
    public void testCountDistinctByPropertyWhenValueAreEmptyReturnEmptyData(){
        List<Row> rows = new ArrayList<Row>();
        CountDistinctByPropertyFilterRow filter = new CountDistinctByPropertyFilterRow();
        List<Object> results = filter.doFilter(rows, new PropertyValue("anyproperty"));
        assertEquals(results.size(), 0);
    }

}
