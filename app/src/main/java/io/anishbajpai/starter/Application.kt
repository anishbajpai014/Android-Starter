package io.anishbajpai.starter

import android.app.Activity
import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.anishbajpai.starter.di.DaggerComponentApplication
import timber.log.Timber
import javax.inject.Inject

class Application : Application(), HasActivityInjector {

  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>
  private val componentApplication by lazy {
    DaggerComponentApplication.builder()
        .application(this)
        .build()
  }


  override fun onCreate() {
    super.onCreate()

    AndroidThreeTen.init(this)

    componentApplication.inject(this)

    val configuration = Configuration.Builder()
        .setWorkerFactory(componentApplication.factory())
        .build()

    // TODO: 16/1/19 use assisted inject for workmanager https://github.com/nlgtuankiet/dagger-workmanager
    WorkManager.initialize(this, configuration)

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return activityInjector
  }

}