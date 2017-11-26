package reader;

import exception.CantReadException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CsvDocumentReaderTest {

    @Test
    public void testCsvDocumentReaderWhenFileAreValidReturnValidReader(){
        CsvDocumentReader csvDocumentReader = new CsvDocumentReader("test.csv");
        assertEquals(csvDocumentReader.getDocument().getHeaders().size(), 10);
        assertEquals(csvDocumentReader.getDocument().getRows().size(), 1);
    }

    @Test
    public void testCsvDocumentReaderWhenFileAreInvalidReturException(){
        try {
            CsvDocumentReader csvDocumentReader = new CsvDocumentReader("invalid.csv");
            assertEquals(csvDocumentReader.getDocument().getHeaders().size(), 10);
            assertEquals(csvDocumentReader.getDocument().getRows().size(), 1);
            fail("invalid file cant open");
        } catch (CantReadException e){}
    }


}
