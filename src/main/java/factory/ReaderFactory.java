package factory;

import reader.Reader;
import reader.CsvDocumentReader;
import reader.XmlDocumentReader;

public class ReaderFactory {

    public static Reader createForCsv(String file){
        return new CsvDocumentReader(file);
    }

    public static Reader createForXml(String file){
        return new XmlDocumentReader();
    }

}
