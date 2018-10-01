package org.pestrada.shoppinglist.models

import java.sql.Timestamp
import java.util.*

data class ShoppingList(val itemsList: LinkedList<Item>) {
    fun timeStamp(): String = Timestamp(Date().time).toString()
}
