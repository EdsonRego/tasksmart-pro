package com.tasksmartpro.checklist.service;

import com.tasksmartpro.checklist.dto.*;
import com.tasksmartpro.checklist.entity.ChecklistDocument;
import com.tasksmartpro.checklist.repository.ChecklistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChecklistService {

    private final ChecklistRepository repository;

    public ChecklistDTO createChecklist(CreateChecklistRequest request) {

        ChecklistDocument checklist = ChecklistDocument.builder()
                .tenantId(request.getTenantId())
                .name(request.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .items(
                        request.getItemDescriptions().stream()
                                .map(desc -> ChecklistDocument.ChecklistItem.builder()
                                        .description(desc)
                                        .status("PENDING")
                                        .build()
                                ).collect(Collectors.toList())
                )
                .build();

        ChecklistDocument saved = repository.save(checklist);

        return toDTO(saved);
    }

    public ChecklistDTO updateChecklist(String id, UpdateChecklistRequest request) {

        ChecklistDocument existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checklist not found"));

        existing.setName(request.getName());
        existing.setUpdatedAt(LocalDateTime.now());

        existing.setItems(
                request.getItems().stream()
                        .map(item -> ChecklistDocument.ChecklistItem.builder()
                                .description(item.getDescription())
                                .status(item.getStatus())
                                .build())
                        .collect(Collectors.toList())
        );

        return toDTO(repository.save(existing));
    }

    public ChecklistDTO getChecklist(String id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Checklist not found"));
    }

    public void deleteChecklist(String id) {
        repository.deleteById(id);
    }

    private ChecklistDTO toDTO(ChecklistDocument doc) {
        return ChecklistDTO.builder()
                .id(doc.getId())
                .tenantId(doc.getTenantId())
                .name(doc.getName())
                .items(
                        doc.getItems().stream()
                                .map(it -> ChecklistItemDTO.builder()
                                        .description(it.getDescription())
                                        .status(it.getStatus())
                                        .build()
                                ).toList()
                )
                .build();
    }
}
