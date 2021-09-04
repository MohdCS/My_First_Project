package Main;

import java.util.Random;
import java.util.Scanner;
public class Main {
    static String your_name;
    public static void main(String[] args) {
        name_input();
    }

    private static void name_input(){
        System.out.print("What's your name? ");
        Scanner input = new Scanner(System.in);
        your_name = input.next();
        System.out.println("Hello \""+ your_name +"\"!\n-------------------------");
        select();
    }

    private static void radius_converter(){
        Scanner input_radius = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        try {
            double radius = input_radius.nextDouble();
            double diameter = radius * 2;
            double circumference = Math.PI * 2 * radius;
            double area = radius * radius * Math.PI;
            System.out.println("Diameter: "
                    +diameter+"\n"+"Circumference: "
                    +circumference+"\n"+"Area: "
                    +area+
                    "\n-------------------------");
            try_something_else();
        }
        catch(Exception e) {
            System.out.print("Invalid input!\n");
            radius_converter();
        }
    }

    private static void pass_gen(){
        Scanner input_passLength = new Scanner(System.in);
        String upAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowAlpha = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "!@#$%^&*()-_+='/.,[]{}<>";
        String numbers = "0123456789";
        String pass = upAlpha + lowAlpha + symbols + numbers;
        StringBuilder string_builder = new StringBuilder();
        Random random = new Random();
        System.out.print("Enter length of password: ");
        try {
            int length = input_passLength.nextInt();
            for(int i = 0; i < length; i++){
                int index = random.nextInt(pass.length());
                char randomChar = pass.charAt(index);
                string_builder.append(randomChar);
            }
            String generated_pass = string_builder.toString();
            System.out.println("Generated password is: \n" + generated_pass +"\n-------------------------");
            try_something_else();
        }
        catch(Exception e) {
            System.out.print("Invalid input!\n");
            pass_gen();
        }
    }

    private static void try_something_else(){
        Scanner input = new Scanner(System.in);
        System.out.print("Try something else (Yes/No)? ");
        String try_value = input.next();
        if(null == try_value){
            System.out.print("Invalid input!\n");
            try_something_else();
        }
        else switch (try_value) {
            case "Yes", "yes", "YES", "y", "Y" -> {
                System.out.println("-------------------------");
                select();
            }
            case "No", "no", "NO", "n", "N" -> System.out.print(".\n.\n.\nBye \"" + your_name + "\"!\n");
            default -> {
                System.out.print("Invalid input!\n");
                try_something_else();
            }
        }
    }

    private static void select(){
        System.out.print("""
                What would you like to choose?
                1.Radius Converter
                2.Password Generator
                3.Exit
                """);
        Scanner input = new Scanner(System.in);
        String choice_value = input.next();
        switch (choice_value) {
            case "1" -> {
                System.out.println("-------------------------");
                radius_converter();
            }
            case "2" -> {
                System.out.println("-------------------------");
                pass_gen();
            }
            case "3", "Exit", "exit", "EXIT", "E", "e" -> System.out.print(".\n.\n.\nBye \"" + your_name + "\"!\n");
            default -> {
                System.out.print("Invalid input!\n");
                select();
            }
        }
    }
}