import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] card;
        String[] numberSets;
        int score;
        int sum = 0;
        int cardNumber = 0;
        int[] numCard = new int[206];
        ArrayList<String> winNumbers = new ArrayList<>();
        ArrayList<String> yourNumbers = new ArrayList<>();
        ArrayList<String> cards = new ArrayList<>();
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        while(in.hasNextLine()) {
            score = 0;
            numCard[cardNumber]++;
            card = in.nextLine().split(":");
            numberSets = card[1].split("[|]");
            winNumbers.addAll(List.of(numberSets[0].split(" ")));
            yourNumbers.addAll(List.of(numberSets[1].split(" ")));
            winNumbers.forEach((number)->number = number.replaceAll("[^0-9]",""));
            System.out.println("Win");
            winNumbers.removeAll(List.of(new String[]{""}));
            yourNumbers.forEach((number)->number = number.replaceAll("[^0-9]",""));
            yourNumbers.removeAll(List.of(new String[]{""}));
            System.out.println("Yours");
            for(String number : yourNumbers){
                if(winNumbers.contains(number)){
                    score++;
                }
            }

            yourNumbers.clear();
            winNumbers.clear();
            for(int i = 1; i<=score; i++){
                numCard[cardNumber+i] = numCard[cardNumber+i] + numCard[cardNumber];
            }
            sum = sum + numCard[cardNumber];
            cardNumber++;
        }
        System.out.println(sum);
    }
}
