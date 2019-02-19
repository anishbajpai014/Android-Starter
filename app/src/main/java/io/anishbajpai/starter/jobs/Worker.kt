package io.anishbajpai.starter.jobs

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.RxWorker
import androidx.work.WorkerParameters
import io.anishbajpai.starter.storage.DataRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Provider

interface ChildWorkerFactory {
  fun create(appContext: Context, params: WorkerParameters): ListenableWorker
}

class SyncWorker(
    appContext: Context,
    params: WorkerParameters,
    private val dataRepository: DataRepository
    // add more dependencies here
) : RxWorker(appContext, params) {

  override fun createWork(): Single<Result> {
//        return dataRepository.syncData()
//            .doOnComplete { Timber.d("Sync Completed") }
//            .doOnError { Timber.d("Sync Failed") }
//            .toSingleDefault(Result.success())
//            .onErrorReturn { Result.failure() }
    return Single.just(Result.success())
  }

  class Factory @Inject constructor(
      private val dataRepository: Provider<DataRepository>
  ) : ChildWorkerFactory {
    override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
      return SyncWorker(
          appContext,
          params,
          dataRepository.get()
      )
    }
  }
}