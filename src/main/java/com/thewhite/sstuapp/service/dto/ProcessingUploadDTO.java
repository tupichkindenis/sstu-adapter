package com.thewhite.sstuapp.service.dto;

import com.thewhite.sstuapp.domain.enumeration.UploadStatusEnum;

import java.time.LocalDateTime;

/**
 * Created by tupichkindenis on 17.08.17.
 */
public class ProcessingUploadDTO {
    private UploadStatusEnum uploadStatus;
    private LocalDateTime uploadTime;
    private String errorMessage;
}
