package com.adriav.tcgpokemon.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adriav.tcgpokemon.database.entity.CardEntity
import kotlinx.coroutines.flow.Flow

// DAO for CardEntity
// Table: cards_table

@Dao
interface CardDao {
    @Query("SELECT * FROM cards_table ORDER BY added_at DESC")
    fun getAllCards(): Flow<List<CardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: CardEntity)
}