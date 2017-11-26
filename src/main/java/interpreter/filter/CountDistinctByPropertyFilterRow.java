package interpreter.filter;

import bean.PropertyValue;
import bean.Row;

import java.util.ArrayList;
import java.util.List;

public class CountDistinctByPropertyFilterRow implements FilterRow<Object> {

    public List<Object> doFilter(List<Row> rows, PropertyValue propertyValue){
        List<Object> values = new ArrayList();
        for (Row row : rows){
            Object object = row.getObject(propertyValue.getProperty());
            Boolean has = values.contains(object);
            if(!has) values.add(object);
        }
        return values;
    }
}
