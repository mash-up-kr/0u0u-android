package kr.ac.mashup.kongukongu.kongukongu.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.ac.mashup.kongukongu.kongukongu.R;

/**
 * Created by owner on 2016-08-27.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    ArrayList<HomeItemData> items = new ArrayList<>();

    public HomeAdapter(ArrayList<HomeItemData> items) {
        this.items = items;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_recycler, parent, false);

        HomeViewHolder viewHolder = new HomeViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.imgMain.setImageResource(items.get(position).getImgMain());
        holder.txtText01.setText(items.get(position).getText01());
        holder.txtText02.setText(items.get(position).getTextt02());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
