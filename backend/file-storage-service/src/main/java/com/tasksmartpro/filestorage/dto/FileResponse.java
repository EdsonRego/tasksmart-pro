package com.tasksmartpro.filestorage.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {
    private Long id;
    private String fileName;
    private String url;
    private Long size;
}
