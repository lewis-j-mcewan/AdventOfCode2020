package helperClasses;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadFile {
    public static List<String> FileToString(String loc) throws IOException {
        File file = new File(loc);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return new ArrayList<String>();
        }
    
        List<String> input = new ArrayList<>();
        try {
            String line;
            while((line = reader.readLine()) != null){
                input.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file into arrayList");
            e.printStackTrace();
        } finally {
            if(reader != null) reader.close();
        }
        
        return input;
    }

}
