package gar.iso.web.controller;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dto.Category;
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

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");

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

        mv.addObject("title", category.getName());

//        passing category list from core
        mv.addObject("categories", categoryDao.getCategoryList());
//        passing the single category
        mv.addObject("category", category);

        mv.addObject("userClickedCategoryProducts", true);
        return mv;
    }
}