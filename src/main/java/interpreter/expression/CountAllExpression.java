package interpreter.expression;

import bean.*;
import interpreter.Context;
import interpreter.evaluator.Evaluator;

import java.util.List;

public class CountAllExpression extends AbstractExpression {

    public static final String COUNT = "count";

    public CountAllExpression(Evaluator evaluator) {
        super(evaluator);
    }

    @Override
    protected Document doExecute(Context context) {
        List rows = context.getDocument().getRows();
        int count = rows.size();

        Document document = DocumentBuilder.aDocument()
                .addRow(Row.aRow().addProperty(COUNT, count))
                .addHeader(HeaderBuilder.aHeader().withHeader(COUNT).build())
                .build();

        return document;
    }
}
