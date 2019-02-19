package io.anishbajpai.starter.di


import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.anishbajpai.starter.Application
import io.anishbajpai.starter.di.config.ActivityBuilder
import io.anishbajpai.starter.jobs.SyncWorkerFactory
import io.anishbajpai.starter.jobs.WorkerBindingModule

@ScopeApplication
@Component(
    modules = [
      AndroidInjectionModule::class,
      ModuleContext::class,
      ModuleData::class,
      ModuleScheduler::class,
      ActivityBuilder::class,
      WorkerBindingModule::class
    ]
)


interface ComponentApplication : AndroidInjector<Application> {

  fun factory(): SyncWorkerFactory

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: android.app.Application): Builder

    fun build(): ComponentApplication
  }

  override fun inject(app: io.anishbajpai.starter.Application)
}