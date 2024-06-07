package breve.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema (description = "request data model in Json formate")
public class IngestionInputDto {
    @Schema(type = "string", description = "Long Url")
    private String longUrl;

    @Schema(type = "string", description = "Custom Code")
    private String customCode;

    @Schema(type = "string", description = "Description")
    private String description;
}
