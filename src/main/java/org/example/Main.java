package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Ubung 1
        String filePath = "src/main/resources/ninja_events.xml";
        CustomFileReader reader = new CustomFileReader(filePath);
        List<Schlachten> schlachten = reader.readCases();

        if (schlachten == null || schlachten.isEmpty()) {
            System.out.println("No schlachten found.");
            return;
        }

        // Ubung 2
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kraftpunkte: ");
        double kraftpunkte = scanner.nextDouble();
        Set<String> uniqueNames = new HashSet<>();
        for(Schlachten schlachtObj : schlachten) {
            String ninjaName = schlachtObj.getCharakterName();
            if (schlachtObj.getKraftpunkte() > kraftpunkte) {
                uniqueNames.add(schlachtObj.getCharakterName());
            }
        }
        uniqueNames.forEach(System.out::println);

        // Ubung 3

    }
}