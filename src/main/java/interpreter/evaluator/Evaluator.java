package interpreter.evaluator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Evaluator {

    private Matcher matcher;

    public boolean matches(String input) {
        Pattern replace = Pattern.compile(getExpression());
        matcher = replace.matcher(input);
        return matcher.matches();
    }

    public String group(int index){
        return matcher.group(index);
    }

    public abstract String getExpression();

}
