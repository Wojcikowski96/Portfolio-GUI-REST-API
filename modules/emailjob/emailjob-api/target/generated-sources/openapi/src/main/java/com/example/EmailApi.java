/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example;

import com.example.model.EmailDTO;
import com.example.model.Error;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-21T11:24:43.666918900+01:00[Europe/Warsaw]")
@Validated
@Tag(name = "email", description = "the email API")
public interface EmailApi {

    default EmailApiDelegate getDelegate() {
        return new EmailApiDelegate() {};
    }

    /**
     * POST /email/send : Wysyła email na podstawie danych zrzuconych z formularza kontaktowego
     * Operacja dostępna dla wszystkich
     *
     * @param emailDTO  (required)
     * @return Wiadomość wysłana do administratora portalu (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     */
    @Operation(
        operationId = "sendMessage",
        summary = "Wysyła email na podstawie danych zrzuconych z formularza kontaktowego",
        responses = {
            @ApiResponse(responseCode = "200", description = "Wiadomość wysłana do administratora portalu"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/email/send",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> sendMessage(
        @Parameter(name = "EmailDTO", description = "", required = true) @Valid @RequestBody EmailDTO emailDTO
    ) {
        return getDelegate().sendMessage(emailDTO);
    }

}