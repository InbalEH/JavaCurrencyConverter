import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

   //Global ArrayList
    static ArrayList<Double> list = new ArrayList<>();

    //The whole program
    public static void main(String[] args) {
        System.out.println("Welcome to currency converter");
        currencyConverter();
    }

    //Contains the functions of the calculator.
    private static void currencyConverter(){
            try {
                choose();
                cont();

            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Invalid choice, please try again");
                currencyConverter();
            }
        }

        //Choice screen (first and second screen) and currency conversion.
        private static void choose() {
        ILS ILS = new ILS();
        USD USD = new USD();
        ILS.getValue();
        USD.getValue();
        Scanner a = new Scanner(System.in);

        System.out.println("Please choose an option (1/2):");
        System.out.println("1.Dollars to Shekels");
        System.out.println("2.Shekels to Dollars");
        int choice = a.nextInt();

            if (choice == 1) {

                System.out.println("Please enter an amount to convert:");
                double amount = a.nextInt();

                double shekel = amount / ILS.getValue();
                System.out.println(amount + " Dollars is " + shekel + " Shekels");

        //Adds conversion result to list
                list.add(shekel);

            } else if (choice == 2) {

                System.out.println("Please enter an amount to convert:");
                double amount = a.nextInt();

                double dollar = amount / USD.getValue();
                System.out.println(amount + " Shekels is " + dollar + " Dollars");

        //Adds conversion result to list
                list.add(dollar);

            } else {
                System.out.println("Invalid choice, please try again");
                choose();
                cont();}
            }

        //Result and end screens
        private static void cont() {

        Scanner b = new Scanner(System.in);
        System.out.println("Would you like to start over? (Y/N)");
        String ans = b.next();


            if (ans.equalsIgnoreCase("Y")) {
                choose();
                cont();

            } else if (ans.equalsIgnoreCase("N")) {
                System.out.println("Your converted values are:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                System.out.println("Thanks for using our currency converter!");

            } else{

                System.out.println("Invalid choice, please try again");
                cont();
            }
        }
    }