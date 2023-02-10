package org.as.devtechsolution.producrservice.repository;

import org.as.devtechsolution.producrservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aditya Srivastva on 09-02-2023
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
