package com.example.zombicide.models

import com.google.gson.annotations.SerializedName

data class Skills (

    @SerializedName("slot") val slot : Int,
    @SerializedName("skill_id") val skill_id : Int
)