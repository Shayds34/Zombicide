package com.example.zombicide.models

import com.google.gson.annotations.SerializedName

data class Hero (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("from") val from : String,
    @SerializedName("story") val story : String,
    @SerializedName("story_en") val story_en : String,
    @SerializedName("alt_armor") val alt_armor : String,
    @SerializedName("alt_armor_en") val alt_armor_en : String,
    @SerializedName("skills") val skills : List<Skills>
)