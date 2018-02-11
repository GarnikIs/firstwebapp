//package gar.iso.web.controller;
//
//import gar.iso.web.service.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * Created by Gor on 12/4/2017.
// */
//@Controller
//@RequestMapping("/cart")
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    @RequestMapping("/show")
//    public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
//        ModelAndView mv = new ModelAndView("page");
//
//        if (result != null) {
//            switch (result) {
//                case "added":
//                    mv.addObject("successMessage", "Product has been successfully added to the cart");
//                    break;
//                case "updated":
//                    mv.addObject("successMessage", "Product has been successfully updated in the cart");
//                    break;
//                case "deleted":
//                    mv.addObject("successMessage", "Product has been successfully deleted from the cart");
//                    break;
//                case "error":
//                    mv.addObject("errorMessage", "The current product was not found");
//                    break;
//            }
//        }
//        mv.addObject("title", "View Cart");
//        mv.addObject("userClickedShowCart", true);
//        mv.addObject("cartLines", cartService.getCartLineList());
//        return mv;
//    }
//
//    @RequestMapping("/add/{productId}")
//    public String addCartLineProduct(@PathVariable(name = "productId") int productId) {
//
//        String response = cartService.addCartLineProduct(productId);
//        return "redirect:/cart/show?" + response;
//    }
//
//    @RequestMapping("/{cartLineId}/update")
//    public String updateCartLineProduct(@PathVariable(name = "cartLineId") int cartLineId,
//                                        @RequestParam int productCount) {
//
//        String response = cartService.updateCartLineProduct(cartLineId, productCount);
//        return "redirect:/cart/show?" + response;
//    }
//
//    @RequestMapping("/{cartLineId}/delete")
//    public String deleteCartLineProduct(@PathVariable(name = "cartLineId") int cartLineId){
//
//        String response = cartService.deleteCartLineProduct(cartLineId);
//        return "redirect:/cart/show?" + response;
//    }
//}
