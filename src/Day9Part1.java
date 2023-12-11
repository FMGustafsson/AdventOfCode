import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day9Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        boolean allZero = false;
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        ArrayList<int[]> sequences = new ArrayList<>();
        String[] numbersAsStrings;
        int[] numbers;
        int limit;
        int[] oldNumbers;
        int sum = 0;
        int newNum;
        String currentLine;
        while(in.hasNextLine()){
            allZero = false;
            currentLine = in.nextLine();
            numbersAsStrings = currentLine.split(" ");
            numbers = new int[numbersAsStrings.length];
            for(int i=0; i<numbersAsStrings.length; i++){
                numbersAsStrings[i] = numbersAsStrings[i].replaceAll("[^0-9-]","");
                numbers[i] = Integer.parseInt(numbersAsStrings[i]);
            }
            sequences.add(numbers.clone());
            while(!allZero){
                allZero = true;
                limit = numbers.length;
                oldNumbers = numbers;
                numbers = new int[limit-1];
                for(int i = 0; i<limit-1; i++){
                    numbers[i] = oldNumbers[i+1]-oldNumbers[i];
                    if(!(numbers[i]==0)){
                        allZero = false;
                    }
                }
                sequences.add(numbers.clone());
            }
            newNum = 0;
            for(int i= sequences.size()-1;i>-1; i--){
                newNum = sequences.get(i)[sequences.get(i).length-1] + newNum;
            }
            System.out.println("A");
            sum = sum + newNum;
            sequences.clear();
        }
        System.out.println(sum);
    }
}
