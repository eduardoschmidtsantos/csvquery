package loader;

import bean.Document;
import bean.Header;
import bean.HeaderBuilder;
import bean.Row;
import interpreter.Context;
import interpreter.evaluator.CountAllEvaluator;
import interpreter.evaluator.CountDistinctByPropertyEvaluator;
import interpreter.evaluator.FilterByPropertyAndValueEvaluator;
import interpreter.expression.CountAllExpression;
import interpreter.expression.CountDistinctByPropertyExpression;
import interpreter.expression.FilterByPropertyAndValueExpression;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionLoaderTest {

    @Test
    public void testQuantityExpressionLoadedWhenExpressionAreAddedReturnValidQuantity(){
        ExpressionLoader loader = ExpressionLoader.create()
            .add(new CountAllExpression(new CountAllEvaluator()))
            .add(new CountDistinctByPropertyExpression(new CountDistinctByPropertyEvaluator()))
            .add(new FilterByPropertyAndValueExpression(new FilterByPropertyAndValueEvaluator()));

        assertEquals(loader.getExpressions().size(), 3);
    }
    @Test
    public void testCountAllExecutionWhenExpressionAreAddedReturnValidDocument(){
        ExpressionLoader loader = ExpressionLoader.create()
            .add(new CountAllExpression(new CountAllEvaluator()))
            .add(new CountDistinctByPropertyExpression(new CountDistinctByPropertyEvaluator()))
            .add(new FilterByPropertyAndValueExpression(new FilterByPropertyAndValueEvaluator()));


        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());

        Document document = new Document(headers, rows);
        Context context = new Context(document, "count *");
        loader.execute(context);

        Document output = context.getOutput();
        assertEquals(output.getHeaders().size(), 1);
        assertEquals(output.getRows().size(), 1);
    }

    @Test
    public void testCountDistinctByPropertyExecutionWhenExpressionAreAddedReturnValidDocument(){
        ExpressionLoader loader = ExpressionLoader.create()
            .add(new CountAllExpression(new CountAllEvaluator()))
            .add(new CountDistinctByPropertyExpression(new CountDistinctByPropertyEvaluator()))
            .add(new FilterByPropertyAndValueExpression(new FilterByPropertyAndValueEvaluator()));


        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());

        Document document = new Document(headers, rows);
        Context context = new Context(document, "count distinct [name]");
        loader.execute(context);

        Document output = context.getOutput();
        assertEquals(output.getHeaders().size(), 1);
        assertEquals(output.getRows().size(), 1);
    }

    @Test
    public void testFilterByPropertyAndValueExecutionWhenExpressionAreAddedReturnValidDocument(){
        ExpressionLoader loader = ExpressionLoader.create()
            .add(new CountAllExpression(new CountAllEvaluator()))
            .add(new CountDistinctByPropertyExpression(new CountDistinctByPropertyEvaluator()))
            .add(new FilterByPropertyAndValueExpression(new FilterByPropertyAndValueEvaluator()));


        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());

        Document document = new Document(headers, rows);
        Context context = new Context(document, "filter [name] [envolvido]");
        loader.execute(context);

        Document output = context.getOutput();
        assertEquals(output.getHeaders().size(), 1);
        assertEquals(output.getRows().size(), 1);
    }

    @Test
    public void testExecutionWhenNoneExpressionAreAddedReturnEmptyDocument(){
        ExpressionLoader loader = ExpressionLoader.create();

        List<Row> rows = Arrays.asList(Row.aRow().addProperty("name", "envolvido"));
        List<Header> headers = Arrays.asList(HeaderBuilder.aHeader().withHeader("name").build());

        Document document = new Document(headers, rows);
        Context context = new Context(document, "count *");
        loader.execute(context);

        Document output = context.getOutput();
        assertEquals(output.getHeaders().size(), 0);
        assertEquals(output.getRows().size(), 0);
    }


}
