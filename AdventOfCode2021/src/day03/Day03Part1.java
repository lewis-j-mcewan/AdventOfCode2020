package day03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import helperClasses.LoadFile;

public class Day03Part1 {

    public static void main(String[] args) throws IOException {
        List<String> input = LoadFile.FileToString("src/day03/Day03.txt");

        int stepDown = 1;
        int stepRight = 3;
        int mapDepth = input.size();
        int mapWidth = mapDepth * stepRight;

        //populate 2d array
        String[][] map = new String[mapDepth][mapWidth];
        
        String[] line;
        for(int row = 0; row < mapDepth; row++){
            line = input.get(row).split("");
            int col = 0; 
            int pos = 0;
            while(col < mapWidth){
                if(pos >= line.length){
                    pos = 0;
                }
                map[row][col] = line[pos];
                pos++;
                col++;
            }
        }
        
        //traverse array
        int row = 0;
        int col = 0;
        int trees = 0;
        while(row < mapDepth){
            col += stepRight;
            row += stepDown;
            if(row == mapDepth){
                break;
            }
            if(map[row][col].equals("#")){
                trees++;
            }
        }

        System.out.println("trees: " + trees);
        writeToFile(map);
    }

    private static void writeToFile(String[][] map){
        try {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < map.length; i++)//for each row
            {
                for(int j = 0; j < map[i].length; j++)//for each column
                {
                    builder.append(map[i][j]+"");//append to the output string
                }
                builder.append("\n");//append new line at the end of the row
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(builder.toString());//save the string representation of the board
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    

}
