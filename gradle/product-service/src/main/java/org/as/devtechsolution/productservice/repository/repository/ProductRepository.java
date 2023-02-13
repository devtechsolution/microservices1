package org.as.devtechsolution.productservice.repository.repository;

import org.as.devtechsolution.productservice.entity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aditya Srivastva on 09-02-2023
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
