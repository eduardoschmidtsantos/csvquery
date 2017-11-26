package bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Row {

  private Map content = new HashMap<String, Object>();

  public static Row aRow(){
    return new Row();
  }

  public Row addProperty(String key, Object value){
      content.put(key, value);
      return this;
  }

  public Object getObject(String key){
    return content.get(key);
  }

  public Set<Entry<String, String>> get(){
    return content.entrySet();
  }


}
