package com.gmsp.delivery.domain.usecase

import android.net.Uri
import com.gmsp.delivery.domain.model.Product

interface CreateProductUseCase {
    suspend operator fun invoke(description: String, price: Double, imageUri: Uri, enable: Boolean): Product
}