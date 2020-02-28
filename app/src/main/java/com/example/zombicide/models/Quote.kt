package com.example.zombicide.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Quote (

	@SerializedName("en") val en : String,
	@SerializedName("fr") val fr : String
) : Parcelable