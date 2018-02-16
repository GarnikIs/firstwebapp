package gar.iso.web.controller;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dao.ProductDao;
import gar.iso.core.dao.UserDao;
import gar.iso.core.dto.*;
import gar.iso.web.util.FileUploadUtility;
import gar.iso.web.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static gar.iso.web.controller.GlobalController.language;

/**
 * Created by Gor on 11/25/2017.
 */
@Controller
@RequestMapping("/manage")
public class ManagementController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageSource messageSource;

    private static final Logger log = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
        int langKey = (language.getKey() == 2) ? 2 : 1;
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", messageSource.getMessage("navbar.title.manage.products", null, language.setLocale(langKey)));
        mv.addObject("userClickedManageProducts", true);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByEmail(auth.getName());

        Product nProduct = new Product();
        nProduct.setProductUser(user);
        nProduct.setActive(true);
        mv.addObject("product", nProduct);
        if (operation != null) {
            if (operation.equals("add_product")) {
                mv.addObject("successMessage", messageSource.getMessage("success.product.add",
                        new String[]{nProduct.getProductName()}, language.setLocale(langKey)));
            } else if (operation.equals("update_product")) {
                mv.addObject("successMessage", messageSource.getMessage("success.product.update",
                        new String[]{nProduct.getProductName()}, language.setLocale(langKey)));
            } else if (operation.equals("add_category")) {
                mv.addObject("successMessage", messageSource.getMessage("success.category.add",
                        null, language.setLocale(langKey)));
            } else if (operation.equals("category_add_failure")) {
                mv.addObject("errorMessage", messageSource.getMessage("failure.category.add",
                        null, language.setLocale(langKey)));
            }
        }
        return mv;
    }

    //    handle adding product
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
                                              BindingResult results, Model model, HttpServletRequest request) {
        String operation;
        ProductType productType;
        int langKey = (language.getKey() == 2) ? 2 : 1;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByEmail(auth.getName());
        mProduct.setProductUser(user);
        if (mProduct.getProductType().getProductTypeId() == 0) {
            new ProductValidator().validate(mProduct, results);
        } else {
            if (!mProduct.getFile().getOriginalFilename().equals("")) {
                new ProductValidator().validate(mProduct, results);
            }
        }

//        checks if there are any errors
        if (results.hasErrors()) {
            model.addAttribute("title", messageSource.getMessage("navbar.title.manage.products", null, language.setLocale(langKey)));
            model.addAttribute("userClickedManageProducts", true);
            model.addAttribute("errorMessage", messageSource.getMessage("failure.validation.product.add",
                    null, language.setLocale(langKey)));
            return "page";
        }

        if (language.getKey() == 2) {
            mProduct.setProductName(mProduct.getProductNameRu());
            mProduct.setProductDescription(mProduct.getProductDescriptionRu());
            mProduct.setProductLangId(language.getKey());
        } else {
            mProduct.setProductName(mProduct.getProductNameEn());
            mProduct.setProductDescription(mProduct.getProductDescriptionEn());
            mProduct.setProductLangId(1);
        }

        log.info(mProduct.toString());
        if (mProduct.getProductType().getProductTypeId() == 0) {
//            creating new product, which id is not set yet
            productType = new ProductType();
            productType.setProductTypeName(mProduct.getProductNameEn());
            mProduct.setProductType(productType);
            if (productDao.addProductType(productType) && productDao.addProduct(mProduct)) {
                operation = "add_product";
            } else {
                operation = "product_add_failure";
            }
        } else {
//            updating product, which already has an id
            if (productDao.updateProduct(mProduct)) {
                operation = "update_product";
            } else {
                operation = "product_update_failure";
            }
        }
        if (!mProduct.getFile().getOriginalFilename().equals("")) {
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }

        return "redirect:/manage/products?operation=" + operation;
    }

    //    handle activating or deactivating product
    @RequestMapping(value = "/product/{productId}/activation", method = RequestMethod.POST,
                                                    produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String handleProductActivation(@PathVariable int productId) {
        int langKey = (language.getKey() == 2) ? 2 : 1;
        Product product = productDao.getProductById(productId, langKey);
        boolean isProductActive = product.isActive();
        product.setActive(!product.isActive());
        productDao.updateProduct(product);
        String message;

        if (product.isActive()) {
            message = messageSource.getMessage("activate.product.success", new String[]{product.getProductName()}, language.setLocale(langKey));

        } else {
            message = messageSource.getMessage("deactivate.product.success", new String[]{product.getProductName()},language.setLocale(langKey));
        }

        return message;
    }

    //    handle changing product details
    @RequestMapping(value = "/{productId}/product", method = RequestMethod.GET)
    public ModelAndView showEditProduct(@PathVariable int productId) {
        int langKey = (language.getKey() == 2) ? 2 : 1;
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", messageSource.getMessage("navbar.title.manage.products", null, language.setLocale(langKey)));
        mv.addObject("userClickedManageProducts", true);
        Product nProduct = productDao.getProductById(productId, langKey);
        mv.addObject("product", nProduct);
        return mv;
    }

    //    handle category submission
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String handleCategorySubmission(@ModelAttribute Category nCategory) {
        String operation;

        int langKey = language.getKey() == 2 ? 2 :1;

        CategoryType categoryType = new CategoryType();
        categoryType.setCategoryTypeName(nCategory.getCategoryNameEn());

        nCategory.setCategoryType(categoryType);

        if (langKey == 2) {
            nCategory.setCategoryName(nCategory.getCategoryNameRu());
            nCategory.setCategoryLangId(language.getKey());
        } else {
            nCategory.setCategoryName(nCategory.getCategoryNameEn());
            nCategory.setCategoryLangId(1);
        }

        log.info(nCategory.toString());

        if (categoryDao.addCategoryType(nCategory.getCategoryType()) && categoryDao.addCategory(nCategory)) {
            operation = "add_category";
        } else {
            operation = "category_add_failure";
        }

        return "redirect:/manage/products?operation=" + operation;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDao.getCategoryList(language.getKey());
    }

    @ModelAttribute("category")
    public Category getCategory() {
        return new Category();
    }

}
