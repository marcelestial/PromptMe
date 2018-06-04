package com.spaceside.marcel.promptme;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "character_table")
public class Character {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "character")
    private String mCharacter;

    public Character(@NonNull String character) {
        this.mCharacter = character;
    }

    public String getCharacter() {
        return this.mCharacter;
    }
}
