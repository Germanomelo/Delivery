package com.gmsp.delivery.domain.model

import android.os.Parcelable
import com.google.firebase.firestore.PropertyName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String = "",
    val description: String = "",
    val price: Double = 0.0,
    @get:PropertyName("image_url")
    val imageUrl: String = "",
    val enable: Boolean = true
): Parcelable
