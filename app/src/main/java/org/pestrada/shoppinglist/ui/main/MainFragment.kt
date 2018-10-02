package org.pestrada.shoppinglist.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*
import org.pestrada.shoppinglist.R
import org.pestrada.shoppinglist.data.InjectorUtils
import org.pestrada.shoppinglist.ui.list.create.CreateListFragment
import java.util.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        view.listsRecyclerView.layoutManager = LinearLayoutManager(context)
        view.listsRecyclerView.adapter = ListsAdapter(LinkedList())

        val factory = InjectorUtils.provideShoppingListViewModelFactory(context ?: view.context)
        viewModel = ViewModelProviders.of(activity!!, factory).get(MainViewModel::class.java)

        viewModel.getShoppingListLiveData().observe(this, Observer { shoppingLists ->
            val adapter = listsRecyclerView.adapter as? ListsAdapter
            adapter?.setData(shoppingLists)
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        newListButton.setOnClickListener { view ->
            val createListFragment = CreateListFragment.newInstance(columnCount = 1)
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.container, createListFragment)
                    ?.addToBackStack(null)
                    ?.commit()
        }
    }
}
