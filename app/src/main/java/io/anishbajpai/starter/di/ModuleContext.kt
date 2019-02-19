package io.anishbajpai.starter.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ModuleContext {

  @Provides
  @ScopeApplication
  fun provideContext(application: Application): Context {
    return application
  }

}
