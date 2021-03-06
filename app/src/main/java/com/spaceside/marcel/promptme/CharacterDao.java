package com.spaceside.marcel.promptme;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CharacterDao {

    @Insert
    void insert(Character character);

    @Query("DELETE FROM character_table")
    void deleteAll();

    @Query("SELECT * from character_table ORDER BY character ASC")
    LiveData<List<Character>> getAllCharacters();
}
