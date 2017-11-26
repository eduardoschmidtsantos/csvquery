package interpreter.expression;

import bean.*;
import interpreter.Context;
import interpreter.evaluator.Evaluator;
import interpreter.filter.CountDistinctByPropertyFilterRow;
import interpreter.filter.FilterBuilder;

import java.util.List;

public class CountDistinctByPropertyExpression extends AbstractExpression {

    public static final String COUNT = "count";

    public CountDistinctByPropertyExpression(Evaluator evaluator) {
        super(evaluator);
    }

    @Override
    protected Document doExecute(Context context) {
        List list = FilterBuilder.aFilter()
                .setFilterRow(new CountDistinctByPropertyFilterRow())
                .setRows(context.getDocument().getRows())
                .setPropertyValue(new PropertyValue(evaluator.group(1)))
                .doFilter();

        int count = list.size();

        Document document = DocumentBuilder.aDocument()
                .addRow(Row.aRow().addProperty(COUNT, count))
                .addHeader(HeaderBuilder.aHeader().withHeader(COUNT).build())
                .build();

        return document;
    }
}
