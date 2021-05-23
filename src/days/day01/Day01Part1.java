package days.day01;

import java.io.IOException;
import java.util.List;

import helperClasses.LoadFile;

public class Day01Part1 {
    
	private List<String> input;
	
	public Day01Part1() {
		try {
			input = LoadFile.FileToString("src/days/day01/Day01.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int output = calculateNumbers();
		System.out.println(output);
	}
	
	private int calculateNumbers() {
		int output = -1;
		for(int i = 0; i < input.size(); i++){
            for(int j = 0; j < input.size(); j++){
                if(Integer.parseInt(input.get(i)) + Integer.parseInt(input.get(j)) == 2020){
                    System.out.println("input i : " + input.get(i) + " input j : " + input.get(j));
                    output = Integer.parseInt(input.get(i)) * Integer.parseInt(input.get(j));
                }
            
            }
        }
		return output;
	}
	
	public static void main(String[] args) throws IOException {
        new Day01Part1();
    }
}
