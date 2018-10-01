package org.pestrada.shoppinglist.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.pestrada.shoppinglist.models.Item
import org.pestrada.shoppinglist.models.ShoppingList
import java.util.*

class MainViewModel : ViewModel() {
    private val shoppingListsLiveData = MutableLiveData<List<ShoppingList>>()

    private val shoppingLists: LinkedList<ShoppingList>
        get() = shoppingListsLiveData.value as? LinkedList<ShoppingList> ?: LinkedList()

    init {
        shoppingListsLiveData.value = LinkedList()
    }

    fun getShoppingListLiveData() = shoppingListsLiveData

    fun addShoppingList(itemsList: LinkedList<Item>) {
        val shoppingList = ShoppingList(itemsList)
        val lists = shoppingLists
        lists.add(shoppingList)
        shoppingListsLiveData.value = lists
    }
}
