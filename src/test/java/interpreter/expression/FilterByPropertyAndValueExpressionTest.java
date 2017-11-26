package interpreter.expression;

import bean.Document;
import bean.Header;
import bean.HeaderBuilder;
import bean.Row;
import interpreter.Context;
import interpreter.evaluator.FilterByPropertyAndValueEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterByPropertyAndValueExpressionTest {

    @Test
    public void testFilterByPropertyAndValueWhenRowsAreValidAndQueryAreValidReturnValidData(){
        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());
        Document document = new Document(headers, rows);
        Context context = new Context(document, "filter [name] [envolvido]");
        new FilterByPropertyAndValueExpression(new FilterByPropertyAndValueEvaluator()).interpret(context);
        assertEquals(context.getOutput().getHeaders().get(0).getHeader(), "name");
        assertEquals(context.getOutput().getRows().get(0).getObject("name"), "envolvido");
    }

    @Test
    public void testFilterByPropertyAndValueWhenRowsAreValidAndQueryAreInvalidReturnEmptyValues(){
        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());
        Document document = new Document(headers, rows);
        Context context = new Context(document, "filter name envolvido");
        new FilterByPropertyAndValueExpression(new FilterByPropertyAndValueEvaluator()).interpret(context);
        assertEquals(context.getOutput().getRows().size(), 0);
        assertEquals(context.getOutput().getHeaders().size(), 0);
    }

}
