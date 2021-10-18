package com.aj.dvd.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int input = scanner.nextInt();
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        boolean isValid = false;
        int input;
        do {
            System.out.println(prompt + "\nThe value must be between " + min + " and " + max);
            input = scanner.nextInt();
            if (input > max || input < min) {
                System.out.println("must be in range!");
            } else {
                isValid = true;
                scanner.nextLine();
            }
        } while (!isValid);
        return input;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Double input = scanner.nextDouble();
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {

        boolean isValid = false;
        double input;
        do {
            System.out.println(prompt + "\nThe value must be between " + min + " and " + max);
            input = scanner.nextDouble();
            if (input > max || input < min) {
                System.out.println("must be in range!");
            } else {
                isValid = true;
                scanner.nextLine();
            }
        } while (!isValid);
        return input;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float input = scanner.nextFloat();
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {

        boolean isValid = false;
        float input;
        do {
            System.out.println(prompt + "\nThe value must be between " + min + " and " + max);
            input = scanner.nextFloat();
            if (input > max || input < min) {
                System.out.println("must be in range!");
            } else {
                isValid = true;
                scanner.nextLine();
            }
        } while (!isValid);
        return input;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long input = scanner.nextLong();
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) {

        boolean isValid = false;
        long input;
        do {
            System.out.println(prompt + "\nThe value must be between " + min + " and " + max);
            input = scanner.nextLong();
            if (input > max || input < min) {
                System.out.println("must be in range!");
            } else {
                isValid = true;
                scanner.nextLine();
            }
        } while (!isValid);
        return input;
    }
}
