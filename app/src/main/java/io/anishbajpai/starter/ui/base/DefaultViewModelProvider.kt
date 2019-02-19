package io.anishbajpai.starter.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import internetsaathi.dhwaniris.utils.schedulers.SchedulerProvider
import io.anishbajpai.starter.storage.DataRepository
import io.anishbajpai.starter.ui.ResourceManager

class DefaultViewModelProvider(
    private val dataRepository: DataRepository,
    private val schedulerProvider: SchedulerProvider,
    private val resourceManager: ResourceManager
) : ViewModelProvider.NewInstanceFactory() {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return when (modelClass) {
      else -> super.create(modelClass)
    }
  }

}