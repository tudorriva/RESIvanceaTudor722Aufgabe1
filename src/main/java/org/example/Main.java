package org.example;

import java.io.FileWriter;
import java.io.IOException;
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
        Map<Stuffe, Long> stuffeSchlachten = schlachten.stream()
                .collect(Collectors.groupingBy(Schlachten::getStufe, Collectors.counting()));
        Map<Map.Entry<Stuffe, Long>, Double> sortedStuffeSchlachten = new HashMap<>();
        for (Map.Entry<Stuffe, Long> entry : stuffeSchlachten.entrySet()) {
            double totalKraftpunkte = schlachten.stream()
                    .filter(schlacht -> schlacht.getStufe().equals(entry.getKey()))
                    .mapToDouble(Schlachten::getKraftpunkte).sum();
            sortedStuffeSchlachten.put(entry, totalKraftpunkte);
        }

        List<Map.Entry<Map.Entry<Stuffe, Long>, Double>> sortedStuffeSchlachtenList = new ArrayList<>(sortedStuffeSchlachten.entrySet());

        sortedStuffeSchlachtenList.sort((e1, e2) -> {
            int cmp = e2.getValue().compareTo(e1.getValue());
            if (cmp == 0) return e1.getKey().getKey().compareTo(e2.getKey().getKey());
            return cmp;}
            );

        try (FileWriter writer = new FileWriter("gesammtzahl.txt")) {
            for (Map.Entry<Map.Entry<Stuffe, Long>, Double> entry : sortedStuffeSchlachtenList) {
                writer.write(entry.getKey().getKey() + "%" + entry.getKey().getValue() + "#" + entry.getValue());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}