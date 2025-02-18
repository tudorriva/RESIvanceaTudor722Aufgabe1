package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "logs") // Maps to <logs> in the XML
public class SchlachtenLogs {
    private List<Schlachten> logs;

    @XmlElement(name = "log") // Maps to <log> elements inside <logs>
    public List<Schlachten> getLogs() {
        return logs;
    }

    public void setLogs(List<Schlachten> logs) {
        this.logs = logs;
    }
}