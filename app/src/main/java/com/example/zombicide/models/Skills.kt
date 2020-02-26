package com.example.zombicide.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Skills (

    @SerializedName("slot") val slot : Int,
    @SerializedName("skill_id") val skill_id : Int
) : Parcelable