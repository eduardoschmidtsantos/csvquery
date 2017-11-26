package mapper;

import bean.Row;

public class CsvRowMapper extends Mapper<String[], Row> {

    private String[] headers;

    public CsvRowMapper(String[] headers){
        this.headers = headers;
    }

    public Row to(String[] object) {
        Row row = new Row();
        for (int i = 0; i < headers.length; i++) {
            String value = object[i];
            String key = headers[i];
            row.addProperty(key, value);
        }
        return row;
    }
}
