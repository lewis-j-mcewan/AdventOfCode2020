package days.day04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day04Part2 {

    public static void main(String[] args) throws IOException {
        
        HashMap<String, String> data = new HashMap<>();
        List<HashMap<String, String>> passports = new ArrayList<>();
        int requiredFields = 7;

        File file = new File("src/days/day04/Day04.txt");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
    
        try {
            String line;
            while(reader.ready()){
                line = reader.readLine();
                 if(!line.isBlank()){
                    String[] items = line.split(" ");
                    
                    for(String item : items){
                        String[] keyValue = item.split(":");
                        String key = keyValue[0];
                        String value = keyValue[1];
                        data.put(key, value);
                    }
                } else {
                    passports.add(data);
                    data = new HashMap<>();
                }
            }
            passports.add(data);
            
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file into arrayList");
            e.printStackTrace();
        } finally {
            if(reader != null) reader.close();
        }

        int valid = 0;
        for(HashMap<String, String> passport : passports){
            if(validatePassport(requiredFields, passport))
                valid++;
        }
        System.out.println("valid passports: " + valid);
    }

    private static Boolean validatePassport(int requiredFields, HashMap<String, String> passport){
        if(passport.containsKey("cid")) passport.remove("cid");
        if(passport.size() != requiredFields) return false;

        int byr = Integer.parseInt(passport.get("byr"));
        int iyr = Integer.parseInt(passport.get("iyr"));
        int eyr = Integer.parseInt(passport.get("eyr"));
        String hgt = passport.get("hgt");
        String hcl = passport.get("hcl");
        String ecl = passport.get("ecl");
        String pid = passport.get("pid");

        if(byr < 1920 || byr > 2002) return false;  
        if(iyr < 2010 || iyr > 2020) return false;
        if(eyr < 2020 || eyr > 2030) return false;
        if(!hgt.endsWith("cm") && !hgt.endsWith("in")) return false;
        if(!(pid.matches("[0-9]{9}"))) return false;
        if(!(hcl.matches("#[0-9a-f]{6}"))) return false;
        
        if(hgt.endsWith("cm")){
            if(hgt.length() != 5 || Integer.parseInt(hgt.substring(0, 3)) < 150 ||  Integer.parseInt(hgt.substring(0, 3)) > 193){
                return false;
            }
        }
        if(hgt.endsWith("in")){
            if(hgt.length() != 4 || Integer.parseInt(hgt.substring(0, 2)) < 59 ||  Integer.parseInt(hgt.substring(0, 2)) > 76){
                return false;
            }
        }

        if( !(ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry")
            || ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth")) ) return false;

        return true;
    } 

}

