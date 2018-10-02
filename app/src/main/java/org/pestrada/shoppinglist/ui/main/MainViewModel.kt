package org.pestrada.shoppinglist.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.pestrada.shoppinglist.data.ShoppingListRepository
import org.pestrada.shoppinglist.models.Item
import org.pestrada.shoppinglist.models.ShoppingList
import java.util.*

class MainViewModel(private val repository: ShoppingListRepository) : ViewModel() {
    private val shoppingListsLiveData = MutableLiveData<List<ShoppingList>>()
    private val storedShoppingLists = Transformations.map(shoppingListsLiveData) {
        repository.getShoppingLists()
    }

    private val shoppingLists: LinkedList<ShoppingList>
        get() = shoppingListsLiveData.value as? LinkedList<ShoppingList> ?: LinkedList()

    init {
        shoppingListsLiveData.value = LinkedList()
    }

    fun getShoppingListLiveData() = shoppingListsLiveData

    fun addShoppingList(itemsList: LinkedList<Item>) {
        val shoppingList = ShoppingList(itemsList = itemsList)
        val lists = shoppingLists
        lists.add(shoppingList)
        shoppingListsLiveData.value = lists
        repository.insert(shoppingList)
    }
}
