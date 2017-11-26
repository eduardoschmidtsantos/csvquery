package mapper;

import bean.Row;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvRowMapperTest {

    @Test
    public void testCsvRowMapperWhenIsOneRowsReturnOneRow(){
        CsvRowMapper mapper = new CsvRowMapper(new String[]{"name"});
        Row row = mapper.to(new String[]{"Envolvido"});
        assertEquals(row.getObject("name"), "Envolvido");
    }

    @Test
    public void testCsvRowMapperWhenRowsAreAnyReturnListWithAny(){
        CsvRowMapper mapper = new CsvRowMapper(new String[]{"name"});
        List<String[]> rowsOnArrays = new ArrayList();
        rowsOnArrays.add(new String[]{"Envolvido"});
        List<Row> rows = mapper.toAll(rowsOnArrays);
        assertEquals(rows.get(0).getObject("name"), "Envolvido");
    }

    @Test
    public void testCsvRowMapperWhenRowsAreEmptyReturnEmpty(){
        CsvRowMapper mapper = new CsvRowMapper(new String[]{});
        Row row = mapper.to(new String[]{});
        assertEquals(row.get().size(), 0);
    }


}
