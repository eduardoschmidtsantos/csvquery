package mapper;

import bean.Header;
import java.util.ArrayList;
import java.util.List;

public class CsvHeaderMapper extends Mapper<String[], List<Header>> {

    public List<Header> to(String[] object) {
        List<Header> headers = new ArrayList<Header>();
        for (int i = 0; i < object.length; i++) {
            Header row = new Header();
            row.setHeader(object[i]);
            headers.add(row);
        }
        return headers;
    }
}
