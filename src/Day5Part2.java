import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Day5Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        String currentLine;
        String[] numbers;
        Long min;
        Long location;
        Long[] range = new Long[3];
        String seed;
        boolean done;
        ArrayList<Long> seeds = new ArrayList<>();
        ArrayList<Long[]> soilMap = new ArrayList<>();
        ArrayList<Long[]> fertiliserMap = new ArrayList<>();
        ArrayList<Long[]> waterMap = new ArrayList<>();
        ArrayList<Long[]> lightMap = new ArrayList<>();
        ArrayList<Long[]> temperatureMap = new ArrayList<>();
        ArrayList<Long[]> humidityMap = new ArrayList<>();
        ArrayList<Long[]> locationMap = new ArrayList<>();
        ArrayList<Long> locations = new ArrayList<>();
        String[] seedStrings = in.nextLine().split(":")[1].split(" ");
        for (String seedString : seedStrings) {
            seed = seedString.replaceAll("[^0-9]", "");
            if (!seed.equals("")) {
                seeds.add(Long.parseLong(seedString.replaceAll("[^0-9]", "")));
            }
        }
        in.nextLine();
        in.nextLine();
        currentLine = in.nextLine();
        while (currentLine.matches(".*[0-9].*")) {
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x -> !Objects.equals(x, " "))).toArray(String[]::new);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("[^0-9]", "");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            soilMap.add(new Long[]{range[0], range[1], range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while (currentLine.matches(".*[0-9].*")) {
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x -> !Objects.equals(x, " "))).toArray(String[]::new);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("[^0-9]", "");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.prLongln(range[i]);
            }
            fertiliserMap.add(new Long[]{range[0], range[1], range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while (currentLine.matches(".*[0-9].*")) {
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x -> !Objects.equals(x, " "))).toArray(String[]::new);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("[^0-9]", "");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            waterMap.add(new Long[]{range[0], range[1], range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while (currentLine.matches(".*[0-9].*")) {
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x -> !Objects.equals(x, " "))).toArray(String[]::new);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("[^0-9]", "");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            lightMap.add(new Long[]{range[0], range[1], range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while (currentLine.matches(".*[0-9].*")) {
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x -> !Objects.equals(x, " "))).toArray(String[]::new);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("[^0-9]", "");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            temperatureMap.add(new Long[]{range[0], range[1], range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while (currentLine.matches(".*[0-9].*")) {
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x -> !Objects.equals(x, " "))).toArray(String[]::new);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("[^0-9]", "");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            humidityMap.add(new Long[]{range[0], range[1], range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while (currentLine.matches(".*[0-9].*")) {
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x -> !Objects.equals(x, " "))).toArray(String[]::new);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replaceAll("[^0-9]", "");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            locationMap.add(new Long[]{range[0], range[1], range[2]});
            if (in.hasNextLine()) {
                currentLine = in.nextLine();
            } else {
                currentLine = "";
            }
        }
        done = false;
        min = seeds.get(0);
        for (long i = 0; i < seeds.size(); i = i + 2) {
            for (long j = 0; j < seeds.get((int) i + 1); j = j + 1) {
                location = seeds.get(((int)i))+j;
                for (Long[] destToSource : soilMap) {
                    if (location >= destToSource[1] && location < destToSource[1] + destToSource[2] && !done) {
                        location = destToSource[0] + Math.abs(location - destToSource[1]);
                        done = true;
                    }
                }
                //System.out.println(locations);
                done = false;
                for (Long[] destToSource : fertiliserMap) {
                    if (location >= destToSource[1] && location < destToSource[1] + destToSource[2] && !done) {
                        location = destToSource[0] + Math.abs(location - destToSource[1]);
                        done = true;
                    }
                }
                //System.out.println(locations);
                done = false;
                for (Long[] destToSource : waterMap) {
                    if (location >= destToSource[1] && location < destToSource[1] + destToSource[2] && !done) {
                        location = destToSource[0] + Math.abs(location - destToSource[1]);
                        done = true;
                    }
                }
                done = false;
                //System.out.println(locations);
                for (Long[] destToSource : lightMap) {
                    if (location >= destToSource[1] && location < destToSource[1] + destToSource[2] && !done) {
                        location = destToSource[0] + Math.abs(location - destToSource[1]);
                        done = true;
                    }
                }
                done = false;
                //System.out.println(locations);
                for (Long[] destToSource : temperatureMap) {
                    if (location >= destToSource[1] && location < destToSource[1] + destToSource[2] && !done) {
                        location = destToSource[0] + Math.abs(location - destToSource[1]);
                        done = true;
                    }
                }
                done = false;
                //System.out.println(locations);
                for (Long[] destToSource : humidityMap) {
                    if (location >= destToSource[1] && location < destToSource[1] + destToSource[2] && !done) {
                        location = destToSource[0] + Math.abs(location - destToSource[1]);
                        done = true;
                    }
                }
                done = false;
                //System.out.println(locations);
                for (Long[] destToSource : locationMap) {
                    if (location >= destToSource[1] && location < destToSource[1] + destToSource[2] && !done) {
                        location = destToSource[0] + Math.abs(location - destToSource[1]);
                        done = true;
                    }
                }
                done = false;
                if(location<min){
                    min = location;
                }
            }
        }
        System.out.println(min);
    }
}
