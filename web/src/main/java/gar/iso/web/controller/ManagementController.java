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

    private static final Logger log = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Manage Products");
        mv.addObject("userClickedManageProducts", true);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByEmail(auth.getName());

        Product nProduct = new Product();
        nProduct.setProductUser(user);
        nProduct.setActive(true);
        mv.addObject("product", nProduct);
        if (operation != null) {
            if (operation.equals("add_product")) {
                mv.addObject("successMessage", "Product is successfully added.");
            } else if (operation.equals("update_product")) {
                mv.addObject("successMessage", "Product is successfully updated.");
            } else if (operation.equals("add_category")) {
                mv.addObject("successMessage", "Category is successfully added.");
            } else if (operation.equals("category_add_failure")) {
                mv.addObject("errorMessage", "Failed to add category.");
            }
        }
        return mv;
    }

    //    handle adding product
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
                                          BindingResult results, Model model, HttpServletRequest request) {
        String operation;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByEmail(auth.getName());
        mProduct.setProductUser(user);
        if (mProduct.getProductId() == 0) {
            new ProductValidator().validate(mProduct, results);
        } else {
            if (!mProduct.getFile().getOriginalFilename().equals("")) {
                new ProductValidator().validate(mProduct, results);
            }
        }
//        ProductType productType = new ProductType();
//        productType.setProductTypeName(mProduct.getProductNameEn());
//        mProduct.setProductType(productType);
//
//        if (language.getKey() == 2){
//            mProduct.setProductName(mProduct.getProductNameRu());
//            mProduct.setProductLangId(language.getKey());
//        } else {
//            mProduct.setProductName(mProduct.getProductNameEn());
//            mProduct.setProductLangId(1);
//        }

//        checks if there are any errors
        if (results.hasErrors()) {
            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClickedManageProducts", true);
            model.addAttribute("errorMessage", "Validation is failed for adding product");
            return "page";
        }

        log.info(mProduct.toString());
        if (mProduct.getProductId() == 0) {
//            creating new product, which id is not set yet
            productDao.addProduct(mProduct);
            operation = "add_product";
        } else {
//            updating product, whi already has an id
            productDao.updateProduct(mProduct);
            operation = "update_product";
        }
//        if (mProduct.getProductType().getProductTypeId() == 0) {
////            creating new product , which id is not set yet
//            productDao.addProductType(productType);
//            productDao.addProduct(mProduct);
//            operation = "add_product";
//        } else {
////            updating product, whi already has an id
//            productDao.updateProduct(mProduct);
//            operation = "update_product";
//        }

        if (!mProduct.getFile().getOriginalFilename().equals("")) {
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }

        return "redirect:/manage/products?operation=" + operation;
    }

    //    handle activating or deactivating product
    @RequestMapping(value = "/product/{productId}/activation", method = RequestMethod.POST)
//    @RequestMapping(value = "/product/{productTypeId}/activation", method = RequestMethod.POST)
    @ResponseBody
    public String handleProductActivation(@PathVariable int productId) {
            Product product = productDao.getProductById(productId);
//        public String handleProductActivation(@PathVariable int productTypeId) {
//            Product product = productDao.getProductById(productTypeId, language.getKey());
        boolean isProductActive = product.isActive();
        product.setActive(!product.isActive());
        productDao.updateProduct(product);

        String message = (isProductActive) ? "You have successfully deactivated '" + product.getProductName() + "'" :
                "You have successfully activated '" + product.getProductName() + "'";

        return message;
    }

    //    handle changing product details
    @RequestMapping(value = "/{productId}/product", method = RequestMethod.GET)
    public ModelAndView showEditProduct(@PathVariable int productId) {
//        @RequestMapping(value = "/{productTypeId}/product", method = RequestMethod.GET)
//        public ModelAndView showEditProduct(@PathVariable int productTypeId) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Manage Products");
        mv.addObject("userClickedManageProducts", true);
        Product nProduct = productDao.getProductById(productId);
//        Product nProduct = productDao.getProductById(productTypeId, language.getKey());
        mv.addObject("product", nProduct);
        return mv;
    }

    //    handle category submission
    @RequestMapping(value = "/category", method = RequestMethod.POST/*, consumes = "text/plain;charset=UTF-8"*/)
    public String handleCategorySubmission(@ModelAttribute Category nCategory) {
        String operation;

        CategoryType categoryType = new CategoryType();
        categoryType.setCategoryTypeName(nCategory.getCategoryNameEn());

        nCategory.setCategoryType(categoryType);

        if (language.getKey() == 2) {
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
