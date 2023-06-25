package com.gmsp.delivery.domain.model

data class Product(
    val id: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = "",
    val enable: Boolean = true
)
