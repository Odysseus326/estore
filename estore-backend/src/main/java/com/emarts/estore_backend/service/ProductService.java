package com.emarts.estore_backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emarts.estore_backend.model.Product;
import com.emarts.estore_backend.repository.ProductRepository;



@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();  // findAll returns a list from the repository
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);  // CHANGE LATER
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());  // Sets image name as object property
        product.setImageType(imageFile.getContentType());  // Sets image file type/extension as object property
        product.setImageData(imageFile.getBytes());  // Sets image data as object property
        return repository.save(product);  // Saves all data into database (including image data)
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException{
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repository.save(product);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repository.searchProduct(keyword);
    }
}
