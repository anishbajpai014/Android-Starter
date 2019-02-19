package io.anishbajpai.starter.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val TABLE_ZONE = "table_zone"
const val TABLE_CITY = "table_city"
const val TABLE_STATE = "table_state"
const val TABLE_DISTRICT = "table_district"
const val TABLE_TRADE = "table_trade"
const val TABLE_EMPLOYER = "table_employer"
const val TABLE_BUSINESS = "table_business"
const val TABLE_EDUCATION_LEVEL = "table_education_level"

const val FIELD_CITY_NAME = "city_name"
const val FIELD_TRADE_NAME = "trade_name"
const val FIELD_EDUCATION_LEVEL_NAME = "education_level_name"

const val FIELD_ID = "id"

@Entity(tableName = TABLE_ZONE)
data class Zone(
    @PrimaryKey @ColumnInfo(name = "id") @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name = "created") @SerializedName("created")
    val created: String = "",
    @ColumnInfo(name = "name") @SerializedName("name")
    val name: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = "",
    @ColumnInfo(name = "updated") @SerializedName("updated")
    val updated: String = ""
)

@Entity(tableName = TABLE_CITY)
data class City(
    @ColumnInfo(name = "city_code") @SerializedName("city_code")
    val cityCode: String = "",
    @ColumnInfo(name = "created_at") @SerializedName("created_at")
    val createdAt: String = "",
    @ColumnInfo(name = "district_id") @SerializedName("district_id")
    val districtId: String = "",
    @PrimaryKey @ColumnInfo(name = FIELD_ID) @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name = FIELD_CITY_NAME) @SerializedName("name")
    val name: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = "",
    @ColumnInfo(name = "updated_at") @SerializedName("updated_at")
    val updatedAt: String = ""
)

@Entity(tableName = TABLE_STATE)
data class State(
    @ColumnInfo(name = "created_at") @SerializedName("created_at")
    val createdAt: String = "",
    @PrimaryKey @ColumnInfo(name = "id") @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name = "state_code") @SerializedName("state_code")
    val stateCode: String = "",
    @ColumnInfo(name = "state_id") @SerializedName("state_id")
    val stateId: String = "",
    @ColumnInfo(name = "state_name") @SerializedName("state_name")
    val stateName: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = "",
    @ColumnInfo(name = "updated_at") @SerializedName("updated_at")
    val updatedAt: String = "",
    @ColumnInfo(name = "zone_id") @SerializedName("zone_id")
    val zoneId: String? = "" // STOPSHIP make zoneId not nullable
)

@Entity(tableName = TABLE_DISTRICT)
data class District(
    @ColumnInfo(name = "created_at") @SerializedName("created_at")
    val createdAt: String = "",
    @ColumnInfo(name = "district_code") @SerializedName("district_code")
    val districtCode: String = "",
    @ColumnInfo(name = "district_mid") @SerializedName("district_mid")
    val districtMid: String = "",
    @ColumnInfo(name = "district_name") @SerializedName("district_name")
    val districtName: String = "",
    @PrimaryKey @ColumnInfo(name = "id") @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name = "state_map_id") @SerializedName("state_map_id")
    val stateMapId: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = "",
    @ColumnInfo(name = "updated_at") @SerializedName("updated_at")
    val updatedAt: String = ""
)

@Entity(tableName = TABLE_TRADE)
data class Trade(
    @ColumnInfo(name = "code") @SerializedName("code")
    val code: String = "",
    @ColumnInfo(name = "cost_per_student") @SerializedName("cost_per_student")
    val costPerStudent: String = "",
    @ColumnInfo(name = "created_at") @SerializedName("created_at")
    val createdAt: String = "",
    @PrimaryKey @ColumnInfo(name = FIELD_ID) @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name = FIELD_TRADE_NAME) @SerializedName("name")
    val name: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = "",
    @ColumnInfo(name = "updated_at") @SerializedName("updated_at")
    val updatedAt: String = "",
    @ColumnInfo(name = "user_id") @SerializedName("user_id")
    val userId: String = ""
)


@Entity(tableName = TABLE_EMPLOYER)
data class Employer(
    @PrimaryKey @ColumnInfo(name = "id") @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name = "address") @SerializedName("address")
    val address: String = "",
    @ColumnInfo(name = "city_id") @SerializedName("city_id")
    val cityId: String = "",
    @ColumnInfo(name = "contact_number") @SerializedName("contact_number")
    val contactNumber: String = "",
    @ColumnInfo(name = "contact_person") @SerializedName("contact_person")
    val contactPerson: String = "",
    @ColumnInfo(name = "created_at") @SerializedName("created_at")
    val createdAt: String = "",
    @ColumnInfo(name = "email") @SerializedName("email")
    val email: String = "",
    @ColumnInfo(name = "gst_no") @SerializedName("gst_no")
    val gstNo: String = "",
    @ColumnInfo(name = "name") @SerializedName("name")
    val name: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = "",
    @ColumnInfo(name = "updated_at") @SerializedName("updated_at")
    val updatedAt: String = "",
    @ColumnInfo(name = "user_id") @SerializedName("user_id")
    val userId: String = ""
)

@Entity(tableName = TABLE_BUSINESS)
data class Business(
    @ColumnInfo(name = "address") @SerializedName("address")
    val address: String = "",
    @PrimaryKey @ColumnInfo(name = "business_id") @SerializedName("business_id")
    val id: String = "",
    @ColumnInfo(name = "business_title") @SerializedName("business_title")
    val name: String = "",
    @ColumnInfo(name = "city_id") @SerializedName("city_id")
    val cityId: String = "",
    @ColumnInfo(name = "contact_person") @SerializedName("contact_person")
    val contactPerson: String = "",
    @ColumnInfo(name = "created_at") @SerializedName("created_at")
    val createdAt: String = "",
    @ColumnInfo(name = "email") @SerializedName("email")
    val email: String = "",
    @ColumnInfo(name = "mobile") @SerializedName("mobile")
    val mobile: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = "",
    @ColumnInfo(name = "updated_at") @SerializedName("updated_at")
    val updatedAt: String = "",
    @ColumnInfo(name = "user_id") @SerializedName("user_id")
    val userId: String = ""
)

@Entity(tableName = TABLE_EDUCATION_LEVEL)
data class EducationLevel(
    @ColumnInfo(name = FIELD_EDUCATION_LEVEL_NAME) @SerializedName("education_level")
    val educationLevel: String = "",
    @PrimaryKey @ColumnInfo(name = FIELD_ID) @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name = "status") @SerializedName("status")
    val status: String = ""
)