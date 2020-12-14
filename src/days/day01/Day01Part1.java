package days.day01;

import java.io.IOException;
import java.util.List;

import helperClasses.LoadFile;

public class Day01Part1 {
    public static void main(String[] args) throws IOException {
        List<String> input = LoadFile.FileToString("src/days/day01/Day01.txt");
        
        for(int i = 0; i < input.size(); i++){
            for(int j = 0; j < input.size(); j++){
                if(Integer.parseInt(input.get(i)) + Integer.parseInt(input.get(j)) == 2020){
                    System.out.println("input i : " + input.get(i) + " input j : " + input.get(j));
                    int output = Integer.parseInt(input.get(i)) * Integer.parseInt(input.get(j));
                    System.out.println(output);
                }
            
            }
        }
    }
}
