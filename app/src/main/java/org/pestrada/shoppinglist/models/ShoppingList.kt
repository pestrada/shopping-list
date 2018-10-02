package org.pestrada.shoppinglist.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.util.*

@Entity(tableName = "shopping_lists")
class ShoppingList() {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "time_stamp")
    var timeStamp: String = Timestamp(Date().time).toString()

    @Ignore
    private lateinit var itemsLists: LinkedList<Item>

    @Ignore
    constructor(itemsList: LinkedList<Item>) : this() {
        this.itemsLists = itemsList
    }
}
