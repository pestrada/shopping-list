package org.pestrada.shoppinglist.ui.list.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.pestrada.shoppinglist.models.Item
import java.util.*

class ListViewModel : ViewModel() {
    private val itemsLiveData = MutableLiveData<List<Item>>()

    init {
        itemsLiveData.value = LinkedList()
    }

    private fun itemsList(): LinkedList<Item> = itemsLiveData.value as? LinkedList<Item>
            ?: LinkedList()

    private fun updateItems(items: List<Item>) {
        itemsLiveData.value = items
    }

    fun getItemsLiveData() = itemsLiveData

    fun addItem(item: Item) {
        val itemsList = itemsList()
        itemsList.addFirst(item)
        updateItems(itemsList)
    }
}