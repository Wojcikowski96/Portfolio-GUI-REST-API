package com.example;

import com.example.model.Error;
import com.example.model.GetPortfolioEntries200Response;
import com.example.model.PortfolioRequestData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link PortfolioApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T13:23:39.080943500+01:00[Europe/Warsaw]")
public interface PortfolioApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
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
     * @see PortfolioApi#deleteFile
     */
    default ResponseEntity<Void> deleteFile(Long imageId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see PortfolioApi#deletePortfolioEntries
     */
    default ResponseEntity<Void> deletePortfolioEntries(List<Long> entryId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see PortfolioApi#getImageOrPdfForPortfolioDetails
     */
    default ResponseEntity<org.springframework.core.io.Resource> getImageOrPdfForPortfolioDetails(Long entryId,
        String fileName) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see PortfolioApi#getPortfolioEntries
     */
    default ResponseEntity<GetPortfolioEntries200Response> getPortfolioEntries(PortfolioRequestData portfolioRequestData) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see PortfolioApi#savePortfolioEntry
     */
    default ResponseEntity<Void> savePortfolioEntry(PortfolioRequestData portfolioRequestData) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see PortfolioApi#uploadFileToPortfolio
     */
    default ResponseEntity<Void> uploadFileToPortfolio(Long entryId,
        String name,
        String type,
        String extensionType,
        MultipartFile fileByteString) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
