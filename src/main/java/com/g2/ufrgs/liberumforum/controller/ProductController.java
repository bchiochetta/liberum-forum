package com.g2.ufrgs.liberumforum.controller;

import com.g2.ufrgs.liberumforum.model.Product;
import com.g2.ufrgs.liberumforum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity(productList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return new ResponseEntity(productRepository.findById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/search/{searchParam}")
    public ResponseEntity<List<Product>> getProductsBySearchParam(@PathVariable String searchParam){
        List<Product> productList = productRepository.findByNameContaining(searchParam);
        return new ResponseEntity(productList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity(product, HttpStatus.OK);
    }
}
