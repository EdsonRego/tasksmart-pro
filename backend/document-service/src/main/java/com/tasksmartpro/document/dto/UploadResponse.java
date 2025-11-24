package com.tasksmartpro.document.dto;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class UploadResponse {
    private Long id;
    private String fileName;
    private String url;
}
