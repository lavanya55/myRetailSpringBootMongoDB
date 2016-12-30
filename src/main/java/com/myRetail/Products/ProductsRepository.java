package com.myRetail.Products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Lavanya K on 12/27/2016.
 */
@Repository
public interface ProductsRepository extends MongoRepository<ProductsDao, String> {
	public ProductsDao findByProductId(@Param("productId") int productId);
	public ProductsDao save(ProductsDao productDao);
}
