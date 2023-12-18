import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        char[][] map = new char[300][300];
        ArrayList<double[]> rowExpandedMap = new ArrayList<>();
        ArrayList<double[]> expandedMap = new ArrayList<>();
        ArrayList<double[]> columnTranlator = new ArrayList<>();
        int x = 0;
        int y = 0;
        double sum = 0;
        double column = 0;
        double row = 0;
        boolean pass = true;
        int checkY=0;
        int checkX=0;
        ArrayList<double[]> galaxies = new ArrayList<>();
        String currentLine = "";
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            for(int i = 0; i<currentLine.length(); i++){
                map[i][y] = currentLine.charAt(i);
            }
            y++;
        }
        for(int i = 0; i<currentLine.length(); i++){
            pass = true;
            for(int j = 0; j<y; j++) {
                if(map[i][j]=='#') {
                    rowExpandedMap.add(new double[]{column ,j});
                    pass = false;
                }
            }
            column++;
            if(pass){
                column = column + 999999;
            }
        }
        for(int i = 0; i<y; i++){
            pass = true;
            columnTranlator.add(new double[]{i,row});
            for(int j = 0; j<currentLine.length(); j++) {
                if(map[j][i]=='#') {
                    pass = false;
                }
            }
            row++;
            if(pass){
                row = row + 999999;
            }
        }
        for(int i = 0; i< rowExpandedMap.size(); i++){
            for(int j = 0; j<columnTranlator.size(); j++){
                if(columnTranlator.get(j)[0]==rowExpandedMap.get(i)[1]){
                    rowExpandedMap.set(i, new double[]{rowExpandedMap.get(i)[0],columnTranlator.get(j)[1]});
                }
            }
        }
        for(int i = 0; i<rowExpandedMap.size()-1; i++){
            for(int j = i+1; j< rowExpandedMap.size(); j++){
                sum = sum + Math.abs(rowExpandedMap.get(j)[0]-rowExpandedMap.get(i)[0]) + Math.abs(rowExpandedMap.get(j)[1]-rowExpandedMap.get(i)[1]);
            }
        }
        System.out.println(sum);
    }
}
