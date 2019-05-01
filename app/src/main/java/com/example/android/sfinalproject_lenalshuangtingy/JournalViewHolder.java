package com.example.android.sfinalproject_lenalshuangtingy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JournalViewHolder extends RecyclerView.ViewHolder {
    //a)
    private CardView cardView;
    private TextView monthTextView;
    private TextView dayTextView;
    private TextView contentTextView;
    private Context context;

    public JournalViewHolder(View itemView, final Context context){
        super(itemView);
        cardView = (CardView)itemView.findViewById(R.id.card_view);
        monthTextView=(TextView)itemView.findViewById(R.id.month);
        dayTextView=(TextView)itemView.findViewById(R.id.day);
        contentTextView=(TextView)itemView.findViewById(R.id.text);
        this.context=context;


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dayTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TextView getContentTextView() {
        return contentTextView;
    }

    public void setContentTextView(TextView contentTextView) {
        this.contentTextView = contentTextView;
    }

    public TextView getDayTextView() {
        return dayTextView;
    }

    public void setDayTextView(TextView dayTextView) {
        this.dayTextView = dayTextView;
    }

    public TextView getMonthTextView() {
        return monthTextView;
    }

    public void setMonthTextView(TextView monthTextView) {
        this.monthTextView = monthTextView;
    }
}

