package gar.iso.web.controller;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dao.ProductDao;
import gar.iso.core.dto.Category;
import gar.iso.core.dto.Product;
import gar.iso.web.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gor on 11/17/2017.
 */
@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");

        log.info("Inside page controller index method - INFO");
        log.debug("Inside page controller index method - DEBUG");

//        passing category list from core
        mv.addObject("categories", categoryDao.getCategoryList());

        mv.addObject("userClickedHome", true);
        return mv;
    }

    @RequestMapping (value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","About Us");
        mv.addObject("userClickedAbout", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact");
        mv.addObject("userClickedContact", true);
        return mv;
    }

//    methods to load all the products based on category
    @RequestMapping (value = "/show/all/products")
    public ModelAndView listOfProducts() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "All Products");

        //        passing category list from core
        mv.addObject("categories", categoryDao.getCategoryList());

        mv.addObject("userClickedAllProducts", true);
        return mv;
    }

    @RequestMapping (value = "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("page");

//        categoryDao to fetch a single category
        Category category = null;
        category = categoryDao.getCategoryById(id);

        mv.addObject("title", category.getCategoryName());

//        passing category list from core
        mv.addObject("categories", categoryDao.getCategoryList());
//        passing the single category
        mv.addObject("category", category);

        mv.addObject("userClickedCategoryProducts", true);
        return mv;
    }

    /**
     * Getting a single product
     * @param productId
     * @return product
     */
    @RequestMapping(value = "/product/{productId}/details")
    public ModelAndView getProductDetailById(@PathVariable("productId") int productId) throws ProductNotFoundException {
        ModelAndView mv = new ModelAndView("page");
        Product product = productDao.getProductById(productId);

        if (product == null) {
            throw new ProductNotFoundException();
        }

//        updating product views after it is viewed one more time
        product.setViews(product.getViews() + 1);
        productDao.updateProduct(product);
//        retrieving product for view
        mv.addObject("title", product.getProductName());
        mv.addObject("product", product);
        mv.addObject("userClickedProductDetails", true);
        return mv;
    }

//    Request Mapping for login page
    @RequestMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("title", "Contact");
        return mv;
    }

}