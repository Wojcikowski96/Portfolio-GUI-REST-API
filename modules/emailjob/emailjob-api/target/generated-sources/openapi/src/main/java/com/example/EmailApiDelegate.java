package com.example;

import com.example.model.EmailDTO;
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
 * A delegate to be called by the {@link EmailApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-25T13:07:50.940833200+01:00[Europe/Warsaw]")
public interface EmailApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
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
     * @see EmailApi#sendMessage
     */
    default ResponseEntity<Void> sendMessage(EmailDTO emailDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
