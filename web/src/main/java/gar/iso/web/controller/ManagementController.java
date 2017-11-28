package gar.iso.web.controller;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dao.ProductDao;
import gar.iso.core.dto.Category;
import gar.iso.core.dto.Product;
import gar.iso.web.util.FileUploadUtility;
import gar.iso.web.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

    private static final Logger log = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Manage Products");
        mv.addObject("userClickedManageProducts", true);

        Product nProduct = new Product();
        nProduct.setProductSupplierId(1);
        nProduct.setActive(true);
        mv.addObject("product", nProduct);
        if (operation != null) {
            if (operation.equals("add_product")) {
                mv.addObject("message", "Product is successfully added.");
            } else if (operation.equals("update_product")) {
                mv.addObject("message", "Product is successfully updated.");
            } else if (operation.equals("add_category")) {
                mv.addObject("message", "Category is successfully added.");
            }
        }
        return mv;
    }

    //    handle adding product
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
                                          BindingResult results, Model model, HttpServletRequest request) {
        String operation = null;

        if (mProduct.getProductId() == 0) {
            new ProductValidator().validate(mProduct, results);
        } else {
            if (!mProduct.getFile().getOriginalFilename().equals("")) {
                new ProductValidator().validate(mProduct, results);
            }
        }

//        checks if there are any errors
        if (results.hasErrors()) {
            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClickedManageProducts", true);
            model.addAttribute("message", "Validation is failed for adding product");
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

        if (!mProduct.getFile().getOriginalFilename().equals("")) {
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }

        return "redirect:/manage/products?operation=" + operation;
    }

    //    handle activating or deactivating product
    @RequestMapping(value = "/product/{productId}/activation", method = RequestMethod.POST)
    @ResponseBody
    public String handleProductActivation(@PathVariable int productId) {
        Product product = productDao.getProductById(productId);
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
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Manage Products");
        mv.addObject("userClickedManageProducts", true);
        Product nProduct = productDao.getProductById(productId);
        mv.addObject("product", nProduct);
        return mv;
    }

    //    handle category submission
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String handleCategorySubmission(@ModelAttribute Category nCategory) {
        String operation = null;

        log.info(nCategory.toString());
        operation = "add_category";

        categoryDao.addCategory(nCategory);
        return "redirect:/manage/products?operation=" + operation;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDao.getCategoryList();
    }

    @ModelAttribute("category")
    public Category getCategory() {
        return new Category();
    }

}
