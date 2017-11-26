package interpreter.evaluator;

public class FilterByPropertyAndValueEvaluator extends Evaluator {

    private static final String EXPRESSION = "filter\\s\\[(.*)]\\s\\[(.*)]";

    @Override
    public String getExpression() {
        return EXPRESSION;
    }
}
