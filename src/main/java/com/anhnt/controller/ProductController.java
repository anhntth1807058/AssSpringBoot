package com.anhnt.controller;

import com.anhnt.entity.Product;
import com.anhnt.repository.ProductRepository;
import com.anhnt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String getAllProduct(Model model) {
        model.addAttribute("products", productService.getAll());
        return "listProduct";
    }

    @GetMapping("/addProduct")
    public String showAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        return Optional.ofNullable(productService.create(product))
                .map(t -> "success")
                .orElse("failed");
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<Product> product = productRepository.findById(id);

        model.addAttribute("product", product);
        return "update";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")
    public String updateProduct(@RequestBody Product product, Model model) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()) {
            Product existProduct = optionalProduct.get();
            existProduct.setName(product.getName());
            existProduct.setPrice(product.getPrice());
            existProduct.setCategoryid(product.getCategoryid());
            productRepository.save(existProduct);
        }
        productService.update(product);
        model.addAttribute("product", productRepository.findAll());
        return "redirect:/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        productRepository.delete(product);
        model.addAttribute("product", productRepository.findAll());
        return "listProduct";
    }
}
