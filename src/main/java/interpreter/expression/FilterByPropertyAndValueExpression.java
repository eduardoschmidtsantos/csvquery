package interpreter.expression;

import bean.Document;
import bean.DocumentBuilder;
import bean.PropertyValue;
import interpreter.Context;
import interpreter.evaluator.Evaluator;
import interpreter.filter.FilterBuilder;
import interpreter.filter.FilterByPropertyAndValueFilterRow;
import java.util.List;

public class FilterByPropertyAndValueExpression extends AbstractExpression {

    public FilterByPropertyAndValueExpression(Evaluator evaluator) {
        super(evaluator);
    }

    @Override
    protected Document doExecute(Context context) {
        List rows = FilterBuilder.aFilter()
                .setFilterRow(new FilterByPropertyAndValueFilterRow())
                .setRows(context.getDocument().getRows())
                .setPropertyValue(new PropertyValue(evaluator.group(1),evaluator.group(2)))
                .doFilter();

        Document document = DocumentBuilder.aDocument()
                .addHeaders(context.getDocument().getHeaders())
                .addRows(rows)
                .build();
        return document;
    }
}
