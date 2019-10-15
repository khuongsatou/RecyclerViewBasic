package com.nvk.recyclerviewver2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordListViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(LinkedList<String> mWordList, Context context) {
        this.mWordList = mWordList;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordListAdapter.WordListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.custom_item_list,parent,false);

        return new WordListViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordListViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.tvWord.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class WordListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView tvWord;
        final WordListAdapter mAdapter;

        public WordListViewHolder(@NonNull View itemView, WordListAdapter mAdapter) {
            super(itemView);

            tvWord = itemView.findViewById(R.id.tvWord);
            tvWord.setOnClickListener(this);
            this.mAdapter = mAdapter;
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition,"Clicked"+element);

            mAdapter.notifyDataSetChanged();

        }
    }
}
