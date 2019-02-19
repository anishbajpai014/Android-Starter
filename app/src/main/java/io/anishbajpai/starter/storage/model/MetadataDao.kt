package io.anishbajpai.starter.storage.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface MetadataDao {

  @Query("SELECT * FROM $TABLE_ZONE")
  fun getZone(): Single<List<Zone>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllZone(items: List<Zone>)

  @Query("SELECT * FROM $TABLE_CITY")
  fun getCity(): Single<List<City>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllCity(items: List<City>)

  @Query("SELECT * FROM $TABLE_STATE")
  fun getState(): Single<List<State>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllState(items: List<State>)

  @Query("SELECT * FROM $TABLE_DISTRICT")
  fun getDistrict(): Single<List<District>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllDistrict(items: List<District>)

  @Query("SELECT * FROM $TABLE_TRADE")
  fun getTrade(): Single<List<Trade>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllTrade(items: List<Trade>)

  @Query("SELECT * FROM $TABLE_EMPLOYER")
  fun getEmployer(): Single<List<Employer>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllEmployer(items: List<Employer>)

  @Query("SELECT * FROM $TABLE_BUSINESS")
  fun getBusiness(): Single<List<Business>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllBusiness(items: List<Business>)

  @Query("SELECT * FROM $TABLE_EDUCATION_LEVEL")
  fun getEducationLevel(): Single<List<EducationLevel>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveAllEducationLevel(items: List<EducationLevel>)

}