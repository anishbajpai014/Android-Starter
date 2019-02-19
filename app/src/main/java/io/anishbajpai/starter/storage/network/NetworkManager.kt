package io.anishbajpai.starter.storage.network

import android.content.Context
import com.google.gson.Gson
import internetsaathi.dhwaniris.utils.schedulers.SchedulerProvider
import io.anishbajpai.starter.di.config.AuthInterceptor
import io.anishbajpai.starter.storage.NetworkRepository
import javax.inject.Inject

class NetworkManager @Inject constructor(
    private val network: NetworkInterface,
    private val authInterceptor: AuthInterceptor,
    private val schedulerProvider: SchedulerProvider,
    private val gson: Gson,
    private val context: Context
) : NetworkRepository {

  override var token: String
    get() = authInterceptor.authToken
    set(value) {
      authInterceptor.authToken = value
    }

}

class AuthException : Exception()