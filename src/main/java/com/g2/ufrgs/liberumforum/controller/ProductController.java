package com.g2.ufrgs.liberumforum.controller;

import com.g2.ufrgs.liberumforum.model.Product;
import com.g2.ufrgs.liberumforum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Long id){
        return new ResponseEntity(productRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity(productList, HttpStatus.OK);
    }

    @GetMapping(path = "/name")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam(name="name") String searchParam){
        List<Product> productList = productRepository.findByNameContaining(searchParam);
        return new ResponseEntity(productList, HttpStatus.OK);
    }
}
