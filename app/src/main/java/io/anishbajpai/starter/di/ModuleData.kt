package io.anishbajpai.starter.di

import dagger.Binds
import dagger.Module
import io.anishbajpai.starter.storage.DataManager
import io.anishbajpai.starter.storage.DataRepository
import io.anishbajpai.starter.storage.LocalRepository
import io.anishbajpai.starter.storage.NetworkRepository
import io.anishbajpai.starter.storage.local.LocalManager
import io.anishbajpai.starter.storage.network.NetworkManager

@Module(
    includes = [
      ModuleNetwork::class,
      ModuleScheduler::class,
      ModuleApp::class
    ]
)
abstract class ModuleData {

  @Binds
  @ScopeApplication
  abstract fun bindDataRepository(dataRepository: DataManager): DataRepository

  @Binds
  @ScopeApplication
  abstract fun bindLocalRepository(localRepository: LocalManager): LocalRepository

  @Binds
  @ScopeApplication
  abstract fun bindNetworkRepository(networkRepository: NetworkManager): NetworkRepository
}