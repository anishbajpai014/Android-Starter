package io.anishbajpai.starter.di.config

import dagger.Module
import dagger.Provides
import internetsaathi.dhwaniris.utils.schedulers.SchedulerProvider
import io.anishbajpai.starter.storage.DataRepository
import io.anishbajpai.starter.ui.ResourceManager
import io.anishbajpai.starter.ui.base.DefaultViewModelProvider

@Module
class DefaultViewModelProviderModule {

  @Provides
  fun provideDefaultViewModelProvider(
      dataRepository: DataRepository,
      schedulerProvider: SchedulerProvider,
      resourceManager: ResourceManager
  ) = DefaultViewModelProvider(dataRepository, schedulerProvider, resourceManager)

}