package common;

import exception.CantReadException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CsvReaderTest {

    @Test
    public void testCsvReaderWhenFileAreValidReturnDataFromFile(){
        CsvReader csvReader = new CsvReader("test.csv");
        List<String[]> data = csvReader.load();
        assertEquals(data.size(), 2);
    }

    @Test
    public void testCsvReaderWhenFileAreValidReturnException(){
        try {
            CsvReader csvReader = new CsvReader("invalid.csv");
            csvReader.load();
            fail("invalid file cant open");
        } catch (CantReadException e){}
    }

}
