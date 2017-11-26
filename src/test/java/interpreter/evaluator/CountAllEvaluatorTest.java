package interpreter.evaluator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountAllEvaluatorTest {

    @Test
    public void testCountAllWhenQueryAreValidReturnThatMatches(){
        String query = "count *";
        CountAllEvaluator evaluator = new CountAllEvaluator();
        assertTrue(evaluator.matches(query));
        assertEquals(evaluator.group(0), query);
    }

    @Test
    public void testCountAllWhenQueryAreInvalidReturnThatDontMatch(){
        String query = "count * from";
        CountAllEvaluator evaluator = new CountAllEvaluator();
        assertFalse(evaluator.matches(query));
    }

}
