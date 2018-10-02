package org.pestrada.shoppinglist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.pestrada.shoppinglist.models.ShoppingList

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM shoppinglists")
    fun getAll(): List<ShoppingList>

    @Insert
    fun insertAll(vararg shoppingList: ShoppingList)
}