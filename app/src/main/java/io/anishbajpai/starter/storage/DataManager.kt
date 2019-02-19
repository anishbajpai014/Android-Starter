package io.anishbajpai.starter.storage

import internetsaathi.dhwaniris.utils.schedulers.SchedulerProvider
import javax.inject.Inject

class DataManager @Inject constructor(
    private val local: LocalRepository,
    private val network: NetworkRepository,
    private val schedulerProvider: SchedulerProvider
) : DataRepository {

}
