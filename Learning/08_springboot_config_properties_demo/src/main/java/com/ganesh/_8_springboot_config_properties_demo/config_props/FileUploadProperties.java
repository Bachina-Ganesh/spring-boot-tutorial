package com.ganesh._8_springboot_config_properties_demo.config_props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
public class FileUploadProperties {

    private String fileName;
    private String type;
    private long acceptedSize;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAcceptedSize() {
        return acceptedSize;
    }

    public void setAcceptedSize(long acceptedSize) {
        this.acceptedSize = acceptedSize;
    }
}
