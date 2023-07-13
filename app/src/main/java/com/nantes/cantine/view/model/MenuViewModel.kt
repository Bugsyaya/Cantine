package com.nantes.cantine.view.model

import android.view.Menu
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nantes.cantine.repository.MenuRepository
import com.nantes.cantine.repository.Result
import kotlinx.coroutines.launch

class MenuViewModel (private val menuRepository: MenuRepository
    ): ViewModel() {

    fun getMenu() {
        // Create a new coroutine on the UI thread
        viewModelScope.launch {
            val jsonBody = "{}"

            // Make the network call and suspend execution until it finishes
            val result = menuRepository.makeMenuRequest(jsonBody)

            println("result : $result")

            // Display result of the network request to the user
            when (result) {
                is Result.Success -> null// Happy path
                else -> null// Show error in UI
            }
        }
    }
}