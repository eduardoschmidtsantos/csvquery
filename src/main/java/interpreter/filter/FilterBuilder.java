package interpreter.filter;

import bean.PropertyValue;
import bean.Row;

import java.util.List;

public class FilterBuilder<T> {

    private FilterRow filterRow;
    private PropertyValue propertyValue;
    private List<Row> rows;

    public FilterBuilder setRows(List<Row> rows) {
        this.rows = rows;
        return this;
    }

    public FilterBuilder setPropertyValue(PropertyValue propertyValue) {
        this.propertyValue = propertyValue;
        return this;
    }

    public FilterBuilder setFilterRow(FilterRow filterRow){
        this.filterRow = filterRow;
        return this;
    }

    public static FilterBuilder aFilter() {
        return new FilterBuilder();
    }

    public List doFilter() {
        return filterRow.doFilter(rows, propertyValue);
    }
}
