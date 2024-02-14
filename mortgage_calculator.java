import java.text.NumberFormat;
import java.util.*;
public class mortgage_calculator {

    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100; 
        Scanner sc = new Scanner(System.in);
       
       
        int principal = 0; 
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = sc.nextInt();
            if(principal >= 1_000 && principal <= 1_000_000){
                break;
                
            }else{
                System.out.println("The principal is not valid, try again.");
            }
        }
        
        double annual_interest_rate = 0;
        double monthlyInterest = 0;
        while(true){
            System.out.print("Annual Interest Rate: ");
            annual_interest_rate = sc.nextDouble();
            if(annual_interest_rate >= 1 && annual_interest_rate <= 30){
                break;
            }else{
                System.out.println("Should be greater than 0 and less than or equal to 30.");
            }
            double monthlyInterest_temp = annual_interest_rate / PERCENT / MONTHS_IN_YEAR;
            monthlyInterest = monthlyInterest_temp;
        }
        
        int numberOfPayment = 0;
        while(true){
            System.out.print("Period (Year): ");
            byte year = sc.nextByte();
            if(0 < year && 30 >= year){
                numberOfPayment = year * MONTHS_IN_YEAR;
                break;
            }else{
                System.out.println("Period should be between 0 and 31(excluded).");
            }
        }
        
        sc.close();

        double mortgage = (principal * (monthlyInterest*Math.pow(1 + monthlyInterest, numberOfPayment))) / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        
        System.out.println("Mortgage: " + mortgageFormatted);

    }

}
