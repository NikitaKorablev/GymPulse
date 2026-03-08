package ru.app.repository

import ru.app.model.ProductDetailsDto
import ru.app.util.ApiState

interface Repository {
    suspend fun getProductDetails(): ApiState<ProductDetailsDto>
}