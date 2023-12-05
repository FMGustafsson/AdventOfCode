import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        String currentLine;
        String previousLine;
        String forwardLine;
        String number = "";
        int sum = 0;
        int offset = 1;
        ArrayList<String> adjacentNumbers = new ArrayList<>();
        currentLine = in.nextLine();
        forwardLine = in.nextLine();
        previousLine = currentLine;
        currentLine = forwardLine;
        while(in.hasNextLine()){
            forwardLine = in.nextLine();
            if(currentLine.contains("*")){
                for(int i = 0; i<currentLine.length(); i++){
                    if(currentLine.charAt(i)=='*'){
                        while(offset<=i && Character.toString(currentLine.charAt(i-offset)).matches("[0-9]")){
                            number = currentLine.charAt(i-offset) + number;
                            offset++;
                        }
                        if(!number.equals("")){
                            adjacentNumbers.add(number);
                        }
                        offset = 1;
                        number = "";
                        while(i+offset<currentLine.length() && Character.toString(currentLine.charAt(i+offset)).matches("[0-9]")){
                            number = number + currentLine.charAt(i+offset);
                            offset++;
                        }
                        if(!number.equals("")){
                            adjacentNumbers.add(number);
                        }
                        offset = 1;
                        number = "";
                        if(Character.toString(previousLine.charAt(i)).matches("[0-9]")) {
                            number = number + previousLine.charAt(i);
                            while (offset<=i && Character.toString(previousLine.charAt(i - offset)).matches("[0-9]")) {
                                number = previousLine.charAt(i - offset) + number;
                                offset++;
                            }
                            offset = 1;
                            while (i+offset<currentLine.length() && Character.toString(previousLine.charAt(i + offset)).matches("[0-9]")) {
                                number = number + previousLine.charAt(i + offset);
                                offset++;
                            }
                            if(!number.equals("")){
                                adjacentNumbers.add(number);
                                System.out.println(number);
                            }
                        }
                        else{
                            while (offset<=i && Character.toString(previousLine.charAt(i - offset)).matches("[0-9]")) {
                                number = previousLine.charAt(i - offset) + number;
                                offset++;
                            }
                            if(!number.equals("")){
                                adjacentNumbers.add(number);
                                System.out.println(number);
                            }
                            offset = 1;
                            number = "";
                            while (i+offset<currentLine.length() && Character.toString(previousLine.charAt(i + offset)).matches("[0-9]")) {
                                number = number + previousLine.charAt(i + offset);
                                offset++;
                            }
                            if(!number.equals("")){
                                adjacentNumbers.add(number);
                                System.out.println(number);
                            }
                        }
                        offset = 1;
                        number = "";
                        if(Character.toString(forwardLine.charAt(i)).matches("[0-9]")) {
                            number = number + forwardLine.charAt(i);
                            while (offset<=i && Character.toString(forwardLine.charAt(i - offset)).matches("[0-9]")) {
                                number = forwardLine.charAt(i - offset) + number;
                                offset++;
                            }
                            offset = 1;
                            while (i+offset<currentLine.length() && Character.toString(forwardLine.charAt(i + offset)).matches("[0-9]")) {
                                number = number + forwardLine.charAt(i + offset);
                                offset++;
                            }
                            if(!number.equals("")){
                                adjacentNumbers.add(number);
                                System.out.println(number);
                            }
                            offset = 1;
                            number = "";
                        }
                        else{
                            while (offset<=i && Character.toString(forwardLine.charAt(i - offset)).matches("[0-9]")) {
                                number = forwardLine.charAt(i - offset) + number;
                                offset++;
                            }
                            if(!number.equals("")){
                                adjacentNumbers.add(number);
                                System.out.println(number);
                            }
                            offset = 1;
                            number = "";
                            while (i+offset<currentLine.length() && Character.toString(forwardLine.charAt(i + offset)).matches("[0-9]")) {
                                number = number + forwardLine.charAt(i + offset);
                                offset++;
                            }
                            if(!number.equals("")){
                                adjacentNumbers.add(number);
                                System.out.println(number);
                            }
                            offset = 1;
                            number = "";
                        }
                        if(adjacentNumbers.size()==2){
                            sum = sum + Integer.parseInt(adjacentNumbers.get(0))*Integer.parseInt(adjacentNumbers.get(1));
                            System.out.println(adjacentNumbers.get(0) + " " + adjacentNumbers.get(1));
                        }
                        adjacentNumbers.clear();
                    }
                }
            }
            previousLine = currentLine;
            currentLine = forwardLine;
        }
        System.out.println(sum);
    }
}
