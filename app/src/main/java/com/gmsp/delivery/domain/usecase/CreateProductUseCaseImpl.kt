package com.gmsp.delivery.domain.usecase

import android.net.Uri
import com.gmsp.delivery.data.ProductRepository
import com.gmsp.delivery.domain.model.Product
import java.util.UUID

class CreateProductUseCaseImpl(
    private val uploadProductImageUseCase: UploadProductImageUseCase,
    private val repository: ProductRepository
) : CreateProductUseCase {

    override suspend fun invoke(
        description: String,
        price: Double,
        imageUri: Uri,
        enable: Boolean
    ): Product {

        return try {
            val imageUrl = uploadProductImageUseCase(imageUri)
            val product =
                Product(UUID.randomUUID().toString(), description, price, imageUrl, enable)
            repository.createProduct(product)
        } catch (e: Exception) {
            throw e
        }
    }
}