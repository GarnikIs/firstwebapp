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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView showManageProducts(@RequestParam(name = "operation", required=false) String operation){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Manage Products");
        mv.addObject("userClickedManageProducts", true);

        Product nProduct = new Product();
        nProduct.setProductSupplierId(1);
        nProduct.setActive(true);
        mv.addObject("product", nProduct);
        if (operation != null) {
            if (operation.equals("product")) {
                mv.addObject("message", "Product is successfully added.");
            }
        }
        return mv;
    }

//    handling managing adding product
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
                                          BindingResult results, Model model, HttpServletRequest request){

        new ProductValidator().validate(mProduct, results);

//        checks if there are any errors
        if (results.hasErrors()) {
            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClickedManageProducts", true);
            model.addAttribute("message", "Validation is failed for product adding");
            return "page";
        }

        log.info(mProduct.toString());
        productDao.addProduct(mProduct);

        if (!mProduct.getFile().getOriginalFilename().equals("")) {
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }

        return "redirect:/manage/products?operation=product";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDao.getCategoryList();
    }

}
