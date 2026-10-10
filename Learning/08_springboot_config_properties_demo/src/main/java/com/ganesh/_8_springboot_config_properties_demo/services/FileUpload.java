package com.ganesh._8_springboot_config_properties_demo.services;

import com.ganesh._8_springboot_config_properties_demo.config_props.FileUploadProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileUpload {

    private String fileName;
    private String fileType;
    private long acceptedSize;

    private final FileUploadProperties fileUploadProperties;

    public FileUpload(FileUploadProperties fileUploadProperties) {
        this.fileUploadProperties = fileUploadProperties;
        this.fileName = fileUploadProperties.getFileName();
        this.fileType = fileUploadProperties.getType();
        this.acceptedSize = fileUploadProperties.getAcceptedSize();
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public long getAcceptedSize() {
        return acceptedSize;
    }
}
