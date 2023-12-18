import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        char[][] map = new char[300][300];
        char[][] rowExpandedMap = new char[300][300];
        char[][] expandedMap = new char[300][300];
        int x = 0;
        int y = 0;
        int sum = 0;
        int column = 0;
        int row = 0;
        boolean pass = true;
        int checkY=0;
        int checkX=0;
        ArrayList<int[]> galaxies = new ArrayList<>();
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
                    rowExpandedMap[column][j] = '#';
                    pass = false;
                }
            }
            column++;
            if(pass){
                column++;
            }
        }
        for(int i = 0; i<y; i++){
            pass = true;
            for(int j = 0; j<column; j++) {
                if(rowExpandedMap[j][i]=='#') {
                    expandedMap[j][row] = '#';
                    pass = false;
                }
            }
            row++;
            if(pass){
                row++;
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.printf("%c",expandedMap[j][i]);
            }
            System.out.printf("\n");
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(expandedMap[j][i]=='#'){
                    galaxies.add(new int[]{j,i});
                }
            }
        }
        for(int[] galaxy: galaxies){
            System.out.println(galaxy[0] + " " + galaxy[1]);
        }
        for(int i = 0; i<galaxies.size()-1; i++){
            for(int j = i+1; j< galaxies.size(); j++){
                sum = sum + Math.abs(galaxies.get(j)[0]-galaxies.get(i)[0]) + Math.abs(galaxies.get(j)[1]-galaxies.get(i)[1]);
            }
        }
        System.out.println(sum);
    }
}
