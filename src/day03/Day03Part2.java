package day03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import helperClasses.LoadFile;

public class Day03Part2 {

    public static void main(String[] args) throws IOException {
        List<String> input = LoadFile.FileToString("src/day03/Day03.txt");
        
        int run1 = getTrees(input, 1, 1);
        int run2 = getTrees(input, 3, 1);
        int run3 = getTrees(input, 5, 1);
        int run4 = getTrees(input, 7, 1);
        int run5 = getTrees(input, 1, 2);

        int totalTrees = run1 * run2 * run3 * run4 * run5;
        System.out.println("trees: " + totalTrees);
        // writeToFile(map);
    }

    private static int getTrees(List<String> input, int right, int down) {
        int stepDown = down;
        int stepRight = right;
        int mapDepth = input.size();
        int mapWidth = mapDepth * stepRight;
        int trees = 0;

        System.out.println("mapDepth: " + mapDepth + " mapWidth: " + mapWidth);

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
        while(row < mapDepth){
            col += stepRight;
            row += stepDown;
            if(row >= mapDepth){
                break;
            }
            if(map[row][col].equals("#")){
                trees++;
            }
        }
        return trees;
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
