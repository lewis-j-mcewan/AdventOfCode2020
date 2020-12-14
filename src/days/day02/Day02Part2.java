package days.day02;

import java.io.IOException;
import java.util.List;

import helperClasses.LoadFile;

public class Day02Part2 {

    public static void main(String[] args) throws IOException {
        List<String> input = LoadFile.FileToString("src/days/day02/Day02.txt");
        
        int total = 0;
        for(String line : input){
            int hyphen = line.indexOf("-");
            int firstSpace = line.indexOf(" ");
            int colon = line.indexOf(":");
            int low = Integer.parseInt(line.substring(0, hyphen));
            int high = Integer.parseInt(line.substring(hyphen+1, firstSpace));
            char letter = line.substring(firstSpace, colon).toCharArray()[1];
            String text = line.substring(line.lastIndexOf(" ")+1, line.length());

            System.out.println(low);
            System.out.println(high);
            System.out.println(letter);
            System.out.println(text);

            char[] characters = text.toCharArray();
            System.out.println(characters[low-1]);
            System.out.println(characters[high-1] + "\n");
            if( (characters[low-1] == letter && characters[high-1] != letter)
                || (characters[low-1] != letter && characters[high-1] == letter)){
                total++;
            }
        }
        System.out.println("total: " + total);
    }
}
