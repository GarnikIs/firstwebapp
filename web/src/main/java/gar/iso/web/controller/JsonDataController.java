package gar.iso.web.controller;

import gar.iso.core.dao.ProductDao;
import gar.iso.core.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static gar.iso.web.controller.GlobalController.language;

/**
 * Created by Gor on 11/20/2017.
 */
@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    private ProductDao productDao;

    private static int langKey;

    @RequestMapping(value = "/all/products")
    @ResponseBody
    public List<Product> getActiveProductList(){
        if (language.getKey() == 2) {
            langKey = 2;
        } else {
            langKey = 1;
        }
        return productDao.getActiveProductList(langKey);
    }

    @RequestMapping(value = "/admin/all/products")
    @ResponseBody
    public List<Product> getActiveProductListForAdmin(){
        if (language.getKey() == 2) {
            langKey = 2;
        } else {
            langKey = 1;
        }
        return productDao.getAllProductList(langKey);
    }

    @RequestMapping(value = "/category/{categoryId}/products")
    @ResponseBody
    public List<Product> getActiveProductListByCategoryId(@PathVariable("categoryId") int categoryId){
        List<Product> products = productDao.getActiveProductListByCategoryId(categoryId);
        return products;
    }


}
