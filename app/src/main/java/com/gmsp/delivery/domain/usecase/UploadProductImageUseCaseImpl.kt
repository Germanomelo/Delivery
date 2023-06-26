package com.gmsp.delivery.domain.usecase

import android.net.Uri
import com.gmsp.delivery.data.ProductRepository

class UploadProductImageUseCaseImpl(
    private val productRepository: ProductRepository
) : UploadProductImageUseCase {

    override suspend fun invoke(imageUri: Uri): String {
        return productRepository.uploadProductImage(imageUri)
    }
}