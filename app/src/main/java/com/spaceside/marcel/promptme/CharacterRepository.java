package com.spaceside.marcel.promptme;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class CharacterRepository {

    private CharacterDao mCharacterDao;
    private LiveData<List<Character>> mAllCharacters;

    CharacterRepository(Application application){
        CharacterRoomDatabase db = CharacterRoomDatabase.getDatabase(application);
        mCharacterDao = db.characterDao();
        mAllCharacters = mCharacterDao.getAllCharacters();
    }

    LiveData<List<Character>> getAllCharacters() {
        return mAllCharacters;
    }

    public void insert (Character character) {
        new insertAsyncTask(mCharacterDao).execute(character);
    }

    private static class insertAsyncTask extends AsyncTask<Character, Void, Void> {

        private CharacterDao mAsyncTaskDao;

        insertAsyncTask(CharacterDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Character... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
