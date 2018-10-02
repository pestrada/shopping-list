package org.pestrada.shoppinglist.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.pestrada.shoppinglist.ui.main.MainViewModel

class ShoppingListViewModelFactory(private val repository: ShoppingListRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(repository) as T
}