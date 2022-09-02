import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String path;
    private String line;
    private List<String> lines1 = new ArrayList<>();
    private List<String> lines2 = new ArrayList<>();

    public Reader(String path) {
        this.path = path;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            while ((line = br.readLine()) != null) {
                if(Utils.isDigit(line)){
                    lines1 = lines2;
                    lines2 = new ArrayList<>();
                    continue;
                }
                lines2.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLines1() {
        return lines1;
    }

    public List<String> getLines2() {
        return lines2;
    }
}
