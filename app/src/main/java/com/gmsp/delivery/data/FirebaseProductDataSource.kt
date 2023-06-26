package com.gmsp.delivery.data

import android.net.Uri
import com.gmsp.delivery.domain.model.Product
import com.gmsp.delivery.util.COLLECTION_PRODUCTS
import com.gmsp.delivery.util.COLLECTION_ROOT
import com.gmsp.delivery.util.STORAGE_IMAGES
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseProductDataSource(
    firebaseFirestore: FirebaseFirestore,
    firebaseStorage: FirebaseStorage,
) : ProductDataSource {

    private val documentReference = firebaseFirestore.document(COLLECTION_ROOT)

    private val storageReference = firebaseStorage.reference

    override suspend fun getProducts(): List<Product> {
        return suspendCoroutine { continuation ->
            val productReference = documentReference.collection(COLLECTION_PRODUCTS)
            productReference.get().addOnSuccessListener { documents ->
                val products = mutableListOf<Product>()
                for (document in documents) {
                    document.toObject(Product::class.java).run {
                        products.add(this)
                    }
                }
                continuation.resumeWith(Result.success(products))
            }

            productReference.get().addOnFailureListener { exception ->
                continuation.resumeWith(Result.failure(exception))
            }

        }
    }

    override suspend fun uploadProductImage(imageUri: Uri): String {
        return suspendCoroutine { continuation ->
            val randomKey = UUID.randomUUID()
            val childReference = storageReference.child(
                "$STORAGE_IMAGES/$COLLECTION_PRODUCTS/$randomKey"
            )
            childReference.putFile(imageUri)
                .addOnSuccessListener { taskSnapshot ->
                    taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                        val path = uri.toString()
                        continuation.resumeWith(Result.success(path))
                    }
                }.addOnFailureListener { exception ->
                    continuation.resumeWith(Result.failure(exception))
                }

        }
    }

    override suspend fun createProduct(product: Product): Product {
        return suspendCoroutine { continuation ->
            documentReference.collection(COLLECTION_PRODUCTS)
                .document(System.currentTimeMillis().toString()).set(product)
                .addOnSuccessListener {
                    continuation.resumeWith(Result.success(product))
                }.addOnFailureListener { exception ->
                    continuation.resumeWith(Result.failure(exception))
                }
        }
    }
}