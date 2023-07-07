package com.ar.pckart.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.pckart.product.Cart;
import com.ar.pckart.product.dto.CartResponse;
import com.ar.pckart.product.repo.CartRepository;

@Service
public class CartService {
	
	@Autowired private CartRepository cartRepository;

	public CartResponse save(Cart cart) {
		Cart cartSaved = cartRepository.save(cart);
		return CartResponse.builder()
			.cartId(cartSaved.getId())
			.userId(cartSaved.getUser().getId())
			.productId(cartSaved.getProductId())
			.quantity(cartSaved.getQuantity())
			.build();
	}
	
	public Optional<Cart> findByUserIdAndProductId(Long userId, Long productId) {
		return cartRepository.findByUserAndProductId(userId,productId);
	}
	
	public void update(Long cartId, int quantity) {
		cartRepository.updateQuantity(cartId, quantity);
	}

	public List<CartResponse> cartList() {
		return cartRepository.findAllCarts();
	}

	public List<CartResponse> cartItemsByUserId(Long userId) {
		return cartRepository.findByUserId(userId);
	}

	public void deleteCart(Long cartId) {
		cartRepository.deleteById(cartId);
	}
}
