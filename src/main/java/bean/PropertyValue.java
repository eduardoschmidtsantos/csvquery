package bean;

public class PropertyValue {
    private String property;
    private String value;

    public PropertyValue(String property){
        this.property = property;
    }

    public PropertyValue(String property, String value){
        this.value = value;
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
