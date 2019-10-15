package gar.iso.core.exception;

public class ListException extends RuntimeException {

    private String errorCode;

    private String message;

    public ListException() {
        super();
    }

    public ListException(final String errorCode) {
        this.errorCode = errorCode;
    }

    public ListException(final String errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
