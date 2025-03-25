package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var input = new Scanner(System.in);
        playFizzBuzz(input);
    }

    public static void playFizzBuzz(Scanner input) {
       int startAt = 1;
       while (startAt <= 100) {
           System.out.println(outputFizzBuzz(startAt));
           startAt++;

           if (startAt > 100) {
               break;
           }

           String expectedOutput = outputFizzBuzz(startAt);
           String userInput = input.nextLine();
           if (!userInput.equals(expectedOutput)) {
               System.out.println("Ошибка. Начинай снова.");
               startAt = 1;
           } else {
               startAt++;
           }
       }
    }

    public static String outputFizzBuzz(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
