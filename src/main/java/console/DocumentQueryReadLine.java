package console;

import bean.Document;

import java.util.Scanner;

public abstract class DocumentQueryReadLine {

    private DocumentSimplePrinter printer;

    public DocumentQueryReadLine(DocumentSimplePrinter printer) {
        this.printer = printer;
    }
    public abstract Document execute(String input);
    public void start() {
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter with your query : ");
            String input = in.nextLine();
            long start = System.currentTimeMillis();
            Document document = execute(input);
            long end = System.currentTimeMillis() - start;
            String print = printer.print(document);
            System.out.println(print);
            System.out.println("execution time: " + end + "ms");
        }
    }
}
