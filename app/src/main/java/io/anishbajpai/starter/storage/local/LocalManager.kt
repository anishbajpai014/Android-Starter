package io.anishbajpai.starter.storage.local

import com.afollestad.rxkprefs.RxkPrefs
import internetsaathi.dhwaniris.utils.schedulers.BaseSchedulerProvider
import io.anishbajpai.starter.storage.LocalRepository
import javax.inject.Inject

private const val PREF_AUTH_TOKEN = "pref_auth_token"

class LocalManager @Inject constructor(
    private val prefs: RxkPrefs,
    private val schedulerProvider: BaseSchedulerProvider
) : LocalRepository {

  override var token: String
    get() = prefs.string(PREF_AUTH_TOKEN, "").get()
    set(value) {
      prefs.string(PREF_AUTH_TOKEN, "").set(value)
    }


}