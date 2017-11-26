package mapper;

import bean.Header;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvHeaderMapperTest {

    @Test
    public void testCsvHeaderWhenHeaderAreValidReturnRigthFormat(){
        CsvHeaderMapper mapper = new CsvHeaderMapper();
        List<Header> headers = mapper.to(new String[]{"name"});
        String header = headers.get(0).getHeader();
        assertEquals(header, "name");
    }

    @Test
    public void testCsvHeaderWhenHeaderEmptyReturnEmpty(){
        CsvHeaderMapper mapper = new CsvHeaderMapper();
        List<Header> headers = mapper.to(new String[]{});
        assertEquals(headers.size(), 0);
    }


}
