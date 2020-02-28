package com.example.zombicide.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Survivor (

	@SerializedName("id") val id : Int,
	@SerializedName("official") val official : Boolean,
	@SerializedName("name") val name : Name,
	@SerializedName("era") val era : String,
	@SerializedName("from") val from : String,
	@SerializedName("quote") val quote : Quote,
	@SerializedName("story") val story : Story,
	@SerializedName("body") val body : Body,
	@SerializedName("skills") val skills : List<Skills>
) : Parcelable