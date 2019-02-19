package io.anishbajpai.starter.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.anishbajpai.starter.ui.MainActivity

abstract class BaseFragment : DaggerFragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(inflateLayout(), container, false)
  }

  abstract fun inflateLayout(): Int

  protected var navigator: NavigationManager? = null

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is MainActivity) {
      navigator = context.navigationManager
    }
  }

  override fun onDetach() {
    super.onDetach()
    navigator = null
  }
}