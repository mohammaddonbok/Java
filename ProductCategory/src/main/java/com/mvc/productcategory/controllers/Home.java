package com.mvc.productcategory.controllers;

import com.mvc.productcategory.models.Category;
import com.mvc.productcategory.models.CategoryProduct;
import com.mvc.productcategory.models.Product;
import com.mvc.productcategory.services.ProCatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class Home {
    private final ProCatService proCatServ;

    public Home(ProCatService proCatServ) {

        this.proCatServ = proCatServ;
    }

    @RequestMapping("/products/new")
    public String shows(@ModelAttribute("prod") Product prod) {
        return "newProduct.jsp";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("prod") Product prod) {
        // Code
        Product p = proCatServ.creatProduct(prod);
        return "redirect:/products/new";
    }

    @RequestMapping("/show/pro")
    public List<Product> getAllProducts() {
        return proCatServ.allProducts();
    }

//    @RequestMapping("/show/cat")
//    public List<Category> getAllCategories() {
//        return proCatServ.allCategories();
//    }
//
//    @RequestMapping(value = "/create/cat", method = RequestMethod.POST)
//    public List<Category> createNewCat(@RequestParam("name") String name) {
//        Category cat = proCatServ.createCategory(new Category(name));
//        return proCatServ.allCategories();
//    }

    @RequestMapping("/products")
    public String showProducts(@ModelAttribute("prod") Product prod, Model model) {
        List<Product> products = proCatServ.allProducts();
        model.addAttribute("products", products);
        return "newProduct.jsp";
    }

    @RequestMapping("/categories/new")
    public String showcategory(@ModelAttribute("categories") Category cat) {
        return "newCategory.jsp";
    }

    @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
    public String CreateCategories(@ModelAttribute("categories") Category cat) {
        proCatServ.createCategory(cat);
        return "redirect:/categories/new";
    }

    @RequestMapping("/products/{id}")
    public String showProCat(@PathVariable("id") Long proId, @ModelAttribute("categoryProductObj") CategoryProduct catPro, Model model) {
        Product p = proCatServ.getProduct(proId);
        model.addAttribute("product", p);

        List<Category> catAssociate = proCatServ.categoriesAssociated(p);
        model.addAttribute("categoriesAdded", catAssociate);

        List<Category> cn = proCatServ.categoriesNotAssociated(p);
        model.addAttribute("categoriesNotAdded", cn);

        return "showProduct.jsp";
        //Category categoryAdded=proCatServ.CategoryNotAdded();
    }

    @RequestMapping(value = "/associate/{proId}", method = RequestMethod.POST)
    public String associateCategory(@PathVariable("proId") Product proId, @ModelAttribute("categoryProductObj") CategoryProduct catPro) {

        proCatServ.createAssociation(catPro);
        return "redirect:/products/{proId}";
    }

    /////////////////////////////////////////////////////////
    @RequestMapping("/category/{id}")
    public String showCatPro(@PathVariable("id") Long catId,@ModelAttribute("categoryProductObj") CategoryProduct catPro, Model model) {
        Category c =proCatServ.getCategory(catId);
        model.addAttribute("category",c);
        List<Product> productsAssociated =proCatServ.productAssociate(c);
        model.addAttribute("contain",productsAssociated);
        List<Product> pn =proCatServ.productNotAssociate(c);
        model.addAttribute("notContain",pn);
        return "showCategory.jsp";
    }
    @RequestMapping(value = "/assProduct/{catId}", method = RequestMethod.POST)
    public String associateProduct(@PathVariable("catId") Product catId, @ModelAttribute("categoryProductObj") CategoryProduct catPro) {

        proCatServ.addProdToCategory(catPro);
        return "redirect:/category/{catId}";
    }
}