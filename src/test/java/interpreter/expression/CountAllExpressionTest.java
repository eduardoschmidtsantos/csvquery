package interpreter.expression;

import bean.Document;
import bean.Header;
import bean.HeaderBuilder;
import bean.Row;
import interpreter.Context;
import interpreter.evaluator.CountAllEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAllExpressionTest {

    @Test
    public void testCountAllWhenRowsAreValidAndQueryAreValidReturnValidCount(){
        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());
        Document document = new Document(headers, rows);
        Context context = new Context(document, "count *");
        new CountAllExpression(new CountAllEvaluator()).interpret(context);
        assertEquals(context.getOutput().getHeaders().get(0).getHeader(), "count");
        assertEquals(context.getOutput().getRows().get(0).getObject("count"), 1);
    }

    @Test
    public void testCountAllWhenRowsAreValidAndQueryAreInvalidReturnEmptyValues(){
        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());
        Document document = new Document(headers, rows);
        Context context = new Context(document, "count all *");
        new CountAllExpression(new CountAllEvaluator()).interpret(context);
        assertEquals(context.getOutput().getRows().size(), 0);
        assertEquals(context.getOutput().getHeaders().size(), 0);
    }

}
