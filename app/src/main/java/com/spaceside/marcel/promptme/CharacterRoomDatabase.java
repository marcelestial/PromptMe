package com.spaceside.marcel.promptme;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Character.class}, version = 1)
public abstract class CharacterRoomDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();

    private static CharacterRoomDatabase INSTANCE;

    static CharacterRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CharacterRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CharacterRoomDatabase.class, "character_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
