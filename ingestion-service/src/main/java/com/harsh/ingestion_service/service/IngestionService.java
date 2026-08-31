package com.harsh.ingestion_service.service;

import com.harsh.ingestion_service.domain.dto.EnergyUsageDto;
import com.harsh.kafka.event.EnergyUsageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class IngestionService {

    private final KafkaTemplate<String, EnergyUsageEvent> kafkaTemplate;

    public void ingestEnergyUsage(EnergyUsageDto dto) {
        //Convert dto to event
        EnergyUsageEvent event = EnergyUsageEvent.builder()
                .deviceId(dto.deviceId())
                .energyConsumed(dto.energyConsumed())
                .timeStamp(dto.timeStamp())
                .build();

        //Send to kafka topic
        kafkaTemplate.send("energy-usage", event);
        log.info("Ingested Energy Usage Event: {}" , event);
    }
}
