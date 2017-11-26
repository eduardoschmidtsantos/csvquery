package interpreter.evaluator;

public class CountAllEvaluator extends Evaluator {

    private static final String EXPRESSION = "^(count\\s\\*)";

    @Override
    public String getExpression() {
        return EXPRESSION;
    }
}
