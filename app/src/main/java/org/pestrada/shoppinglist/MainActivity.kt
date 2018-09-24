package org.pestrada.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.pestrada.shoppinglist.models.Item
import org.pestrada.shoppinglist.ui.list.create.CreateListFragment
import org.pestrada.shoppinglist.ui.main.MainFragment

class MainActivity : AppCompatActivity(), CreateListFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

    override fun onListFragmentInteraction(item: Item) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
