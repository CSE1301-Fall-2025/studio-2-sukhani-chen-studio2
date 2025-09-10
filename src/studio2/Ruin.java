import java.util.Scanner;

public class Ruin {

    public static void main (String[] args) {

       Scanner scan = new Scanner(System.in);
       
        System.out.println("Enter your start amount");
        double startAmount = scan.nextDouble();
         System.out.println("Enter your win chance");
        double winChance = scan.nextDouble();
         System.out.println("Enter your win limit");
        double winLimit = scan.nextDouble(); 

        boolean gameStatus = true;
        double totalSimulations = 0.0;

            int winTimes = 0;
            double loseTimes = 0.0;
            while (startAmount < winLimit && startAmount > 0) {

                double odds = Math.random();

                if (odds < winChance ) {
                    totalSimulations++;
                    startAmount++;
                    System.out.println ("Simulation: " + totalSimulations + " WIN");
                    winTimes++;
            
            } else if (odds >= winChance) {
                totalSimulations++;
                startAmount--;
                System.out.println ("Simulation: " + totalSimulations + " LOSE");
                loseTimes++;
            }
            
        }

        double realRuin = (double) Math.round (((loseTimes/totalSimulations)*100)/100);
        double a = (1-winChance)/winChance;

        double expectedRuin = 0.0;

        if (winChance == 0.5) {
        expectedRuin = 1-(startAmount/winLimit);
        } 
        else {
        expectedRuin = (Math.pow (a, startAmount) - Math.pow (a, winLimit)) / (1-Math.pow(a, winLimit));
        }

        System.out.println ("From simulation: " + realRuin + " Expected: " + expectedRuin);

        }
}
