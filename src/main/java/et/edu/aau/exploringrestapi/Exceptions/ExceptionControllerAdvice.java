package et.edu.aau.exploringrestapi.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetail> handleNotEnoughMoneyException() {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setMessage("Not enough money");
        return ResponseEntity
                .badRequest()
                .body(errorDetail);
    }

}
