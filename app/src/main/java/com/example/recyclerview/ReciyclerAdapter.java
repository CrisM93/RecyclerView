package com.example.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ReciyclerAdapter extends RecyclerView.Adapter<ReciyclerAdapter.NumerosViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;
    final private ListItemClick listItemClick;

    public ReciyclerAdapter(List<ListElement> itemList, Context context, ListItemClick mlistItemClick) {
        this.mInflater = LayoutInflater.from(context);
        this.listItemClick = mlistItemClick;
        this.context = context;
        this.mData = itemList;
    }

    public interface ListItemClick {
        void onListItemClick(int clickedItem);
    }

    @NonNull
    @Override
    public NumerosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflar lista de
        View view = mInflater.inflate(R.layout.list_cards_row, null);
        return new NumerosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumerosViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {//cantadiad de paraemtrosde RV
        return mData.size();
    }

    public void setItems(List<ListElement> items) {
        mData = items;
    }

    public class NumerosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {//vista de cada elemento de nuestro reclyclerView
        TextView name, city, status;
        ImageView iconImage;

        public NumerosViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconimageView);
            name = itemView.findViewById(R.id.nameTextView);
            city = itemView.findViewById(R.id.cityTextView);
            status = itemView.findViewById(R.id.statusTextView);
            itemView.setOnClickListener(this);
        }

        void bindData(final ListElement items) {
            iconImage.setColorFilter(Color.parseColor(items.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(items.getName());
            city.setText(items.getCity());
            status.setText(items.getStatus());
        }

        @Override
        public void onClick(View v) {
            int clickedItem = getAdapterPosition();
            listItemClick.onListItemClick(clickedItem);

        }
    }

}
