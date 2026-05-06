package com.cts.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String storeReportImage(Long reportId, MultipartFile file);
}
