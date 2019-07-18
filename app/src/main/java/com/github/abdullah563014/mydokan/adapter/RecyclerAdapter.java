package com.github.abdullah563014.mydokan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.abdullah563014.mydokan.R;
import com.github.abdullah563014.mydokan.database.Task;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<Task> list;
    private static OnItemClickListner onItemClickListner;

    public RecyclerAdapter(Context context,List<Task> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_view_model,parent,false);
        return new MyViewHolder(view,list);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        List<Task> list;
        TextView textView;

        public MyViewHolder(@NonNull View view, List<Task> list) {
            super(view);

            this.list=list;
            textView=view.findViewById(R.id.recyclerViewViewModelTextViewId);
            textView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onItemClickListner.onClick(list.get(getAdapterPosition()));
        }
    }



    public interface OnItemClickListner{
        void onClick(Task task);
    }

    public void setOnItemClickListner(OnItemClickListner clickListner){
        onItemClickListner=clickListner;
    }
}
