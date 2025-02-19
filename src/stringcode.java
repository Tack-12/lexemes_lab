import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class stringcode {
    private String filename;

    public void set_filename(String filename) {
        this.filename = filename;

    }

    public String get_filename() {

        return this.filename;
    }

    public  String read_line() {
        String line = "";
        final String filepath = this.filename;

        try {
            FileReader reader = new FileReader(filepath);
            int data = reader.read();
            while (data != -1) {
                line += (char) data;
                data = reader.read();
            }
            reader.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return  line ;
    }
}


