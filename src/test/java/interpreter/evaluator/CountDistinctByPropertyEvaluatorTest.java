package interpreter.evaluator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountDistinctByPropertyEvaluatorTest {

    @Test
    public void testCountDistinctByPropertyWhenQueryAreValidReturnThatMatches(){
        String query = "count distinct [name]";
        CountDistinctByPropertyEvaluator evaluator = new CountDistinctByPropertyEvaluator();
        assertTrue(evaluator.matches(query));
        assertEquals(evaluator.group(0), query);
        assertEquals(evaluator.group(1), "name");
    }

    @Test
    public void testCountDistinctByPropertyWhenQueryAreInvalidReturnThatDontMatch(){
        String query = "count distinct name";
        CountDistinctByPropertyEvaluator evaluator = new CountDistinctByPropertyEvaluator();
        assertFalse(evaluator.matches(query));
    }

}
