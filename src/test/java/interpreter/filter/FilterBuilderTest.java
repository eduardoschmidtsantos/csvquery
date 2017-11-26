package interpreter.filter;

import bean.PropertyValue;
import bean.Row;
import interpreter.evaluator.CountDistinctByPropertyEvaluator;
import interpreter.evaluator.FilterByPropertyAndValueEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterBuilderTest {

    @Test
    public void testFilterBuilderWhenRowsAreValidAndEvaluatorAreCountDistinctByPropertyReturnValidData(){
        List<Row> rows = Arrays.asList(
                Row.aRow().addProperty("name", "Envolvido"),
                Row.aRow().addProperty("name", "Envolvido"),
                Row.aRow().addProperty("name", "Envolvido"),
                Row.aRow().addProperty("name", "Não Envolvido"),
                Row.aRow().addProperty("name", "Ser ou não ser Envolvido"));

        CountDistinctByPropertyEvaluator evaluator = new CountDistinctByPropertyEvaluator();

        assertTrue(evaluator.matches("count distinct [name]"));

        List list = FilterBuilder.aFilter()
                .setFilterRow(new CountDistinctByPropertyFilterRow())
                .setRows(rows)
                .setPropertyValue(new PropertyValue(evaluator.group(1)))
                .doFilter();

        assertEquals(list.size(), 3);
    }

    @Test
    public void testFilterBuilderWhenRowsAreValidAndEvaluatorAreFilterByPropertyAndValueReturnValidData(){
        List<Row> rows = Arrays.asList(
                Row.aRow().addProperty("name", "Envolvido"),
                Row.aRow().addProperty("name", "Envolvido"),
                Row.aRow().addProperty("name", "Envolvido"),
                Row.aRow().addProperty("name", "Ser ou não ser Envolvido"));

        FilterByPropertyAndValueEvaluator evaluator = new FilterByPropertyAndValueEvaluator();
        assertTrue(evaluator.matches("filter [name] [Envolvido]"));

        List list = FilterBuilder.aFilter()
                .setFilterRow(new CountDistinctByPropertyFilterRow())
                .setRows(rows)
                .setPropertyValue(new PropertyValue(evaluator.group(1)))
                .doFilter();

        assertEquals(list.size(), 2);
    }

}
