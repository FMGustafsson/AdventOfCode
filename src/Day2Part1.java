import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        String inputLine;
        String[] games;
        String[] reveals;
        String[] colour;
        int i;
        boolean pass;
        int sum = 0;
        int j;
        while(in.hasNextLine()){
            inputLine = in.nextLine();
            games = inputLine.split(":");
            reveals = games[1].split(";");
            pass = true;
            i = 0;
            while(pass && i< reveals.length) {
                colour = reveals[i].split(",");
                j=0;
                while(pass && j<colour.length){
                    if (colour[j].contains("blue")) {
                        pass = Integer.parseInt(colour[j].replaceAll("[^0-9]", "")) <= 14;
                    } else if (colour[j].contains("green")) {
                        pass = Integer.parseInt(colour[j].replaceAll("[^0-9]", "")) <= 13;
                    } else if (colour[j].contains("red")) {
                        pass = Integer.parseInt(colour[j].replaceAll("[^0-9]", "")) <= 12;
                    } else {
                        pass = false;
                    }
                    j++;
                }
                i++;
            }
            if(pass){
                sum = sum + Integer.parseInt(games[0].replaceAll("[^0-9]",""));
                System.out.println(games[0]);
            }
        }
        System.out.println(sum);
    }
}
