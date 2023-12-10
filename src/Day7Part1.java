import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Day7Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        final String ORDER= "AKQJT98765432";
        int sum = 0;
        ArrayList<String[]> five = new ArrayList<>();
        ArrayList<String[]> four = new ArrayList<>();
        ArrayList<String[]> fullHouse = new ArrayList<>();
        ArrayList<String[]> three =  new ArrayList<>();
        ArrayList<String[]> twoPair = new ArrayList<>();
        ArrayList<String[]> pair = new ArrayList<>();
        ArrayList<String[]> highCard = new ArrayList<>();
        HashMap<Character, Integer> characterCount = new HashMap<>();
        String[] card;
        String currentLine;
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            card = currentLine.split(" ");
            for(char letter : card[0].toCharArray()) {
                if (!characterCount.containsKey(letter)) {
                    characterCount.put(letter, 1);
                } else {
                    characterCount.replace(letter, characterCount.get(letter) + 1);
                }
            }
            if(characterCount.containsValue(5)){
                five.add(card);
            }
            else if(characterCount.containsValue(4)){
                four.add(card);
            }
            else if(characterCount.containsValue(3)){
                if(characterCount.containsValue(2)){
                    fullHouse.add(card);
                }
                else{
                    three.add(card);
                }
            }
            else if(characterCount.containsValue(2)){
                if(characterCount.size()==3){
                    twoPair.add(card);
                }
                else{
                    pair.add(card);
                }
            }
            else{
                highCard.add(card);
            }
            characterCount.clear();
        }
        five.sort((o1, o2) -> {
            int length = o1[0].length();
            for(int i = 0; i < length; ++i) {
                int firstLetterIndex = ORDER.indexOf(o1[0].charAt(i));
                int secondLetterIndex = ORDER.indexOf(o2[0].charAt(i));

                if(firstLetterIndex == secondLetterIndex) continue;

                // First string has lower index letter (for example F) and the second has higher index letter (for example B) - that means that the first string comes before
                if(firstLetterIndex < secondLetterIndex) return 1;
                else return -1;
            }

            return 0;
        });
        four.sort((o1, o2) -> {
            int length = o1[0].length();
            for(int i = 0; i < length; ++i) {
                int firstLetterIndex = ORDER.indexOf(o1[0].charAt(i));
                int secondLetterIndex = ORDER.indexOf(o2[0].charAt(i));

                if(firstLetterIndex == secondLetterIndex) continue;

                // First string has lower index letter (for example F) and the second has higher index letter (for example B) - that means that the first string comes before
                if(firstLetterIndex < secondLetterIndex) return 1;
                else return -1;
            }

            return 0;
        });
        fullHouse.sort((o1, o2) -> {
            int length = o1[0].length();
            for(int i = 0; i < length; ++i) {
                int firstLetterIndex = ORDER.indexOf(o1[0].charAt(i));
                int secondLetterIndex = ORDER.indexOf(o2[0].charAt(i));

                if(firstLetterIndex == secondLetterIndex) continue;

                // First string has lower index letter (for example F) and the second has higher index letter (for example B) - that means that the first string comes before
                if(firstLetterIndex < secondLetterIndex) return 1;
                else return -1;
            }

            return 0;
        });
        three.sort((o1, o2) -> {
            int length = o1[0].length();
            for(int i = 0; i < length; ++i) {
                int firstLetterIndex = ORDER.indexOf(o1[0].charAt(i));
                int secondLetterIndex = ORDER.indexOf(o2[0].charAt(i));

                if(firstLetterIndex == secondLetterIndex) continue;

                // First string has lower index letter (for example F) and the second has higher index letter (for example B) - that means that the first string comes before
                if(firstLetterIndex < secondLetterIndex) return 1;
                else return -1;
            }

            return 0;
        });
        twoPair.sort((o1, o2) -> {
            int length = o1[0].length();
            for(int i = 0; i < length; ++i) {
                int firstLetterIndex = ORDER.indexOf(o1[0].charAt(i));
                int secondLetterIndex = ORDER.indexOf(o2[0].charAt(i));

                if(firstLetterIndex == secondLetterIndex) continue;

                // First string has lower index letter (for example F) and the second has higher index letter (for example B) - that means that the first string comes before
                if(firstLetterIndex < secondLetterIndex) return 1;
                else return -1;
            }

            return 0;
        });
        pair.sort((o1, o2) -> {
            int length = o1[0].length();
            for(int i = 0; i < length; ++i) {
                int firstLetterIndex = ORDER.indexOf(o1[0].charAt(i));
                int secondLetterIndex = ORDER.indexOf(o2[0].charAt(i));

                if(firstLetterIndex == secondLetterIndex) continue;

                // First string has lower index letter (for example F) and the second has higher index letter (for example B) - that means that the first string comes before
                if(firstLetterIndex < secondLetterIndex) return 1;
                else return -1;
            }

            return 0;
        });
        highCard.sort((o1, o2) -> {
            int length = o1[0].length();
            for(int i = 0; i < length; ++i) {
                int firstLetterIndex = ORDER.indexOf(o1[0].charAt(i));
                int secondLetterIndex = ORDER.indexOf(o2[0].charAt(i));

                if(firstLetterIndex == secondLetterIndex) continue;

                // First string has lower index letter (for example F) and the second has higher index letter (for example B) - that means that the first string comes before
                if(firstLetterIndex < secondLetterIndex) return 1;
                else return -1;
            }

            return 0;
        });
        sum = sum + sumRank(highCard, 0);
        sum = sum + sumRank(pair, highCard.size());
        sum = sum + sumRank(twoPair, highCard.size() + pair.size());
        sum = sum + sumRank(three, highCard.size() + pair.size() + twoPair.size());
        sum = sum + sumRank(fullHouse, highCard.size() + pair.size() + twoPair.size() + three.size());
        sum = sum + sumRank(four, highCard.size() + pair.size() + fullHouse.size() + three.size() + twoPair.size());
        sum = sum + sumRank(five, highCard.size() + four.size() + fullHouse.size() + three.size() + twoPair.size() + pair.size());
        System.out.println(sum);
    }
    public static int sumRank(ArrayList<String[]> set, int rank){
        int sum = 0;
        for(String[] card : set){
            rank++;
            System.out.println(card[0] + " " + rank);
            sum = sum + rank*Integer.parseInt(card[1]);
        }
        return sum;
    }
}
