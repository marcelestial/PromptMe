package com.spaceside.marcel.promptme;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class CharacterViewModel extends AndroidViewModel {

    private CharacterRepository mRepository;

    private LiveData<List<Character>> mAllCharacters;

    public CharacterViewModel (Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
        mAllCharacters = mRepository.getAllCharacters();
    }

    LiveData<List<Character>> getAllCharacters(){
        return mAllCharacters;
    }

    public void insert(Character character){
        mRepository.insert(character);
    }

}
