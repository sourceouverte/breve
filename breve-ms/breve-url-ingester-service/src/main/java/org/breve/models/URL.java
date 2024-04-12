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
public class URL implements Serializable {

    @Id
    private String id;

    @Indexed
    private String longUrl;

    @Indexed
    private String customCode;

    @Indexed
    private String description;

}
