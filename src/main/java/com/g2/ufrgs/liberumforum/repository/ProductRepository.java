package com.g2.ufrgs.liberumforum.repository;

import com.g2.ufrgs.liberumforum.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
