import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner kb = new Scanner (System.in);

        double[] temperatures = new double[7];
        for(int i = 0; i < temperatures.length; i++) {
            System.out.print("Enter the temperature for day " +(i+1)+ ": ");
            temperatures[i] = kb.nextDouble();
        }

        double LowestTemp = temperatures[0];
        int LowestTempIndex = 0;
        double HighestTemp = temperatures[0];
        int HighestTempIndex = 0;
        
        for(int i = 0; i < temperatures.length; i++) {
            if(temperatures[i] < LowestTemp) {
                LowestTemp = temperatures[i];
                LowestTempIndex = i;
            }
            if(temperatures[i] > HighestTemp) {
                HighestTemp = temperatures[i];
                HighestTempIndex = i;
            }
        }
        System.out.println("Lowest Temp day: " +(LowestTempIndex+1));
        System.out.println("Lowest Temp: " +LowestTemp);
        System.out.println("Highest Temp day: " +(HighestTempIndex+1));
        System.out.println("Highest Temp: " +HighestTemp);

    }
}
