package org.pestrada.shoppinglist.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_fragment.*
import org.pestrada.shoppinglist.R
import org.pestrada.shoppinglist.models.Item
import org.pestrada.shoppinglist.ui.list.create.CreateListFragment
import java.util.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        newListButton.setOnClickListener { view ->
            val createListFragment = CreateListFragment.newInstance(columnCount = 1)
            createListFragment.setTargetFragment(this, CreateListFragment.REQUEST_CODE)
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.container, createListFragment)
                    ?.addToBackStack(null)
                    ?.commit()
        }

        //viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CreateListFragment.REQUEST_CODE) {
                val serializable = data?.getSerializableExtra("ShoppingList")
                if (serializable is LinkedList<*>) {
                    
                }
            }
        }
    }
}
