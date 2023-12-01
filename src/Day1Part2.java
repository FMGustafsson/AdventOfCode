import java.io.BufferedInputStream;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {
        int sum=0;
        char num2;
        String lineNumber;
        String line;
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNextLine()) {
            line = stdin.nextLine();
            System.out.println(line);
            line=line.replace("zero","zero0zero");
            line=line.replace("one","one1one");
            line=line.replace("two","two2two");
            line=line.replace("three","three3three");
            line=line.replace("four","four4four");
            line=line.replace("five", "five5five");
            line=line.replace("six","six6six");
            line=line.replace("seven","seven7seven");
            line=line.replace("eight","eight8eight");
            line=line.replace("nine","nine9nine");
            line = line.replaceAll("[^0-9]","");
            System.out.println(line);
            if(line.length()>0) {
                lineNumber = String.valueOf(line.charAt(0)) + String.valueOf(line.charAt(line.length() - 1));
                sum = sum + Integer.parseInt(lineNumber);
                System.out.println(lineNumber);
            }
            System.out.println(sum);
        }
    }
}