import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] card;
        String[] numberSets;
        int score;
        int sum = 0;
        ArrayList<String> winNumbers = new ArrayList<>();
        ArrayList<String> yourNumbers = new ArrayList<>();
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        while(in.hasNextLine()){
            score = 0;
            card = in.nextLine().split(":");
            numberSets = card[1].split("[|]");
            winNumbers.addAll(List.of(numberSets[0].split(" ")));
            yourNumbers.addAll(List.of(numberSets[1].split(" ")));
            winNumbers.forEach((number)->number = number.replaceAll("[^0-9]",""));
            System.out.println("Win");
            winNumbers.forEach((number)->System.out.println(number));
            winNumbers.removeAll(List.of(new String[]{""}));
            yourNumbers.forEach((number)->number = number.replaceAll("[^0-9]",""));
            yourNumbers.removeAll(List.of(new String[]{""}));
            System.out.println("Yours");
            yourNumbers.forEach((number)->System.out.println(number));
            for(String number : yourNumbers){
                if(winNumbers.contains(number)){
                    if(score==0){
                        score = 1;
                    }
                    else{
                        score = score*2;
                    }
                }
            }
            sum = sum + score;
            yourNumbers.clear();
            winNumbers.clear();
        }
        System.out.println(sum);
    }
}
