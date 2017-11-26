package interpreter.evaluator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterByPropertyAndValueEvaluatorTest {

    @Test
    public void testFilterByPropertyAndValueWhenQueryAreValidReturnThatMatches(){
        String query = "filter [uf] [RO]";
        FilterByPropertyAndValueEvaluator evaluator = new FilterByPropertyAndValueEvaluator();
        assertTrue(evaluator.matches(query));
        assertEquals(evaluator.group(0), query);
        assertEquals(evaluator.group(1), "uf");
        assertEquals(evaluator.group(2), "RO");
    }

    @Test
    public void testFilterByPropertyAndValueWhenQueryHasSpacesReturnValidParameters(){
        String query = "filter [uf] [Monte Carlo]";
        FilterByPropertyAndValueEvaluator evaluator = new FilterByPropertyAndValueEvaluator();
        assertTrue(evaluator.matches(query));
        assertEquals(evaluator.group(0), query);
        assertEquals(evaluator.group(1), "uf");
        assertEquals(evaluator.group(2), "Monte Carlo");
    }

    @Test
    public void testFilterByPropertyAndValueWhenQueryAreInvalidReturnThatDontMatch(){
        String query = "filter uf RO";
        FilterByPropertyAndValueEvaluator evaluator = new FilterByPropertyAndValueEvaluator();
        assertFalse(evaluator.matches(query));
    }

}
