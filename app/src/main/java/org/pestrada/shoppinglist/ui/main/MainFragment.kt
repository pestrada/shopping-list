package org.pestrada.shoppinglist.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_fragment.*
import org.pestrada.shoppinglist.R
import org.pestrada.shoppinglist.ui.list.create.CreateListFragment

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
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, CreateListFragment.newInstance(columnCount = 1))
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        //viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
