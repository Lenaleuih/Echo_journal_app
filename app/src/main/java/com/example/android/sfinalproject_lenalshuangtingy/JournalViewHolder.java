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

    public JournalViewHolder(@NonNull View itemView, CardView cardView, TextView journalTitleView,
                             ImageView journalPhotoView, Context context) {
        super(itemView);
        this.cardView = cardView;
        this.journalTitleView = journalTitleView;
        this.journalPhotoView = journalPhotoView;
        this.context = context;
    }

    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }

    public TextView getJournalTitleView() {
        return journalTitleView;
    }

    public void setJournalTitleView(TextView presidentNameView) {
        this.journalTitleView = presidentNameView;
    }

   // public TextView getJournalInfoView() {
   //     return journalInfoView;
   // }

//    public void setJournalInfoView(TextView presidentInfoView) {
//        this.journalInfoView = presidentInfoView;
//    }

    public ImageView getJournalPhotoView() {
        return journalPhotoView;
    }

    public void setJournalPhotoView(ImageView presidentPhotoView) {
        this.journalPhotoView = presidentPhotoView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private TextView journalTitleView;
    //private TextView journalinfoView;
    private ImageView journalPhotoView;
    private Context context;

    //b)
    public JournalViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        journalTitleView = (TextView) itemView.findViewById(R.id.journalTitle);
        //journalInfoView = (TextView) itemView.findViewById(R.id.person_info);
        journalPhotoView = (ImageView) itemView.findViewById(R.id.journalPhoto);
        this.context = context;

//c)
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, journalTitleView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

