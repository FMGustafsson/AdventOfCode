import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        double lowerBound;
        double upperBound;
        double lower;
        double upper;
        ArrayList<String> timesString = new ArrayList<>(List.of(in.nextLine().split(" ")));
        ArrayList<String> distancesString = new ArrayList<>(List.of(in.nextLine().split(" ")));
        ArrayList<Float> times = new ArrayList<>();
        ArrayList<Float> distances = new ArrayList<>();
        double product = 1;
        for(int i = 0; i<timesString.size(); i++){
            timesString.set(i, timesString.get(i).replaceAll("[^0-9]",""));
        }
        for(int i=0; i<distancesString.size(); i++){
            distancesString.set(i, distancesString.get(i).replaceAll("[^0-9]",""));
        }
        timesString.removeIf(x->x.equals(""));
        distancesString.removeIf(x->x.equals(""));
        timesString.forEach(x->times.add(Float.parseFloat(x)));
        distancesString.forEach(x->distances.add(Float.parseFloat(x)));
        for(int i=0; i<times.size(); i++){
            upperBound = Math.abs((-times.get(i) - Math.sqrt(times.get(i)*times.get(i)-4*distances.get(i)))/2);
            lowerBound = Math.abs((-times.get(i) + Math.sqrt(times.get(i)*times.get(i)-4*distances.get(i)))/2);
            System.out.println(lowerBound + " " + upperBound);
            lower = Math.floor(lowerBound);
            if(String.valueOf(upperBound).matches(".*.0$")){
                upperBound--;
            }
            upper = Math.floor(upperBound);
            System.out.println(lower + " " + upper);
            System.out.println(upper-lower);
            product  = product * (upper-lower);
        }
        System.out.println(product);
    }
}
