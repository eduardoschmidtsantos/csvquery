package reader;

import bean.Document;
import bean.Header;
import bean.Row;
import common.CsvReader;
import java.util.List;
import mapper.CsvHeaderMapper;
import mapper.CsvRowMapper;

public class CsvDocumentReader implements Reader {

    private final String file;

    public CsvDocumentReader(String file){
        this.file = file;
    }

    public Document getDocument() {
        CsvReader reader = new CsvReader(file);
        List<String[]> objects = reader.load();
        String[] labels = objects.get(0);
        objects.remove(0);
        List<Row> rows = new CsvRowMapper(labels).toAll(objects);
        List<Header> headers = new CsvHeaderMapper().to(labels);
        return new Document(headers, rows);
    }
}
