package gar.iso.web.controller;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dao.ProductDao;
import gar.iso.core.dto.Category;
import gar.iso.core.dto.Product;
import gar.iso.web.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static gar.iso.web.controller.GlobalController.language;

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

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        int langKey = language.getKey() == 3 ? 3 : 1;
        List<Product> products = productDao.getActiveProductList(langKey);
        mv.addObject("title", messageSource.getMessage("navbar.title.home", null, language.setLocale(langKey)));

        log.info("Inside page controller index method - INFO");
        log.debug("Inside page controller index method - DEBUG");

//        passing category list from core
        mv.addObject("categories", categoryDao.getCategoryList(language.getKey()));
        mv.addObject("products", products);

        mv.addObject("userClickedHome", true);
        return mv;
    }

    @RequestMapping (value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        int langKey = language.getKey() == 3 ? 3 : 1;
        mv.addObject("title",messageSource.getMessage("navbar.title.about", null, language.setLocale(langKey)));
        mv.addObject("userClickedAbout", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        int langKey = language.getKey() == 3 ? 3 : 1;
        mv.addObject("title", messageSource.getMessage("navbar.title.contacts", null, language.setLocale(langKey)));
        mv.addObject("userClickedContact", true);
        return mv;
    }

    //    methods to load all the products based on category
    @RequestMapping(value = "/show/all/products")
    public ModelAndView listOfProducts() {
        ModelAndView mv = new ModelAndView("page");
        int langKey = language.getKey() == 3 ? 3 : 1;
        mv.addObject("title", messageSource.getMessage("show.all.products", null, language.setLocale(langKey)));

        //        passing category list from core
        mv.addObject("categories", categoryDao.getCategoryList(language.getKey()));

        mv.addObject("userClickedAllProducts", true);
        return mv;
    }

    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("page");
        int langKey = language.getKey() == 3 ? 3 : 1;

//        categoryDao to fetch a single category
        Category category = null;
        category = categoryDao.getCategoryById(id, langKey);

        mv.addObject("title", category.getCategoryName());

//        passing category list from core
        mv.addObject("categories", categoryDao.getCategoryList(language.getKey()));
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
        int langKey = language.getKey() == 3 ? 3 : 1;
        Product product = productDao.getProductById(productId, langKey);

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
    public ModelAndView loginPage(@RequestParam(name = "error", required = false) String error,
                                  @RequestParam(name = "logout", required = false) String logout) {
        ModelAndView mv = new ModelAndView("login");
        int langKey = language.getKey() == 3 ? 3 : 1;

        if (error != null) {
            mv.addObject("errorMessage", messageSource.getMessage("invalid.username.password", null, language.setLocale(langKey)));
        }
        if (logout != null) {
            mv.addObject("logoutMessage", messageSource.getMessage("logout.success", null, language.setLocale(langKey)));
        }

        mv.addObject("title", messageSource.getMessage("navbar.title.login", null, language.setLocale(langKey)));
        return mv;
    }

    //    Access denying handler page
    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDenied() {
        ModelAndView mv = new ModelAndView("error");
        int langKey = language.getKey() == 3 ? 3 : 1;
        mv.addObject("title", messageSource.getMessage("no.access.title", null, language.setLocale(langKey)));
        mv.addObject("errorTitle", messageSource.getMessage("no.access.еrror.title", null, language.setLocale(langKey)));
        mv.addObject("errorDescription", messageSource.getMessage("no.access.еrror.description", null, language.setLocale(langKey)));
        return mv;
    }

    //    Logout handling
    @RequestMapping(value = "/perform-logout")
    public String performLogout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes rm) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int langKey = language.getKey() == 3 ? 3 : 1;
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            rm.addFlashAttribute("logoutMessage", messageSource.getMessage("logout.success", null, language.setLocale(langKey)));
        }

        return "redirect:login?logout&language="+language.getLocale();
    }

}