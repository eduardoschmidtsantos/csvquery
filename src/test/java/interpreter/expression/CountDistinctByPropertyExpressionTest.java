package interpreter.expression;

import bean.Document;
import bean.Header;
import bean.HeaderBuilder;
import bean.Row;
import interpreter.Context;
import interpreter.evaluator.CountDistinctByPropertyEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDistinctByPropertyExpressionTest {

    @Test
    public void testCountDistinctByPropertyWhenRowsAreValidAndQueryAreValidReturnValidCount(){
        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());
        Document document = new Document(headers, rows);
        Context context = new Context(document, "count distinct [name]");
        new CountDistinctByPropertyExpression(new CountDistinctByPropertyEvaluator()).interpret(context);
        assertEquals(context.getOutput().getHeaders().get(0).getHeader(), "count");
        assertEquals(context.getOutput().getRows().get(0).getObject("count"), 1);
    }

    @Test
    public void testCountDistinctByPropertyWhenRowsAreValidAndQueryAreInvalidReturnEmptyValues(){
        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());
        Document document = new Document(headers, rows);
        Context context = new Context(document, "count distinct *");
        new CountDistinctByPropertyExpression(new CountDistinctByPropertyEvaluator()).interpret(context);
        assertEquals(context.getOutput().getRows().size(), 0);
        assertEquals(context.getOutput().getHeaders().size(), 0);
    }

}
