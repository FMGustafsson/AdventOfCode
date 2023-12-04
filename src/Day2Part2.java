import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        String inputLine;
        String[] games;
        String[] reveals;
        String[] colour;
        int noBlue;
        int noGreen;
        int noRed;
        int i;
        boolean pass;
        int sum = 0;
        while(in.hasNextLine()){
            inputLine = in.nextLine();
            games = inputLine.split(":");
            reveals = games[1].split(";");
            noBlue = 0;
            noGreen = 0;
            noRed = 0;
            for(String colours : reveals){
                colour = colours.split(",");
                for(String number : colour){
                    if (number.contains("blue")) {
                        if(Integer.parseInt(number.replaceAll("[^0-9]", "")) > noBlue){
                            noBlue = Integer.parseInt(number.replaceAll("[^0-9]", ""));
                        }
                    } else if (number.contains("green")) {
                        if(Integer.parseInt(number.replaceAll("[^0-9]", "")) > noGreen){
                            noGreen = Integer.parseInt(number.replaceAll("[^0-9]", ""));
                        }
                    } else if (number.contains("red")) {
                        if (Integer.parseInt(number.replaceAll("[^0-9]", "")) > noRed) {
                            noRed = Integer.parseInt(number.replaceAll("[^0-9]", ""));
                        }
                    }
                }
            }
            sum = sum + (noBlue*noGreen*noRed);
        }
        System.out.println(sum);
    }
}
