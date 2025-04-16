package com.spring.ecom_proj.controller;

import com.spring.ecom_proj.model.Product;
import com.spring.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet(){
        return " hello world";
    }

    @GetMapping ("/products")
    public ResponseEntity<List<Product>> getAllproducts(){
        System.out.println("Hello");
        return new ResponseEntity<>( service.getAllproducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Product product=service.getProductById(prodId);
        if (product!=null)
            return new ResponseEntity<>( product,HttpStatus.OK);
        else
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
       try {
           System.out.println(product);
           Product product1 = service.addProduct(product, imageFile);
           return new ResponseEntity<>(product1, HttpStatus.CREATED);
       }
       catch(Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product=service.getProductById(productId);
        byte[] imageFile=product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct (@PathVariable int id, @RequestPart Product product,
                                                 @RequestPart MultipartFile imageFile)  {
        Product product1=null;
        try {
            product1 = service.updateProduct(id, product, imageFile);
        } catch(IOException e){
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }
        if(product1!=null){
            return new ResponseEntity<>("Updates",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> DeleteImageById(@PathVariable int productId){
        Product product=service.getProductById(productId);
        if (product!=null){
            service.deleteProduct(productId);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);

        } else
            return new ResponseEntity<>("Product not found",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        System.out.println("Searching with"+keyword);
        List<Product> products=service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



}
