package com.ar.pckart.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ar.pckart.product.Wish;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long>{

}
