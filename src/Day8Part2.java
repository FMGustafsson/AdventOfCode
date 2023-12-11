import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Day8Part2 {
    private static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

    public static int gcd(int... numbers) {
        return Arrays.stream(numbers).reduce(0, (x, y) -> gcd(x, y));
    }

    public static int lcm(int... numbers) {
        return Arrays.stream(numbers).reduce(1, (x, y) -> x * (y / gcd(x, y)));
    }
    public static void main(String[] args) throws FileNotFoundException {
        String currentLine;
        int nodeNo = 0;
        String[] possibleDirections;
        ArrayList<String> node = new ArrayList<>();
        int steps = 0;
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        char[] route = in.nextLine().toCharArray();
        int length = route.length;
        HashMap<String,String[]> nodes = new HashMap<>();
        in.nextLine();
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            currentLine = currentLine.replaceAll("[^A-Z1-9]","");
            nodes.put(currentLine.substring(0,3), new String[] {currentLine.substring(3,6),currentLine.substring(6,9)});
            if(currentLine.charAt(2)=='A'){
                node.add(currentLine.substring(0,3));
                System.out.println(currentLine.substring(0,3));
            }
        }
        int[] moves = new int[node.size()+1];
        for(String location : node){
            possibleDirections = nodes.get(location);
            while(!(location.charAt(2)=='Z')){
                if(route[steps%length]=='L'){
                    location = possibleDirections[0];
                }
                else{
                    location = possibleDirections[1];
                }
                possibleDirections = nodes.get(location);
                steps++;
            }
            System.out.println(location);
            moves[nodeNo] = steps;
            steps = 0;
            nodeNo++;
        }
        moves[nodeNo] = route.length;
        for(int move: moves){
            System.out.println(move);
        }
        int lcmMoves = lcm(moves);
        System.out.println(lcmMoves);
    }
}
