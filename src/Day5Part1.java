import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Day5Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        String currentLine;
        String[] numbers;
        Long min;
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
        String[] seedStrings = in.nextLine().split(":")[1].split(" ");
        for (String seedString : seedStrings) {
            seed = seedString.replaceAll("[^0-9]","");
            if(!seed.equals("")) {
                seeds.add(Long.parseLong(seedString.replaceAll("[^0-9]", "")));
            }
        }
        ArrayList<Long> locations = new ArrayList<>(seeds);
        in.nextLine();
        in.nextLine();
        currentLine = in.nextLine();
        while(currentLine.matches(".*[0-9].*")){
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x-> !Objects.equals(x, " "))).toArray(String[]::new);
            for(int i = 0; i<numbers.length; i++){
                numbers[i] = numbers[i].replaceAll("[^0-9]","");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            soilMap.add(new Long[] {range[0],range[1],range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while(currentLine.matches(".*[0-9].*")){
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x-> !Objects.equals(x, " "))).toArray(String[]::new);
            for(int i = 0; i<numbers.length; i++){
                numbers[i] = numbers[i].replaceAll("[^0-9]","");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.prLongln(range[i]);
            }
            fertiliserMap.add(new Long[] {range[0],range[1],range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while(currentLine.matches(".*[0-9].*")){
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x-> !Objects.equals(x, " "))).toArray(String[]::new);
            for(int i = 0; i<numbers.length; i++){
                numbers[i] = numbers[i].replaceAll("[^0-9]","");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            waterMap.add(new Long[] {range[0],range[1],range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while(currentLine.matches(".*[0-9].*")){
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x-> !Objects.equals(x, " "))).toArray(String[]::new);
            for(int i = 0; i<numbers.length; i++){
                numbers[i] = numbers[i].replaceAll("[^0-9]","");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            lightMap.add(new Long[] {range[0],range[1],range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while(currentLine.matches(".*[0-9].*")){
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x-> !Objects.equals(x, " "))).toArray(String[]::new);
            for(int i = 0; i<numbers.length; i++){
                numbers[i] = numbers[i].replaceAll("[^0-9]","");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            temperatureMap.add(new Long[] {range[0],range[1],range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while(currentLine.matches(".*[0-9].*")){
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x-> !Objects.equals(x, " "))).toArray(String[]::new);
            for(int i = 0; i<numbers.length; i++){
                numbers[i] = numbers[i].replaceAll("[^0-9]","");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            humidityMap.add(new Long[] {range[0],range[1],range[2]});
            currentLine = in.nextLine();
        }
        //System.out.println();
        in.nextLine();
        currentLine = in.nextLine();
        while(currentLine.matches(".*[0-9].*")){
            numbers = (Arrays.stream(currentLine.split(" ")).filter(x-> !Objects.equals(x, " "))).toArray(String[]::new);
            for(int i = 0; i<numbers.length; i++){
                numbers[i] = numbers[i].replaceAll("[^0-9]","");
                range[i] = Long.parseLong(numbers[i]);
                //System.out.println(range[i]);
            }
            locationMap.add(new Long[] {range[0],range[1],range[2]});
            if(in.hasNextLine()) {
                currentLine = in.nextLine();
            }
            else{
                currentLine = "";
            }
        }
        System.out.println(locations);
        done = false;
        for(int i = 0; i<seeds.size(); i++){
            for(Long[] destToSource : soilMap){
                if(locations.get(i)>=destToSource[1] && locations.get(i)<destToSource[1]+destToSource[2] && !done){
                    locations.set(i,destToSource[0] + Math.abs(locations.get(i) - destToSource[1]));
                    done = true;
                }
            }
            System.out.println(locations);
            done = false;
            for(Long[] destToSource : fertiliserMap){
                if(locations.get(i)>=destToSource[1] && locations.get(i)<destToSource[1]+destToSource[2] && !done){
                    locations.set(i,destToSource[0] + Math.abs(locations.get(i) - destToSource[1]));
                    done = true;
                }
            }
            System.out.println(locations);
            done = false;
            for(Long[] destToSource : waterMap){
                if(locations.get(i)>=destToSource[1] && locations.get(i)<destToSource[1]+destToSource[2] && !done){
                    locations.set(i,destToSource[0] + Math.abs(locations.get(i) - destToSource[1]));
                    done = true;
                }
            }
            done = false;
            System.out.println(locations);
            for(Long[] destToSource : lightMap){
                if(locations.get(i)>=destToSource[1] && locations.get(i)<destToSource[1]+destToSource[2] && !done){
                    locations.set(i,destToSource[0] + Math.abs(locations.get(i) - destToSource[1]));
                    done = true;
                }
            }
            done = false;
            System.out.println(locations);
            for(Long[] destToSource : temperatureMap){
                if(locations.get(i)>=destToSource[1] && locations.get(i)<destToSource[1]+destToSource[2] && !done){
                    locations.set(i,destToSource[0] + Math.abs(locations.get(i) - destToSource[1]));
                    done = true;
                }
            }
            done = false;
            System.out.println(locations);
            for(Long[] destToSource : humidityMap){
                if(locations.get(i)>=destToSource[1] && locations.get(i)<destToSource[1]+destToSource[2] && !done){
                    locations.set(i,destToSource[0] + Math.abs(locations.get(i) - destToSource[1]));
                    done = true;
                }
            }
            done = false;
            System.out.println(locations);
            for(Long[] destToSource : locationMap){
                if(locations.get(i)>=destToSource[1] && locations.get(i)<destToSource[1]+destToSource[2] && !done){
                    locations.set(i,destToSource[0] + Math.abs(locations.get(i) - destToSource[1]));
                    done = true;
                }
            }
            done = false;
        }
        System.out.println(locations);
        min = locations.get(0);
        for (Long location : locations) {
            if (location < min) {
                min = location;
            }
        }
        System.out.println(min);
    }
}
