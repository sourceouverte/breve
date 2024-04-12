package org.breve.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IngestionInputDto {
    private String longUrl;

    private String customCode;

    private String description;

}
