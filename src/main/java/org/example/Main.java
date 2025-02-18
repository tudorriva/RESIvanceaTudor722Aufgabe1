package org.example;

import java.util.List;

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
    }
}