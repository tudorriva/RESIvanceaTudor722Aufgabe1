package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReader {
    private final String filePath;

    public CustomFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Schlachten> readCases() {
        String extension = getExtension(filePath);
        switch (extension) {
            case "xml":
                return readXml();
            default:
                System.out.println("Unsupported file format.");
                return null;
        }
    }

    private String getExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
    }

    private List<Schlachten> readXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(SchlachtenLogs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchlachtenLogs logs = (SchlachtenLogs) unmarshaller.unmarshal(new File(filePath));

            if (logs == null || logs.getLogs() == null) {
                System.out.println("No cases found in the XML file.");
                return new ArrayList<>();
            }

            return logs.getLogs();
        } catch (Exception e) {
            System.out.println("Error reading XML file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}