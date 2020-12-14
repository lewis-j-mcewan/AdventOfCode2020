package days.day01;

import java.io.IOException;
import java.util.List;

import helperClasses.LoadFile;

public class Day01Part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = LoadFile.FileToString("src/days/day01/Day01.txt");
        
        for(int i = 0; i < input.size(); i++){
            for(int j = 0; j < input.size(); j++){
                for(int k = 0; k < input.size(); k++){
                    if(Integer.parseInt(input.get(i)) + Integer.parseInt(input.get(j)) + Integer.parseInt(input.get(k)) == 2020){
                        System.out.println("input i : " + input.get(i) + " input j : " + input.get(j) + " input k : " + Integer.parseInt(input.get(k)));
                        int output = Integer.parseInt(input.get(i)) * Integer.parseInt(input.get(j)) * Integer.parseInt(input.get(k));
                        System.out.println(output);
                    }
                }
                
            }
        }
    }
}
