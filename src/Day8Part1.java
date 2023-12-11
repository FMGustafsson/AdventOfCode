import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Day8Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        String currentLine;
        String[] possibleDirections;
        String node = "AAA";
        int steps = 0;
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        char[] route = in.nextLine().toCharArray();
        int length = route.length;
        HashMap<String,String[]> nodes = new HashMap<>();
        in.nextLine();
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            currentLine = currentLine.replaceAll("[^A-Z]","");
            nodes.put(currentLine.substring(0,3), new String[] {currentLine.substring(3,6),currentLine.substring(6,9)});
        }
        possibleDirections = nodes.get("AAA");
        while(!node.equals("ZZZ")){
            if(route[steps%length]=='L'){
                node = possibleDirections[0];
            }
            else{
                node = possibleDirections[1];
            }
            possibleDirections = nodes.get(node);
            steps++;
        }
        System.out.println(steps);
    }
}
