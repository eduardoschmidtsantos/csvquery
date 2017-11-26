package interpreter.expression;

import bean.Document;
import cache.CacheManager;
import interpreter.Context;
import interpreter.evaluator.Evaluator;

public abstract class AbstractExpression {

    public Evaluator evaluator;

    public AbstractExpression(Evaluator evaluator){
        this.evaluator = evaluator;
    }

    public void interpret(Context context){
        if(!evaluator.matches(context.getQuery())) return;
        //improve performance
        Document cachedDocument = CacheManager.getInstance().get(context.getQuery());
        if(cachedDocument != null){ context.setOutput(cachedDocument); return; }
        Document document = doExecute(context);
        CacheManager.getInstance().add(context.getQuery(), document);
        context.setOutput(document);
    }

    public Evaluator getEvaluator() {
        return evaluator;
    }

    /**
     * Executor are called after that evaluator are valid for this expression
     * @param context
     */
    protected abstract Document doExecute(Context context);


}
