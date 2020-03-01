package com.example.zombicide.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Skill (

    @SerializedName("skill_id") val skill_id : Int,
    @SerializedName("skill_name") val skill_name : String,
    @SerializedName("skill_name_en") val skill_name_en : String,
    @SerializedName("description") val description : String,
    @SerializedName("description_en") val description_en : String
) : Serializable