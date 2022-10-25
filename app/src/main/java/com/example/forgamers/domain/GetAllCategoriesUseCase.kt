package com.example.forgamers.domain

import com.example.forgamers.data.repository.GameLocalRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(private val localRepository: GameLocalRepository) {

    suspend operator fun invoke(): List<String> = localRepository.getAllCategories()
}