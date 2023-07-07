package com.ar.pckart.product.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class WishController {

/*
	@PostMapping("/add-product-imgs")
	public ProductDetails saveWithMultipleImage(
			@RequestParam(name = "file") MultipartFile file,
			@RequestParam(name = "files") MultipartFile[] files,
			@RequestPart Product product
			) throws IOException {
		
		ProductDetails savedProduct = productService.save(product);
		imagesService.saveImages(file, files, savedProduct.getId(),savedProduct.getName());
		
		return savedProduct; 
	}
	
	@GetMapping("/get/all-products")
	public ResponseEntity<List<ProductResponse>> allProducts(){
		return ResponseEntity.ok(productService.listOfProducts());
	}
	
	@GetMapping("/get/all-product-imgs")
	public ResponseEntity<?> listOfProducts() throws IOException {
		List<ProductDTO<byte[]>> listOfProds = productService.listOfProductsWithImages();
		return ResponseEntity.status(HttpStatus.OK).body(listOfProds);	
	}
	
	@GetMapping("/get/product/{id}")
	public ResponseEntity<?> getProductDetailsMainImageById(@PathVariable Long id) throws IOException {
		ProductDTO<byte[]> productInfo = productService.productDetailWithMainImageById(id);
		return ResponseEntity.status(HttpStatus.OK).body(productInfo);	
	}
	
	@GetMapping("/get/product-imgs/{id}")
	public ResponseEntity<?> getProductDetailsImagesById(@PathVariable Long id) throws IOException {
		ProductDTO<List<byte[]>> productInfo = productService.productDetailsWithImagesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(productInfo);	
	}
	
	@GetMapping("/get/product-res/{id}")
	public ResponseEntity<ProductResponse> getProductResponseById(
			@PathVariable("id") Long id){
		return ResponseEntity.ok(productService.productResponseById(id));
	}
	
	@PutMapping("/update-product/{id}")
	public ProductDetails updateImageInfo(
			@PathVariable("id") Long id,
			@RequestParam(name = "file") MultipartFile file,
			@RequestParam(name = "files") MultipartFile[] files,
			@RequestPart Product product
			) throws IOException {
		
		ProductDetails updatedProduct = productService.update(id,product);
		imagesService.updateImages(file, files, updatedProduct.getId(),updatedProduct.getName());
		
		return updatedProduct;
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteById(id);
		imagesService.deleteImageDataAndFolder(id);
		return ResponseEntity.ok("Product deleted");
	}
	*/
	
}
