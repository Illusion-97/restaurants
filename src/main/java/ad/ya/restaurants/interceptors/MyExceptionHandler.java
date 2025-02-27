package ad.ya.restaurants.interceptors;

import ad.ya.restaurants.exception.MethodNotAllowedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Apporte des comportements supplémentaires à la GESTION des contrôleurs
@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    //@ExceptionHandler({MethodNotAllowedException.class})
    public ResponseEntity<Object> handleMethodNotAllowed(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED,request);
    }


   // @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);
    }
}
