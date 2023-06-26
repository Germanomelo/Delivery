package com.gmsp.delivery.domain.usecase

import com.gmsp.delivery.data.ProductRepository
import com.gmsp.delivery.domain.model.Product
import java.lang.Exception

class GetProductsUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductsUseCase {

    override suspend fun invoke(): List<Product> {
        return try {
            productRepository.getProducts()
        } catch (e: Exception) {
            throw e
        }
    }
}