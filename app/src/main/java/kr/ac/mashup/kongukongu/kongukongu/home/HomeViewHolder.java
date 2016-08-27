package kr.ac.mashup.kongukongu.kongukongu.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.ac.mashup.kongukongu.kongukongu.R;

/**
 * Created by owner on 2016-08-27.
 */
public class HomeViewHolder extends RecyclerView.ViewHolder {

    ImageView imgMain;
    TextView txtText01,txtText02;

    public HomeViewHolder(View itemView) {
        super(itemView);

        imgMain = (ImageView)itemView.findViewById(R.id.img_main);
        txtText01 = (TextView)itemView.findViewById(R.id.txt_text01);
        txtText02 = (TextView)itemView.findViewById(R.id.txt_text02);

    }
}
