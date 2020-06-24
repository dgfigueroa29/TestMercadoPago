package com.boa.testmercadopago.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer


/**
 * Base Fragment for using in Model-View-ViewModel architecture. Must be specified ViewState and ViewModel classes.
 */
abstract class BaseFragment<VS, VM : BaseViewModel<VS>> : Fragment() {
    protected lateinit var viewModel: VM
    abstract fun initViewModel(): VM
    abstract fun getLayoutResource(): Int
    abstract fun onViewStateUpdated(viewState: VS)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutResource(), container, false)
        viewModel = initViewModel()
        viewModel.resourceViewState.observe(viewLifecycleOwner, viewStateObserver)
        return view
    }

    private val viewStateObserver = Observer<VS> { viewState ->
        onViewStateUpdated(viewState)
    }
}