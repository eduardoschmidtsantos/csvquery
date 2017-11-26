import bean.Document;
import console.DocumentSimplePrinter;
import console.DocumentQueryReadLine;
import interpreter.Context;
import interpreter.evaluator.CountAllEvaluator;
import interpreter.evaluator.CountDistinctByPropertyEvaluator;
import interpreter.evaluator.FilterByPropertyAndValueEvaluator;
import interpreter.expression.*;
import loader.ExpressionLoader;
import reader.Reader;
import factory.ReaderFactory;

public class Client {

    public static void main(String[] args){
        Reader reader = ReaderFactory.createForCsv("cidades.csv");
        final Document document = reader.getDocument();

        final ExpressionLoader loader = ExpressionLoader
                .create()
                .add(new CountAllExpression(new CountAllEvaluator()))
                .add(new CountDistinctByPropertyExpression(new CountDistinctByPropertyEvaluator()))
                .add(new FilterByPropertyAndValueExpression(new FilterByPropertyAndValueEvaluator()));

        new DocumentQueryReadLine(new DocumentSimplePrinter()) {
            @Override
            public Document execute(String input) {
                Context context = new Context(document, input);
                loader.execute(context);
                return context.getOutput();
            }
        }.start();
    }
}
