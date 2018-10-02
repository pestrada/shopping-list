package org.pestrada.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.pestrada.shoppinglist.models.ShoppingList

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM shopping_lists")
    fun getAll(): LiveData<List<ShoppingList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoppingList(shoppingList: ShoppingList)
}