package gar.iso.web.validator;

import gar.iso.core.dto.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Gor on 11/26/2017.
 */
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
            errors.rejectValue("file", null, "Please select an image file to upload");
            return;
        }

        if ( !(product.getFile().getContentType().equals("image/jpeg") ||
               product.getFile().getContentType().equals("image/png") ||
               product.getFile().getContentType().equals("image/gif")) ) {
            errors.rejectValue("file", null, "Please select only image files to upload");
        }
    }
}
