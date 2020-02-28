package com.example.zombicide.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name (

	@SerializedName("long_en") val long_en : String,
	@SerializedName("long_fr") val long_fr : String,
	@SerializedName("short_en") val short_en : String,
	@SerializedName("short_fr") val short_fr : String

) : Parcelable