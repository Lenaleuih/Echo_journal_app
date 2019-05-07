package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalViewHolder> {
    private ArrayList<Journal> journals;
    private Context context;

    public JournalAdapter(ArrayList<Journal> journals, Context context) {
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
        holder.getMonthTextView().setText(journal.getJournalMonth());
        holder.getDayTextView().setText(journal.getJournalDay());
        holder.getContentTextView().setText(journal.getJournalText());

        if (journal.isMarked()) {
            Context ctx = context;
            holder.getDayTextView().setTextColor(ctx.getResources().getColor(R.color.colorAccentGreen));
        }


    }



    @Override
    public int getItemCount() {
        return journals.size();
    }

}

