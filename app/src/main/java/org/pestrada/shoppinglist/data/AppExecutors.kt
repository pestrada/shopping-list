package org.pestrada.shoppinglist.data

import java.util.concurrent.Executors

object AppExecutors {
    private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

    fun runOnIoThread(command: () -> Unit) {
        IO_EXECUTOR.execute(command)
    }
}