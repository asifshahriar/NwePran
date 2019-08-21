package com.example.myproject1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public static ClickListener clickListener;
    Context context;
    String[] memberNames,memberDesc;
    int[] images;

    public MyAdapter(Context context, String[] memberNames, String[] memberDesc, int[] images) {
        this.context = context;
        this.memberNames = memberNames;
        this.memberDesc = memberDesc;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.name.setText(memberNames[i]);
        holder.desc.setText(memberDesc[i]);
        holder.images.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return memberNames.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, desc;
        ImageView images;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTextViewId);
            desc = itemView.findViewById(R.id.descTextViewId);
            images = itemView.findViewById(R.id.imageViewId);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);
        }
    }

    public interface ClickListener{
        void onItemClick(int position, View v);
    }
    public void setOnItemClickListener(ClickListener clickListener){
        MyAdapter.clickListener = clickListener;
    }

}
