package com.ar.pckart.product.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ar.pckart.product.Cart;
import com.ar.pckart.product.dto.CartResponse;
import com.ar.pckart.product.service.CartService;

@RestController
@RequestMapping("/pckart/api/v1/cart")
public class CartController {

	@Autowired private CartService cartService;
/*
	@PostMapping("/add-to-cart")
	public ResponseEntity<CartResponse> addToCart(@RequestBody Cart cart) {
		return ResponseEntity.ok(cartService.save(cart));
	}
	
	@GetMapping("/get/all-carts")
	public ResponseEntity<List<CartResponse>> allCartsList(){
		return ResponseEntity.ok(cartService.cartList());
	}
	
	@GetMapping("/get/cart/{id}")
	public ResponseEntity<?> getCartItemsByUserId(@PathVariable Long id) {
		cartService.cartItemsByUserId(id);
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
