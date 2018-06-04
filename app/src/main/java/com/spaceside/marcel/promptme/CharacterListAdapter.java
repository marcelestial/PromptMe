package com.spaceside.marcel.promptme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.List;


public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder> {

    class CharacterViewHolder extends RecyclerView.ViewHolder{
        private final CheckBox characterItemView;

        private CharacterViewHolder(View itemView){
            super(itemView);
            characterItemView = itemView.findViewById(R.id.checkbox);
        }
    }

    private final LayoutInflater mInflater;
    private List<Character> mCharacters; //Cached copy of characters

    CharacterListAdapter(Context context) { mInflater = LayoutInflater.from(context);}

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        if(mCharacters != null){
            Character current = mCharacters.get(position);
            holder.characterItemView.setText(current.getCharacter());
        } else {
            // Covers the case of data not being ready yet.
            holder.characterItemView.setText("No Name");
        }
    }

    void setCharacters(List<Character> characters){
        mCharacters = characters;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if (mCharacters != null){
            return mCharacters.size();
        }
        else return 0;
    }
}
