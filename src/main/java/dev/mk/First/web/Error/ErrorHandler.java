package dev.mk.First.web.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private HttpServletRequest mHttpServletRequest;

    private ResponseEntity<Object> convertToResponse(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.httpStatus);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exceptionHandle(Exception ex) {
        ApiError apiError = ApiError.builder()
                .setHttpStatus(HttpStatus.BAD_REQUEST).build();

        return convertToResponse(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request
    ) {
        List<ApiSubError> apiSubErrors = ex.getFieldErrors().stream().map(
                i -> new ApiSubError(
                        "Type valid value",
                        "Not valid value" + i.getRejectedValue() + "-" + i.getDefaultMessage()
                )
        ).collect(Collectors.toList());

        ApiError apiError = ApiError.builder()
                .setErrorMessage("Correct invalid values")
                .setDefaultAction("Check sub errors")
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setApiSubErrors(apiSubErrors)
                .build();
        return convertToResponse(apiError);
    }
}
