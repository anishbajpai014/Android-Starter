package io.anishbajpai.starter.utils

import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

fun Completable.logAndSwallowError(): Completable {
  return doOnError { Timber.e(it) }
      .onErrorComplete()
}

fun Disposable.addTo(cd: CompositeDisposable) {
  cd.add(this)
}