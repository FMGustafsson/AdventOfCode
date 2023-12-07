import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Day6Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        double lowerBound;
        double upperBound;
        double lower;
        double upper;
        long time = Long.parseLong(in.nextLine().replaceAll("[^0-9]",""));
        long distance = Long.parseLong(in.nextLine().replaceAll("[^0-9]",""));
        double sqrt = Math.sqrt(time * time - 4 * distance);
        upperBound = Math.abs((-time - sqrt)/2);
        lowerBound = Math.abs((-time + sqrt)/2);
        System.out.println(lowerBound + " " + upperBound);
        lower = Math.floor(lowerBound);
        if(String.valueOf(upperBound).matches(".*.0$")){
            upperBound--;
        }
        upper = Math.floor(upperBound);
        System.out.println(lower + " " + upper);
        System.out.println(upper-lower);
    }
}

