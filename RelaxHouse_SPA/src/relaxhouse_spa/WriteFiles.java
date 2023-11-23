package relaxhouse_spa;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class WriteFiles {

    private Formatter output;

    public void openTextFile(String fileName) {
        try {
            output = new Formatter(fileName);
        } catch (SecurityException ex) {
            System.err.println("You do not have write access to this file.");

        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");

        }
    }

    public void writeToFile(Service s) {

        try {
            output.format("%s", s);
        } catch (FormatterClosedException ex) {
            System.err.println("Error writing to file");
        }
    }

    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }
}
