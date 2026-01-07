package com.adriav.tcgpokemon.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards_table")
data class CardEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "rarity") val rarity: String,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "set") val set: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,

    @ColumnInfo(name = "added_at") val addedAt: Long = System.currentTimeMillis()
)