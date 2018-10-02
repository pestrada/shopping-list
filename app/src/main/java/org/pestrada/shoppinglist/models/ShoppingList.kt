package org.pestrada.shoppinglist.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.util.*

@Entity(tableName = "shoppinglists")
data class ShoppingList(@PrimaryKey(autoGenerate = true)
                        var uid: Int = 0,
                        @Ignore
                        var itemsList: LinkedList<Item>) {

    constructor() : this(0, LinkedList())
    
    fun timeStamp(): String = Timestamp(Date().time).toString()
}
