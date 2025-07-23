package org.example;


import org.example.Config;
import org.example.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ConfigurationService configService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/configs")
    public String getConfigs(@RequestParam double min, @RequestParam double max, Model model) {
        List<Config> configs = configService.getConfigurationsByPrice(min, max);
        model.addAttribute("configs", configs);
        return "configs";
    }
}
