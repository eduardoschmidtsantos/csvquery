package interpreter.filter;

import bean.PropertyValue;
import bean.Row;

import java.util.List;

public interface FilterRow<T> {
    List<T> doFilter(List<Row> rows, PropertyValue propertyValue);
}
