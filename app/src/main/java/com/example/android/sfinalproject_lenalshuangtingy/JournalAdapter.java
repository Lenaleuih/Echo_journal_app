package com.example.android.sfinalproject_lenalshuangtingy;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalViewHolder> {
    private List<Journal> journals;
    private Context context;

    public JournalAdapter(List<Journal> journals, Context context) {
        this.journals = journals;
        this.context = context;
    }

    @Override
    public JournalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_timeline, parent, false);
        return new JournalViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(JournalViewHolder holder, int position) {
        Journal journal = journals.get(position);
        holder.getJournalTitleView().setText(journal.getJournalTitle());
       // holder.getJournalInfoView().setText(president.getInfo());
        holder.getJournalPhotoView().setImageResource(journal.getJournalPhoto());
    }

    @Override
    public int getItemCount() {
        return journals.size();
    }

}

