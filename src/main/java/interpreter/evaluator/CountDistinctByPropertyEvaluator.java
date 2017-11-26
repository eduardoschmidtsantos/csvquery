package interpreter.evaluator;

public class CountDistinctByPropertyEvaluator extends Evaluator {

    private static final String EXPRESSION = "count\\sdistinct\\s\\[(.*)\\]";

    @Override
    public String getExpression() {
        return EXPRESSION;
    }
}
