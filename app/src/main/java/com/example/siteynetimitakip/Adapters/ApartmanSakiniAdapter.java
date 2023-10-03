package com.example.siteynetimitakip.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.siteynetimitakip.Entity.ApartmanSakini;
import com.example.siteynetimitakip.R;

import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;


public class ApartmanSakiniAdapter extends RecyclerView.Adapter<ApartmanSakiniAdapter.ViewHolder> {

    private ArrayList<ApartmanSakini> apartmanSakiniItemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ApartmanSakini item);
    }

    public ApartmanSakiniAdapter(ArrayList<ApartmanSakini> apartmanSakiniItemList ,OnItemClickListener listener) {
        this.apartmanSakiniItemList = apartmanSakiniItemList;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        android.view.View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.apartman_sakini_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        ApartmanSakini apartmanSakini = apartmanSakiniItemList.get(position);

        holder.apartmanSakiniTextView.setText(apartmanSakini.getAll());

        holder.bind(apartmanSakiniItemList.get(position), (OnItemClickListener) listener);
    }

    @Override
    public int getItemCount() {
        return apartmanSakiniItemList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView apartmanSakiniTextView;

        public ViewHolder(android.view.View itemView) {
            super(itemView);

            apartmanSakiniTextView = itemView.findViewById(R.id.apartmanSakiniTextView);
        }


        public void bind(final ApartmanSakini item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }



}
