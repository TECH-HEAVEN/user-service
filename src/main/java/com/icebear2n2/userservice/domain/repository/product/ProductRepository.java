package com.icebear2n2.userservice.domain.repository.product;

import com.icebear2n2.userservice.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByProductId(Long productId);

}
