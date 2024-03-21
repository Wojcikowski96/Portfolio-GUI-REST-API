package com.example;

import com.example.model.BlogEntryDTO;
import com.example.model.BlogRequestData;
import com.example.model.CommentDTO;
import com.example.model.Error;
import com.example.model.GetBlogEntries200Response;
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
 * A delegate to be called by the {@link BlogApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-21T11:23:53.541498400+01:00[Europe/Warsaw]")
public interface BlogApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /blog/entry/comment : Dodaje komentarz do wpisu
     * Komentarze dodawać mogą wszyscy
     *
     * @param commentDTO  (required)
     * @return Dodano komentarz (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#commentBlogEntry
     */
    default ResponseEntity<Void> commentBlogEntry(CommentDTO commentDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /blog/entries/delete : Usuwa wpisy
     * Usuwanie dla roli administratora
     *
     * @param entryId  (required)
     * @return Usunięto (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#deleteBlogEntries
     */
    default ResponseEntity<Void> deleteBlogEntries(List<Long> entryId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /blog/entry/comment : Usuwa komentarze z wpisu
     * Usuwać może każdy, kto skomentował dany wpis
     *
     * @param commentId  (required)
     * @return Usunięto (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#deleteCommentFromEntry
     */
    default ResponseEntity<Void> deleteCommentFromEntry(List<Long> commentId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /blog/entries : Pobiera listę wszystkich wpisów
     * Pobiera dane za pomocą danych o paginacji. Pobieranie dostępne dla wszystkich z rolą USER
     *
     * @param blogRequestData  (required)
     * @return Wszystkie wpisy wraz z danymi paginacyjnymi (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#getBlogEntries
     */
    default ResponseEntity<GetBlogEntries200Response> getBlogEntries(BlogRequestData blogRequestData) {
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
     * GET /blog/entry : Pobiera wpis bloga dla danego id
     *
     * @param entryId  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#getBlogEntry
     */
    default ResponseEntity<BlogEntryDTO> getBlogEntry(Long entryId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"modificationDate\" : \"modificationDate\", \"imageUrl\" : \"imageUrl\", \"id\" : 0, \"newsPortalsUrls\" : [ \"newsPortalsUrls\", \"newsPortalsUrls\" ], \"creationDate\" : \"creationDate\", \"tittle\" : \"tittle\", \"content\" : \"content\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /blog/file : Pobiera obrazek dla konkretnego wpisu
     * Operacja dostępna dla wszystkich
     *
     * @param entryId  (required)
     * @return obraz (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#getImage
     */
    default ResponseEntity<org.springframework.core.io.Resource> getImage(Long entryId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /blog/entry : Modyfikuje wpis bloga
     * Modyfikacja wpisu dostępna dla roli Admin. Ustawia się data modyfikacji i stworzenia
     *
     * @param blogEntryDTO  (required)
     * @return Zmodyfikowano wpis (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#saveBlogEntry
     */
    default ResponseEntity<Void> saveBlogEntry(BlogEntryDTO blogEntryDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /blog/entry/uploadImage : Modyfikuje wpis bloga pod kątem dodania obrazka
     * Modyfikacja wpisu dostępna dla roli Admin. Ustawia się data modyfikacji i stworzenia
     *
     * @param entryId  (required)
     * @param name  (optional)
     * @param type  (optional)
     * @param fileByteString  (optional)
     * @return Zmodyfikowano wpis (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     * @see BlogApi#uploadImageBlog
     */
    default ResponseEntity<Void> uploadImageBlog(Long entryId,
        String name,
        String type,
        MultipartFile fileByteString) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
