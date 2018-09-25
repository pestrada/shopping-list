package org.pestrada.shoppinglist.ui.list.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.pestrada.shoppinglist.models.Item
import java.util.*

class ListViewModel : ViewModel() {
    val items = MutableLiveData<LinkedList<Item>>()

    fun addItem(item: Item) {
        val newItems: LinkedList<Item> = items.value!!
        newItems.addFirst(item)
        items.value = newItems
    }
}