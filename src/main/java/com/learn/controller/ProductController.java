package com.learn.controller;

import com.learn.entity.Product;
import com.learn.service.ProductService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("rest/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping(value = "/addProducts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        log.trace("Get All Products Called");
        return service.getAllProducts();
    }

    @GetMapping("/id/{id}")
    @ApiOperation(value="Fetch product by Product ID", notes="Provide an id to look up for a product", response = Product.class
    , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,tags = {"Search Product"})
    public Product getProductById(@PathVariable int id) {
        log.debug("Get Product by ID Called");
        return service.getProductById(id);
    }

    @RequestMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "Product not found") })
    @ApiOperation(value="Fetch product by Product Name", notes="Provide a name to look up for a product", response = Product.class
            , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,tags = {"Search Product"})
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name.trim());
    }

    @PutMapping("/update")
    @ApiOperation(value="Update product by Product info", notes="Provide product ID and new values to be updated", response = Product.class
            , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,tags = {"Update Product"})
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Delete Product by ID",notes = "Delete product by ID")
    public String deleteProductById(@ApiParam(value = "Product ID for the product you want to delete", required = true)
            @PathVariable int id) {
        return service.deleteProduct(id);
    }
}
