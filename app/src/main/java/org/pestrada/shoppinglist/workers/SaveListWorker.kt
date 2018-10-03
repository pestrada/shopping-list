package org.pestrada.shoppinglist.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import org.pestrada.shoppinglist.data.AppDatabase
import org.pestrada.shoppinglist.models.ShoppingList

class SaveListWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val shoppingList = ShoppingList()
        shoppingList.timeStamp = inputData.getString("ShoppingList-Timestamp") ?: ""
        AppDatabase.getInstance(applicationContext).shoppingListDao().insertShoppingList(shoppingList)

        return Result.SUCCESS
    }
}