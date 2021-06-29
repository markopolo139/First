package dev.mk.First.web.error;

import org.springframework.http.HttpStatus;

import java.util.Collection;

public class ApiError {

    public static final String DEFAULT_ACTION = "TRY AGAIN LATER";

    public static final String DEFAULT_ERROR = "TRY AGAIN LATER";

    public String defaultAction = DEFAULT_ACTION;

    public String errorMessage = DEFAULT_ERROR;

    public HttpStatus httpStatus;

    public Collection<ApiSubError> apiSubErrors;

    public static Builder builder(){
        return new Builder();
    }

    public ApiError(
            String defaultAction, String errorMessage, HttpStatus httpStatus, Collection<ApiSubError> apiSubErrors
    ) {
        this.defaultAction = defaultAction;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.apiSubErrors = apiSubErrors;
    }

    private ApiError() {
    }

    public static class Builder {
        private ApiError mApiError = new ApiError();

        public Builder setDefaultAction(String defaultAction) {
            mApiError.defaultAction = defaultAction;
            return this;
        }

        public Builder setErrorMessage(String errorMessage) {
            mApiError.errorMessage = errorMessage;
            return this;
        }

        public Builder setHttpStatus(HttpStatus httpStatus) {
            mApiError.httpStatus = httpStatus;
            return this;
        }

        public Builder setApiSubErrors(Collection<ApiSubError> apiSubErrors) {
            mApiError.apiSubErrors = apiSubErrors;
            return this;
        }

        public ApiError build() {
            return mApiError;
        }
    }

}
