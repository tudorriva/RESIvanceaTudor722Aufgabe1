package org.example;

import java.util.*;
import java.util.stream.Collectors;

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
        for (Schlachten schlachtObj : schlachten) {
            String ninjaName = schlachtObj.getCharakterName();
            if (schlachtObj.getKraftpunkte() > kraftpunkte) {
                uniqueNames.add(schlachtObj.getCharakterName());
            }
        }
        uniqueNames.forEach(System.out::println);

        // Ubung 3
        List<Schlachten> JoninSchlachten = schlachten.stream()
                .filter(schlachtObj -> Stuffe.Jonin.equals(schlachtObj.getStufe()))
                .sorted(Comparator.comparing(Schlachten::getDatum).reversed())
                .collect(Collectors.toList());

        System.out.println("\nJonin Ereignisse sortiert nach Date: ");
        for (Schlachten schlacht : JoninSchlachten) {
            System.out.println(schlacht.getDatum() + ": " + schlacht.getCharakterName() + " - " + schlacht.getBeschreibung());
        }

        // Ubung 4


    }
}