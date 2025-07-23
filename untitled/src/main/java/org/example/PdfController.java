package org.example;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PdfController {

    private final ConfigurationService configurationService;

    @Autowired
    public PdfController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @PostMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestParam List<String> selectedConfigs) {
        try {
            // Списък за съхранение на избраните конфигурации
            List<Config> configsToExport = new ArrayList<>();

            // Намиране на избраните конфигурации чрез техните имена
            for (String configName : selectedConfigs) {
                Config config = configurationService.getConfigurationsByPrice(0, Double.MAX_VALUE).stream()
                        .filter(c -> c.getName().equals(configName))
                        .findFirst()
                        .orElse(null);

                if (config != null) {
                    configsToExport.add(config);
                }
            }

            // Ако няма избрани конфигурации
            if (configsToExport.isEmpty()) {
                return ResponseEntity.status(400).body("Няма избрани конфигурации".getBytes());
            }

            // Генериране на PDF
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Добавяне на конфигурациите към PDF
            for (Config config : configsToExport) {
                document.add(new Paragraph("Конфигурация: " + config.getName()));
                document.add(new Paragraph("CPU: " + config.getCpu()));
                document.add(new Paragraph("GPU: " + config.getGpu()));
                document.add(new Paragraph("STORAGE: " + config.getStorage()));
                document.add(new Paragraph("RAM: " + config.getRam() + " GB"));
                document.add(new Paragraph("Цена: " + config.getPrice() + "лв"));
                document.add(new Paragraph("\n"));  // Празен ред между конфигурациите
            }

            document.close();

            // Връщане на PDF като файл за сваляне
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=configurations.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(out.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}

