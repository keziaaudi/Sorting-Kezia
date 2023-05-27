/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author keziaaudi
 */
public class Sorting {

    private String name;
    private int age;
    private String address;

    public Sorting(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Address: " + address;
    }
}

public class toSorting{
    private static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 3) {
            displayMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    inputNewData(scanner);
                    break;
                case 2:
                    viewPatientsData(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void displayMenu() {
        System.out.println("---- Patient's Data Program ----");
        System.out.println("1. Input New Data");
        System.out.println("2. View Patient's Data");
        System.out.println("3. Exit");
    }

    private static void inputNewData(Scanner scanner) {
        System.out.println("---- Input New Data ----");

        System.out.print("Enter Name (3-20 characters): ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter Age (10-100): ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 10 && age <= 100) {
                    break;
                } else {
                    System.out.println("Invalid age entered. Age must be between 10 and 100. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Age must be a numerical value. Please try again.");
            }
        }

        System.out.print("Enter Address (5-30 characters): ");
        String address = scanner.nextLine();

        if (name.length() >= 3 && name.length() <= 20 && address.length() >= 5 && address.length() <= 30) {
            patients.add(new Patient(name, age, address));
            System.out.println("Data has been successfully inserted!");
        } else {
            System.out.println("Invalid data entered. Please try again.");
        }
    }

    private static void viewPatientsData(Scanner scanner) {
        System.out.println("---- View Patient's Data ----");

        if (patients.isEmpty()) {
            System.out.println("No Data!");
            return;
        }

        System.out.println("Patient's Data:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }

        int choice = 0;
        while (choice != 5) {
            displaySubMenu();
            System.out.print("Choose a sub-menu option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    sortDataByNameAscending();
                    break;
                case 2:
                    sortDataByNameDescending();
                    break;
                case 3:
                    sortDataByAgeAscending();
                    break;
                case 4:
                    sortDataByAgeDescending();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void displaySubMenu() {
        System.out.println("\n---- Sub-menu ----");
        System.out.println("1. Sort Data by Name Ascending");
        System.out.println("2. Sort Data by Name Descending");
        System.out.println("3. Sort Data by Age Ascending");
        System.out.println("4. Sort Data by Age Descending");
        System.out.println("5. Back");
    }

    private static void sortDataByNameAscending() {
        Collections.sort(patients, Comparator.comparing(Patient::getName));
        System.out.println("Data sorted by Name (ascending):");
        printPatientsData();
    }

    private static void sortDataByNameDescending() {
        Collections.sort(patients, Comparator.comparing(Patient::getName).reversed());
        System.out.println("Data sorted by Name (descending):");
        printPatientsData();
    }

    private static void sortDataByAgeAscending() {
        Collections.sort(patients, Comparator.comparingInt(Patient::getAge));
        System.out.println("Data sorted by Age (ascending):");
        printPatientsData();
    }

    private static void sortDataByAgeDescending() {
        Collections.sort(patients, Comparator.comparingInt(Patient::getAge).reversed());
        System.out.println("Data sorted by Age (descending):");
        printPatientsData();
    }

    private static void printPatientsData() {
        if (patients.isEmpty()) {
            System.out.println("No Data!");
            return;
        }

        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }
    }
}