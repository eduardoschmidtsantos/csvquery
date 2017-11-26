package interpreter.filter;

import bean.PropertyValue;
import bean.Row;

import java.util.ArrayList;
import java.util.List;

public class FilterByPropertyAndValueFilterRow implements FilterRow<Row> {

    public List<Row> doFilter(List<Row> rows, PropertyValue propertyValue){
        List<Row> filtered = new ArrayList<Row>();
        for (Row row : rows){
            Object val = row.getObject(propertyValue.getProperty());
            Boolean evaluated = propertyValue.getValue().equals(val);
            if(evaluated) {
                filtered.add(row);
            }
        }
        return filtered;
    }
}
