import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day10Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        char[][] map = new char[300][300];
        int steps = 1;
        int currentY = 0;
        int currentX = 0;
        boolean pass = true;
        ArrayList<Character> approach = new ArrayList<>();
        int[] start = new int[]{0,0};
        char checkPipe;
        ArrayList<int[]> locations = new ArrayList<>();
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
        System.out.println(start[0] + " " + start[1]);
        checkPipe = map[currentX+1][currentY];
        if(checkPipe=='-'||checkPipe=='J'||checkPipe=='7'){
            locations.add(new int[]{currentX+1,currentY});
            approach.add('R');
        }
        checkPipe = map[currentX][currentY+1];
        if(checkPipe=='|'||checkPipe=='J'||checkPipe=='L'){
            locations.add(new int[]{currentX,currentY+1});
            approach.add('D');
        }
        checkPipe = map[currentX-1][currentY];
        if(checkPipe=='-'||checkPipe=='L'||checkPipe=='F'){
            locations.add(new int[]{currentX-1,currentY});
            approach.add('L');
        }
        checkPipe = map[currentX][currentY-1];
        if(checkPipe=='|'||checkPipe=='F'||checkPipe=='7'){
            locations.add(new int[]{currentX,currentY-1});
            approach.add('U');
        }
        while(!(locations.get(0)[0]==locations.get(1)[0]&&locations.get(0)[1]==locations.get(1)[1])){
            for(int i=0; i<2; i++){
                checkPipe = map[locations.get(i)[0]][locations.get(i)[1]];
                System.out.println(locations.get(i)[0]+ " " + locations.get(i)[1] + " " + checkPipe);
                if(checkPipe == '-'){
                    if(approach.get(i)=='R'){
                        locations.set(i,new int[]{locations.get(i)[0]+1,locations.get(i)[1]});
                        approach.set(i,'R');
                    }
                    else{
                        locations.set(i,new int[]{locations.get(i)[0]-1,locations.get(i)[1]});
                        approach.set(i,'L');
                    }
                }
                else if(checkPipe == '|'){
                    if(approach.get(i)=='U'){
                        locations.set(i,new int[]{locations.get(i)[0],locations.get(i)[1]-1});
                        approach.set(i,'U');
                    }
                    else{
                        System.out.println("here");
                        locations.set(i,new int[]{locations.get(i)[0],locations.get(i)[1]+1});
                        approach.set(i,'D');
                    }
                }
                else if(checkPipe == 'L'){
                    if(approach.get(i)=='D'){
                        locations.set(i,new int[]{locations.get(i)[0]+1,locations.get(i)[1]});
                        approach.set(i,'R');
                    }
                    else{
                        locations.set(i,new int[]{locations.get(i)[0],locations.get(i)[1]-1});
                        approach.set(i,'U');
                    }
                }
                else if(checkPipe == 'J'){
                    if(approach.get(i)=='R'){
                        locations.set(i,new int[]{locations.get(i)[0],locations.get(i)[1]-1});
                        approach.set(i,'U');
                    }
                    else{
                        locations.set(i,new int[]{locations.get(i)[0]-1,locations.get(i)[1]});
                        approach.set(i,'L');
                    }
                }
                else if(checkPipe == '7'){
                    if(approach.get(i)=='R'){
                        locations.set(i,new int[]{locations.get(i)[0],locations.get(i)[1]+1});
                        approach.set(i,'D');
                    }
                    else{
                        locations.set(i,new int[]{locations.get(i)[0]-1,locations.get(i)[1]});
                        approach.set(i,'L');
                    }
                }
                else if(checkPipe == 'F'){
                    if(approach.get(i)=='U'){
                        locations.set(i,new int[]{locations.get(i)[0]+1,locations.get(i)[1]});
                        approach.set(i,'R');
                    }
                    else{
                        locations.set(i,new int[]{locations.get(i)[0],locations.get(i)[1]+1});
                        approach.set(i,'D');
                    }
                }
            }
            steps++;
        }
        System.out.println(steps);
    }
}
