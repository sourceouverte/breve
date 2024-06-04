package org.breve.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IngestionInputDto {
    private String longUrl;

    private String customCode;

    private String description;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
