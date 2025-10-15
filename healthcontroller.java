package com.nutri.controller;

import com.nutri.entity.SymptomLog;
import com.nutri.repository.SymptomLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @Autowired
    private SymptomLogRepository symptomLogRepository;

    @PostMapping("/log-symptoms")
    public Map<String, String> logSymptoms(@RequestBody Map<String, List<String>> payload) {
        List<String> symptoms = payload.get("symptoms");
        SymptomLog log = new SymptomLog();
        log.setSymptoms(String.join(",", symptoms));
        symptomLogRepository.save(log);
        return Map.of("message", "Symptoms logged successfully");
    }

    @GetMapping("/get-symptoms")
    public List<SymptomLog> getSymptoms() {
        return symptomLogRepository.findAll();
    }
}
