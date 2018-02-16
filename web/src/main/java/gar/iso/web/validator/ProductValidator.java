package gar.iso.web.validator;

import gar.iso.core.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static gar.iso.web.controller.GlobalController.language;

/**
 * Created by Gor on 11/26/2017.
 */
public class ProductValidator implements Validator {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        int langKey = language.getKey() == 2 ? 2 : 1;

        if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
            errors.rejectValue("file", null, messageSource.getMessage("error.message.blank.image", null, language.setLocale(langKey)));
            return;
        }

        if ( !(product.getFile().getContentType().equals("image/jpeg") ||
               product.getFile().getContentType().equals("image/png") ||
               product.getFile().getContentType().equals("image/gif")) ) {
            errors.rejectValue("file", null, messageSource.getMessage("error.message.invalid.image", null, language.setLocale(langKey)));
        }
    }
}
