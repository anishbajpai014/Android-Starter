package io.anishbajpai.starter.di


import android.content.Context
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import internetsaathi.dhwaniris.utils.schedulers.BaseSchedulerProvider
import io.anishbajpai.starter.BuildConfig
import io.anishbajpai.starter.di.config.AuthInterceptor
import io.anishbajpai.starter.storage.network.NetworkInterface
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit

//const val NAMED_OKHTTP_VANILLA = "vanilla_okhttp"
//const val NAMED_OKHTTP_AUTH = "auth_okhttp"
//
//const val HEADER_KEY_NO_AUTH = "no-authorisation"

@Module(includes = [ModuleContext::class, ModuleApp::class, ModuleScheduler::class])
class ModuleNetwork {

  @Provides
  @ScopeApplication
  fun chuckInterceptor(context: Context) = ChuckInterceptor(context).showNotification(true)

  @Provides
  @ScopeApplication
  fun authInterceptor(): AuthInterceptor {
    return AuthInterceptor()
  }

  @Provides
  @ScopeApplication
  fun loggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor(
        HttpLoggingInterceptor.Logger { message -> Timber.d(message) })
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
  }

  @Provides
  @ScopeApplication
  fun cache(cacheFile: File): Cache {
    return Cache(cacheFile, (10 * 1000 * 1000).toLong()) //10MB Cache
  }

  @Provides
  @ScopeApplication
  fun cacheFile(context: Context): File {
    return File(context.cacheDir, "okhttp_cache")
  }

  @Provides
  @ScopeApplication
//    @Named(NAMED_OKHTTP_VANILLA)
  fun okHttpClient(
      cache: Cache,
      loggingInterceptor: HttpLoggingInterceptor,
      chuckInterceptor: ChuckInterceptor,
      authInterceptor: AuthInterceptor
  )
      : OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .writeTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .addNetworkInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .addInterceptor(chuckInterceptor)
        .cache(cache)
        .build()
  }

  @ScopeApplication
  @Provides
  fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
    return GsonConverterFactory
        .create(gson)
  }

  @ScopeApplication
  @Provides
  fun retrofitSetup(
      okHttpClient: OkHttpClient,
      gson: GsonConverterFactory,
      schedulerProvider: BaseSchedulerProvider
  ): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(
            RxJava2CallAdapterFactory.createWithScheduler(schedulerProvider.io()))
        .addConverterFactory(gson)
        .build()
  }

  @ScopeApplication
  @Provides
  fun retrofitProvides(retrofit: Retrofit): NetworkInterface {
    return retrofit.create(NetworkInterface::class.java)
  }
}