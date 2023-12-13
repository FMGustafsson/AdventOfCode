import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        char[][] map = new char[300][300];
        int steps = 1;
        int currentY = 0;
        int currentX;
        double insidePoints;
        double area = 0;
        char approach = 'R';
        int[] start = new int[]{0,0};
        char checkPipe;
        ArrayList<int[]> coordinatesList = new ArrayList<>();
        int[] location  = new int[] {0,0};
        String currentLine;
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            for(int i = 0; i<currentLine.length(); i++){
                map[i][currentY]=currentLine.charAt(i);
                if(currentLine.charAt(i)=='S'){
                    start = new int[]{i,currentY};
                }
            }
            currentY++;
        }
        currentX = start[0];
        currentY = start[1];
        coordinatesList.add(new int[]{currentX,currentY});
        checkPipe = map[currentX+1][currentY];
        if(checkPipe=='-'||checkPipe=='J'||checkPipe=='7'){
            location = new int[]{currentX+1,currentY};
            approach='R';
        }
        checkPipe = map[currentX][currentY-1];
        if(checkPipe=='|'||checkPipe=='F'||checkPipe=='7'){
            location = new int[]{currentX,currentY-1};
            approach='U';
        }
        checkPipe = map[currentX][currentY+1];
        if(checkPipe=='|'||checkPipe=='J'||checkPipe=='L'){
            location= new int[]{currentX,currentY+1};
            approach='D';
        }
        checkPipe = map[currentX-1][currentY];
        if(checkPipe=='-'||checkPipe=='L'||checkPipe=='F'){
            location = new int[]{currentX-1,currentY};
            approach='L';
        }
        while(!(location[0]==start[0]&&location[1]==start[1])){
            checkPipe = map[location[0]][location[1]];
            if(checkPipe == '-'){
                if(approach=='R'){
                    location = new int[]{location[0]+1,location[1]};
                }
                else{
                    location = new int[]{location[0]-1,location[1]};
                    approach='L';
                }
            }
            else if(checkPipe == '|'){
                if(approach=='U'){
                    location = new int[]{location[0],location[1]-1};
                }
                else{
                    System.out.println("here");
                    location = new int[]{location[0],location[1]+1};
                    approach='D';
                }
            }
            else if(checkPipe == 'L'){
                if(approach=='D'){
                    location = new int[]{location[0]+1,location[1]};
                    approach='R';
                }
                else{
                    location = new int[]{location[0],location[1]-1};
                    approach='U';
                }
            }
            else if(checkPipe == 'J'){
                if(approach=='R'){
                    location = new int[]{location[0],location[1]-1};
                    approach='U';
                }
                else{
                    location = new int[]{location[0]-1,location[1]};
                    approach='L';
                }
            }
            else if(checkPipe == '7'){
                if(approach=='R'){
                    location = new int[]{location[0],location[1]+1};
                    approach='D';
                }
                else{
                    location = new int[]{location[0]-1,location[1]};
                    approach='L';
                }
            }
            else if(checkPipe == 'F'){
                if(approach=='U'){
                    location = new int[]{location[0]+1,location[1]};
                    approach='R';
                }
                else{
                    location = new int[]{location[0],location[1]+1};
                    approach='D';
                }
            }
            coordinatesList.add(new int[]{location[0],location[1]});
            steps++;
        }
        System.out.println(steps);
        for(int[] coordinate : coordinatesList){
            System.out.println(coordinate[0] + " " + coordinate[1]);
        }
        for(int i = 0; i< coordinatesList.size()-1; i++){
            area = area + ((coordinatesList.get(i)[0])*(coordinatesList.get(i+1)[1])) - ((coordinatesList.get(i)[1])*(coordinatesList.get(i+1)[0]));
        }
        area = Math.abs(area/2);
        System.out.println(area);
        insidePoints = area - ((double)coordinatesList.size()/2) + 1;
        System.out.println(insidePoints);
    }
}
