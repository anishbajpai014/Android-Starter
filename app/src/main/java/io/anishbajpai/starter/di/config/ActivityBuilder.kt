package io.anishbajpai.starter.di.config

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.anishbajpai.starter.ui.MainActivity
import io.anishbajpai.starter.ui.base.HomeFragment

@Module
abstract class ActivityBuilder {

  @ContributesAndroidInjector
  abstract fun contributeMainActivity(): MainActivity

  @ContributesAndroidInjector
  abstract fun contributesHomeFragment(): HomeFragment

}