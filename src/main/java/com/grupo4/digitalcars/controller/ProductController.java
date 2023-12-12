package com.grupo4.digitalcars.controller;

import com.grupo4.digitalcars.model.Product;
import com.grupo4.digitalcars.model.Category;
import com.grupo4.digitalcars.model.Transmission;
import com.grupo4.digitalcars.response.ApiResponseHandler;
import com.grupo4.digitalcars.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Api(tags="Products")
@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService prodctService;

    @GetMapping
    public ResponseEntity<List<Product>> listarProductos(){
        return ResponseEntity.ok(prodctService.getAllProducts());
    }

    @ApiOperation(value="Product by ID", notes="Product by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProducto(@PathVariable Integer id)  {
        Optional<Product> productoBuscado = prodctService.getProductById(id);
        if(productoBuscado.isPresent())
            return ApiResponseHandler.generateResponse("Product data retrieved successfully", HttpStatus.OK, productoBuscado.get());

        return ApiResponseHandler.generateResponseError("Product "+ id + " not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> searchProductByCategory(@PathVariable Category id) {
        List<Product> productsSearch = prodctService.getProductsByCategory(id);
         if(!productsSearch.isEmpty()){
            return ResponseEntity.ok(productsSearch);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Product> crearProducto(@RequestBody Product product){
        return ResponseEntity.ok(prodctService.saveProduct(product));
    }

    @PutMapping("/update")
    public ResponseEntity<?> editarProducto(@RequestBody Product product) throws Exception{
        Optional<Product> productoBuscado = prodctService.getProductById(product.getId());
        if(productoBuscado.isPresent()){
            return ResponseEntity.ok(prodctService.updateProduct(product));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto con ID: " + product.getId() + " no se encuentra ");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id){
        if(prodctService.getProductById(id).isPresent()){
            prodctService.deleteProductById(id);
            return ResponseEntity.ok("Se eliminó con éxito el producto con ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el producto con ID: " + id);
    }

    @GetMapping("/transmission/{id}")
    public ResponseEntity<List<Product>> searchProductByCategory(@PathVariable Transmission id) {
        List<Product> productsSearch = prodctService.getProductsByTransmission(id);
        if(!productsSearch.isEmpty()){
            return ResponseEntity.ok(productsSearch);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/dates/{startDate}/{endDate}")
    public ResponseEntity<List<Product>> searchProductsByRangeDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        List<Product> productsSearch = prodctService.getProductsByRangeDate(startDate, endDate);
        if(!productsSearch.isEmpty()){
            return ResponseEntity.ok(productsSearch);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/transmissionAndDates/{transmissionId}/{startDate}/{endDate}")
    public ResponseEntity<List<Product>> searchProductsByRangeDate(@PathVariable Integer transmissionId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        List<Product> productsSearch = prodctService.getProductsByTransmissionAndRangeDate(transmissionId, startDate, endDate);
        if(!productsSearch.isEmpty()){
            return ResponseEntity.ok(productsSearch);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/searchProducts/{keyword}/{startDate}/{endDate}")
    public ResponseEntity<List<Product>> searchProductsByKeywordAndDateRange(
        @PathVariable String keyword, 
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, 
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        List<Product> productsSearch = prodctService.getProductsByKeywordAndDateRange(keyword, startDate, endDate);
        if (!productsSearch.isEmpty()) {
            return ResponseEntity.ok(productsSearch);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/searchProducts/{keyword}")
    public ResponseEntity<List<Product>> searchProductsByKeyword(@PathVariable String keyword) {
        List<Product> products = prodctService.findByKeyword(keyword);
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @GetMapping("findAll/random")
    public ResponseEntity<List<Product>> findAllRandom(){
        return ResponseEntity.ok(prodctService.getRandomProduct());
    }

}



