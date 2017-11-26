package common;

import exception.CantReadException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private static final String COMMA = ",";
    private String line;

    private final String file;

    public CsvReader(String file){
        this.file = file;
    }

    public List<String[]> load(){
        List<String[]> objects = new ArrayList<String[]>();
        try {
            BufferedReader buffered = new BufferedReader(new FileReader(file));
            while ((line = buffered.readLine()) != null) {
                String[] object = line.split(COMMA);
                objects.add(object);
            }
        } catch (FileNotFoundException e) {
            throw new CantReadException("file not found");
        } catch (IOException e) {
            throw new CantReadException("file cant be read");
        }
        return objects;
    }
}
