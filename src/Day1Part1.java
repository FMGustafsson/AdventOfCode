import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) {
        int sum=0;
        char num2;
        String lineNumber;
        String line;
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNextLine()) {
            line = stdin.nextLine();
            System.out.println(line);
            line = line.replaceAll("[^0-9]","");
            System.out.println(line);
            if(line.length()>0) {
                lineNumber = String.valueOf(line.charAt(0)) + String.valueOf(line.charAt(line.length() - 1));
                sum = sum + Integer.parseInt(lineNumber);
            }
            System.out.println(sum);
        }
    }
}
