package com.tasksmartpro.checklist.service;

import com.tasksmartpro.checklist.dto.CreateTemplateRequest;
import com.tasksmartpro.checklist.entity.ChecklistTemplateDocument;
import com.tasksmartpro.checklist.repository.ChecklistTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChecklistTemplateService {

    private final ChecklistTemplateRepository repository;

    public ChecklistTemplateDocument createTemplate(CreateTemplateRequest request) {

        ChecklistTemplateDocument template = ChecklistTemplateDocument.builder()
                .tenantId(request.getTenantId())
                .name(request.getName())
                .itemDescriptions(request.getItemDescriptions())
                .build();

        return repository.save(template);
    }
}
