package day04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day04Part1 {

    public static void main(String[] args) throws IOException {
        
        HashMap<String, String> data = new HashMap<>();
        List<HashMap<String, String>> passports = new ArrayList<>();
        int requiredFields = 7;

        File file = new File("src/day04/Day04.txt");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
    
        try {
            String line;//= reader.readLine();
            while(reader.ready()){
                line = reader.readLine();
                 if(!line.isBlank()){
                    System.out.println("text found: " + line.toString());
                    String[] items = line.split(" ");
                    
                    for(String item : items){
                        String[] keyValue = item.split(":");
                        String key = keyValue[0];
                        String value = keyValue[1];
                        data.put(key, value);
                    }
                } else {
                    System.out.println("blank line found, adding data: " + data.toString());
                    passports.add(data);
                    data = new HashMap<>();
                }
            }
            passports.add(data);
            System.out.println("passports: " + passports.toString());
            
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file into arrayList");
            e.printStackTrace();
        } finally {
            if(reader != null) reader.close();
        }

        int valid = 0;
        for(HashMap<String, String> passport : passports){
            if(passport.containsKey("cid"))
                passport.remove("cid");
            if(passport.size() == requiredFields)
                valid++;
        }

        System.out.println("valid passports: " + valid);
    }

}
