import java.util.Scanner;

public class Ruin {

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
       
        System.out.println("Enter your start amount");
        int startAmount = scan.nextInt();
        System.out.println("Enter your win chance");
        double winChance = scan.nextDouble();
        System.out.println("Enter your win limit");
        int winLimit = scan.nextInt(); 
        System.out.println("Enter total simulations");
        int totalSimulations = scan.nextInt(); 

        boolean gameStatus = true;

        int winDays = 0;
        int loseDays = 0;
        int timesInDay = 0;
        int amount=0;
        for (int i=0;i<totalSimulations;i++){
            amount=startAmount;
            timesInDay=0;
            while (amount < winLimit && amount > 0) {

                double odds = Math.random();
                //System.out.println("the random number is: "+odds);
                if (odds < winChance ) {
                    amount++;
                } 
                else {
                    amount--;
                } 
                timesInDay++;
            }
            if (amount==0){
                loseDays++;
                System.out.println ("Simulation " + i +" : "+ timesInDay+ " LOSE");
            }
            else{
                winDays++;
                System.out.println ("Simulation " + i +" : "+ timesInDay+ " WIN");
            }

                
        }
        System.out.println("Losses: "+ loseDays+ " Simulations: "+totalSimulations);

        double realRuin = (double) Math.round ((1.0*loseDays/totalSimulations)*100)/100.0;
        double a = (1-winChance)/winChance;

        double expectedRuin = 0.0;

        if (winChance == 0.5) {
            expectedRuin = 1-(1.0*startAmount/winLimit);
        } 
        else {
            expectedRuin = (Math.pow (a, startAmount) - Math.pow (a, winLimit)) / (1-Math.pow(a, winLimit));
        }

        System.out.println ("Ruin Rate from Simulation: " + realRuin + " Expected Ruin Rate: " + expectedRuin);

        }
    }

