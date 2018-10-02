package org.pestrada.shoppinglist.data

import org.pestrada.shoppinglist.models.ShoppingList

class ShoppingListRepository private constructor(private val shoppingListDao: ShoppingListDao) {
    fun getShoppingLists() = shoppingListDao.getAll()

    fun insert(shoppingList: ShoppingList) {
        AppExecutors.runOnIoThread {
            shoppingListDao.insertShoppingList(shoppingList)
        }
    }

    companion object {
        @Volatile
        private var instance: ShoppingListRepository? = null

        fun getInstance(shoppingListDao: ShoppingListDao): ShoppingListRepository {
            return instance ?: synchronized(this) {
                instance ?: ShoppingListRepository(shoppingListDao).also { instance = it }
            }
        }
    }
}