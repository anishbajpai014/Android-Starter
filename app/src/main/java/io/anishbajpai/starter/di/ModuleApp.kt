package io.anishbajpai.starter.di

import android.content.Context
import com.afollestad.rxkprefs.RxkPrefs
import com.afollestad.rxkprefs.rxkPrefs
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.anishbajpai.starter.di.config.NoModuleExclusionStrategy

const val PREF_NAME = "skill_prefs"

@Module(includes = [ModuleContext::class])
class ModuleApp {

  @Provides
  @ScopeApplication
  fun gson(): Gson = GsonBuilder()
      .addSerializationExclusionStrategy(NoModuleExclusionStrategy(false))
      .addDeserializationExclusionStrategy(NoModuleExclusionStrategy(true))
      .setLenient()
      .create()

  @Provides
  @ScopeApplication
  fun providesRxSharedPreferences(context: Context): RxkPrefs {
    return rxkPrefs(context, PREF_NAME)
  }
}