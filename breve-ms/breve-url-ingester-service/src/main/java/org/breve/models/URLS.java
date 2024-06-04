package org.breve.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@Document(collection = "URLS")
public class URLS implements Serializable {

    @Id
    private String id;

    @Indexed
    private String longUrl;

    @Indexed
    private String customCode;

    @Indexed
    private String description;

    @Indexed
    private String shortUrl;

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setShortUrl(String longUrl) {
        this.shortUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
