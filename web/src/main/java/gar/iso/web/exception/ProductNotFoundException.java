package gar.iso.web.exception;

import java.io.Serializable;

/**
 * Created by Gor on 11/25/2017.
 */
public class ProductNotFoundException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public ProductNotFoundException() {
        this("Product is not available");
    }

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }

    public String getMessage(){
        return message;
    }

}
