package mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<T, U>  {

    public abstract U to(T object);

    public List<U> toAll(List<T> objects){
        List<U> objectsList = new ArrayList<U>();
        for (int i = 0; i < objects.size(); i++) {
            objectsList.add(to(objects.get(i)));
        }
        return objectsList;
    }

}
