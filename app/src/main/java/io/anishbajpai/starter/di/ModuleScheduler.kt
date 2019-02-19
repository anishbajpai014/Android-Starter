package io.anishbajpai.starter.di


import dagger.Binds
import dagger.Module
import internetsaathi.dhwaniris.utils.schedulers.BaseSchedulerProvider
import internetsaathi.dhwaniris.utils.schedulers.SchedulerProvider

@Module
abstract class ModuleScheduler {

  @Binds
  @ScopeApplication
  abstract fun bindScheduler(schedulerProvider: SchedulerProvider): BaseSchedulerProvider
}