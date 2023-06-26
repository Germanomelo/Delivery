package com.gmsp.delivery.domain.usecase

import com.gmsp.delivery.domain.model.Product

interface GetProductsUseCase {
    suspend operator fun invoke(): List<Product>
}