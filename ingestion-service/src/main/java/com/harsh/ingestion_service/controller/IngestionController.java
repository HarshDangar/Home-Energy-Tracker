package com.harsh.ingestion_service.controller;

import com.harsh.ingestion_service.domain.dto.EnergyUsageDto;
import com.harsh.ingestion_service.service.IngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingestion")
@RequiredArgsConstructor
public class IngestionController {

    private final IngestionService ingestionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void ingestData(@RequestBody EnergyUsageDto energyUsageDto) {
        ingestionService.ingestEnergyUsage(energyUsageDto);
    }
}
