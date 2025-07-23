package org.example;

import org.example.Config;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConfigurationService {
    private final List<Config> configurations = new ArrayList<>();

    public ConfigurationService() {
        configurations.add(new Config("Budget Build", "AMD Ryzen 5 5600x", "RX 6600", "1TB NVMe", 16, 1200));
        configurations.add(new Config("Gaming Mid", "Intel i5-13600K", "RTX 4060 Ti", "1TB NVMe", 16, 1900));
        configurations.add(new Config("Ultra Gaming", "Intel i9-13900K", "RTX 5090", "2TB NVMe", 32, 8500));
        configurations.add(new Config("Streaming PC", "AMD Ryzen 7 7800X3D", "RTX 4070 Ti", "4TB NVMe", 64, 5900));
        configurations.add(new Config("Office PC", "Intel i3-13100", "Integrated", "500GB SSD", 8, 900));
        configurations.add(new Config("Budget Gaming Build", "AMD Ryzen 3 5300G", "Integrated Vega 6", "500GB SSD", 16, 950));

    }

    public List<Config> getConfigurationsByPrice(double min, double max) {
        return configurations.stream()
                .filter(c -> c.getPrice() >= min && c.getPrice() <= max)
                .collect(Collectors.toList());
    }
}
