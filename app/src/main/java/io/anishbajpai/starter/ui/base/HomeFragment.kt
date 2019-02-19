package io.anishbajpai.starter.ui.base

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import io.anishbajpai.starter.R
import io.anishbajpai.starter.storage.DataRepository
import javax.inject.Inject

fun createHomeFragment(): HomeFragment {
  val fragment = HomeFragment()
  return fragment
}

class HomeFragment : BaseFragment() {

  @Inject
  lateinit var dataRepository: DataRepository

  override fun inflateLayout() = R.layout.screen_home

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val epoxyController = object : EpoxyController() {
      init {
        spanCount = 2
      }

      override fun buildModels() {
      }
    }

    val rvHome = view.findViewById<EpoxyRecyclerView>(R.id.rv_home)
    rvHome.layoutManager = GridLayoutManager(context, epoxyController.spanCount)

    rvHome.setControllerAndBuildModels(epoxyController)
  }
}