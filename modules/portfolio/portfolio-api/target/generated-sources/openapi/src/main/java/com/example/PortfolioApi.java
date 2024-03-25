/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example;

import com.example.model.Error;
import com.example.model.GetPortfolioEntries200Response;
import com.example.model.PortfolioRequestData;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T13:07:24.953409300+01:00[Europe/Warsaw]")
@Validated
@Tag(name = "portfolio", description = "the portfolio API")
public interface PortfolioApi {

    default PortfolioApiDelegate getDelegate() {
        return new PortfolioApiDelegate() {};
    }

    /**
     * DELETE /portfolio/file/delete : Usuwa plik po id
     * Operacja dostępna dla administratora
     *
     * @param imageId  (required)
     * @return Usunięto plik (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     */
    @Operation(
        operationId = "deleteFile",
        summary = "Usuwa plik po id",
        responses = {
            @ApiResponse(responseCode = "201", description = "Usunięto plik"),
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
        method = RequestMethod.DELETE,
        value = "/portfolio/file/delete",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deleteFile(
        @NotNull @Parameter(name = "imageId", description = "", required = true) @Valid @RequestParam(value = "imageId", required = true) Long imageId
    ) {
        return getDelegate().deleteFile(imageId);
    }


    /**
     * DELETE /portfolio/entries/delete : Usuwa wpisy
     * Usuwanie dla roli administratora
     *
     * @param entryId  (required)
     * @return Usunięto (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     */
    @Operation(
        operationId = "deletePortfolioEntries",
        summary = "Usuwa wpisy",
        responses = {
            @ApiResponse(responseCode = "201", description = "Usunięto"),
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
        method = RequestMethod.DELETE,
        value = "/portfolio/entries/delete",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deletePortfolioEntries(
        @NotNull @Parameter(name = "entryId", description = "", required = true) @Valid @RequestParam(value = "entryId", required = true) List<Long> entryId
    ) {
        return getDelegate().deletePortfolioEntries(entryId);
    }


    /**
     * GET /portfolio/file : Pobiera obrazek lub plik PDF dla konkretnego wpisu po nazwie obrazka
     * Operacja dostępna dla wszystkich
     *
     * @param entryId  (required)
     * @param fileName  (required)
     * @return Plik PNG lub PDF do pobrania (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     */
    @Operation(
        operationId = "getImageOrPdfForPortfolioDetails",
        summary = "Pobiera obrazek lub plik PDF dla konkretnego wpisu po nazwie obrazka",
        responses = {
            @ApiResponse(responseCode = "200", description = "Plik PNG lub PDF do pobrania", content = {
                @Content(mediaType = "image/png", schema = @Schema(implementation = org.springframework.core.io.Resource.class)),
                @Content(mediaType = "application/pdf", schema = @Schema(implementation = org.springframework.core.io.Resource.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = org.springframework.core.io.Resource.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "image/png", schema = @Schema(implementation = Error.class)),
                @Content(mediaType = "application/pdf", schema = @Schema(implementation = Error.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "image/png", schema = @Schema(implementation = Error.class)),
                @Content(mediaType = "application/pdf", schema = @Schema(implementation = Error.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = {
                @Content(mediaType = "image/png", schema = @Schema(implementation = Error.class)),
                @Content(mediaType = "application/pdf", schema = @Schema(implementation = Error.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/portfolio/file",
        produces = { "image/png", "application/pdf", "application/json" }
    )
    default ResponseEntity<org.springframework.core.io.Resource> getImageOrPdfForPortfolioDetails(
        @NotNull @Parameter(name = "entryId", description = "", required = true) @Valid @RequestParam(value = "entryId", required = true) Long entryId,
        @NotNull @Parameter(name = "fileName", description = "", required = true) @Valid @RequestParam(value = "fileName", required = true) String fileName
    ) {
        return getDelegate().getImageOrPdfForPortfolioDetails(entryId, fileName);
    }


    /**
     * POST /portfolio/entries : Pobiera listę wszystkich wpisów
     * Pobiera dane za pomocą danych o paginacji. Pobieranie dostępne dla wszystkich z rolą USER
     *
     * @param portfolioRequestData  (required)
     * @return Wszystkie wpisy wraz z danymi paginacyjnymi (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     */
    @Operation(
        operationId = "getPortfolioEntries",
        summary = "Pobiera listę wszystkich wpisów",
        responses = {
            @ApiResponse(responseCode = "200", description = "Wszystkie wpisy wraz z danymi paginacyjnymi", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GetPortfolioEntries200Response.class))
            }),
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
        value = "/portfolio/entries",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<GetPortfolioEntries200Response> getPortfolioEntries(
        @Parameter(name = "PortfolioRequestData", description = "", required = true) @Valid @RequestBody PortfolioRequestData portfolioRequestData
    ) {
        return getDelegate().getPortfolioEntries(portfolioRequestData);
    }


    /**
     * POST /portfolio/entry : Modyfikuje wpis portfoliowy
     * Modyfikacja wpisu dostępna dla roli Admin. Ustawia się data modyfikacji i stworzenia
     *
     * @param portfolioRequestData  (required)
     * @return Zmodyfikowano wpis (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     */
    @Operation(
        operationId = "savePortfolioEntry",
        summary = "Modyfikuje wpis portfoliowy",
        responses = {
            @ApiResponse(responseCode = "201", description = "Zmodyfikowano wpis"),
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
        value = "/portfolio/entry",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> savePortfolioEntry(
        @Parameter(name = "PortfolioRequestData", description = "", required = true) @Valid @RequestBody PortfolioRequestData portfolioRequestData
    ) {
        return getDelegate().savePortfolioEntry(portfolioRequestData);
    }


    /**
     * POST /portfolio/entry/uploadFile : Modyfikuje wpis portfolio pod kątem dodania media
     * Modyfikacja wpisu dostępna dla roli Admin. Ustawia się data modyfikacji i stworzenia
     *
     * @param entryId  (required)
     * @param name  (optional)
     * @param type  (optional)
     * @param extensionType  (optional)
     * @param fileByteString  (optional)
     * @return Zmodyfikowano wpis (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     */
    @Operation(
        operationId = "uploadFileToPortfolio",
        summary = "Modyfikuje wpis portfolio pod kątem dodania media",
        responses = {
            @ApiResponse(responseCode = "201", description = "Zmodyfikowano wpis"),
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
        value = "/portfolio/entry/uploadFile",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    default ResponseEntity<Void> uploadFileToPortfolio(
        @NotNull @Parameter(name = "entryId", description = "", required = true) @Valid @RequestParam(value = "entryId", required = true) Long entryId,
        @Parameter(name = "name", description = "") @Valid @RequestParam(value = "name", required = false) String name,
        @Parameter(name = "type", description = "") @Valid @RequestParam(value = "type", required = false) String type,
        @Parameter(name = "extensionType", description = "") @Valid @RequestParam(value = "extensionType", required = false) String extensionType,
        @Parameter(name = "fileByteString", description = "") @RequestPart(value = "fileByteString", required = false) MultipartFile fileByteString
    ) {
        return getDelegate().uploadFileToPortfolio(entryId, name, type, extensionType, fileByteString);
    }

}
