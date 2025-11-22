package com.tasksmartpro.checklist.controller;

import com.tasksmartpro.checklist.dto.*;
import com.tasksmartpro.checklist.entity.ChecklistTemplateDocument;
import com.tasksmartpro.checklist.service.ChecklistService;
import com.tasksmartpro.checklist.service.ChecklistTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checklists")
@RequiredArgsConstructor
public class ChecklistController {

    private final ChecklistService checklistService;
    private final ChecklistTemplateService templateService;

    @PostMapping
    public ResponseEntity<ChecklistDTO> create(@RequestBody CreateChecklistRequest request) {
        return ResponseEntity.ok(checklistService.createChecklist(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(checklistService.getChecklist(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChecklistDTO> update(
            @PathVariable String id,
            @RequestBody UpdateChecklistRequest request) {
        return ResponseEntity.ok(checklistService.updateChecklist(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        checklistService.deleteChecklist(id);
        return ResponseEntity.noContent().build();
    }

    // Templates
    @PostMapping("/templates")
    public ResponseEntity<ChecklistTemplateDocument> createTemplate(
            @RequestBody CreateTemplateRequest request) {
        return ResponseEntity.ok(templateService.createTemplate(request));
    }
}
