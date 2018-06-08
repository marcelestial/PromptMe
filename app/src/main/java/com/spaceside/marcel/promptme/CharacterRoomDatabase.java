package com.spaceside.marcel.promptme;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{
        private final CharacterDao mDao;

        PopulateDbAsync(CharacterRoomDatabase db) {
            mDao = db.characterDao();
        }

        @Override
        protected Void doInBackground(final Void... params){
            return null;
        }
    }
}
