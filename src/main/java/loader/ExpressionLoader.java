package loader;

import interpreter.Context;
import interpreter.expression.AbstractExpression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionLoader {

    private List<AbstractExpression> expressions = new ArrayList<AbstractExpression>();

    public static ExpressionLoader create(){
        return new ExpressionLoader();
    }

    public ExpressionLoader add(AbstractExpression expression){
        expressions.add(expression);
        return this;
    }

    public void execute(Context context){
        for (AbstractExpression expression : expressions){
            expression.interpret(context);
        }
    }

    public List<AbstractExpression> getExpressions() {
        return expressions;
    }
}
