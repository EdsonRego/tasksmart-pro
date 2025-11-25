package com.tasksmartpro.filestorage.repository;

import com.tasksmartpro.filestorage.entity.StoredFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredFileRepository extends JpaRepository<StoredFile, Long> {
}
