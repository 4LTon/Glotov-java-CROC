import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        try (FileWriter writer = new FileWriter("example.txt", false)) {

            writer.write("Hello, World!");
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
