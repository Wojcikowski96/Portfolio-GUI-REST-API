package com.example;

import com.example.model.Error;
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
 * A delegate to be called by the {@link DefaultApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T13:06:48.951468800+01:00[Europe/Warsaw]")
public interface DefaultApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /
     *
     * @return Successful operation (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     *         or Unexpected error (status code 200)
     * @see DefaultApi#rootDelete
     */
    default ResponseEntity<Void> rootDelete() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /
     *
     * @return Successful operation (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     *         or Unexpected error (status code 200)
     * @see DefaultApi#rootGet
     */
    default ResponseEntity<Void> rootGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /
     *
     * @return Successful operation (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     *         or Unexpected error (status code 200)
     * @see DefaultApi#rootPost
     */
    default ResponseEntity<Void> rootPost() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /
     *
     * @return Successful operation (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or The specified resource was not found (status code 404)
     *         or Unexpected error (status code 200)
     * @see DefaultApi#rootPut
     */
    default ResponseEntity<Void> rootPut() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
