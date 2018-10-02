package org.pestrada.shoppinglist.data

import android.content.Context
import androidx.lifecycle.ViewModelProvider

object InjectorUtils {
    private fun getShoppingListRepository(context: Context): ShoppingListRepository {
        return ShoppingListRepository.getInstance(AppDatabase.getInstance(context).shoppingListDao())
    }

    fun provideShoppingListViewModelFactory(context: Context): ViewModelProvider.Factory? {
        val repository = getShoppingListRepository(context)
        return ShoppingListViewModelFactory(repository)
    }
}