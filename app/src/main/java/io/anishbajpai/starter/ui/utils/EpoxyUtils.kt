package io.anishbajpai.starter.ui.utils

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView

fun EpoxyRecyclerView.withModels(buildModelsCallback: EpoxyController.() -> Unit) {
  setControllerAndBuildModels(object : EpoxyController() {
    override fun buildModels() {
      buildModelsCallback()
    }
  })
}