package com.example.zombicide.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomSkill (

    @SerializedName("skill_id") val skill_id : Int,
    @SerializedName("skill_name") val skill_name : String

) : Parcelable