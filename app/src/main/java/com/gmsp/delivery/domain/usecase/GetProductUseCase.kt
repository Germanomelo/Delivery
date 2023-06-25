package com.gmsp.delivery.domain.usecase

import android.net.Uri
import com.gmsp.delivery.domain.model.Product

interface GetProductUseCase {
    suspend operator fun invoke(): List<Product>
}