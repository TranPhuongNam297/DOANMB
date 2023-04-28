package com.example.doanmb.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.ActivityAddList;
import com.example.doanmb.Activity.ActivityAddListDT;
import com.example.doanmb.Activity.ActivityAddListTN;
import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;

import java.util.ArrayList;

public class AddFillBlanksAdapter extends RecyclerView.Adapter<AddFillBlanksAdapter.FillBlanksVH> implements Filterable {
    Context context;
    ArrayList<FillBlanks> fillBlanks;
    ArrayList<FillBlanks> fillBlanksFilter;

    Listener listener;

    public AddFillBlanksAdapter(Context context, ArrayList<FillBlanks> fillBlanks, Listener listener) {
        this.context = context;
        this.fillBlanks = fillBlanks;
        this.fillBlanksFilter=  fillBlanks;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public FillBlanksVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowaddmucdoddt, parent,false);
        return new FillBlanksVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FillBlanksVH holder, int position) {
        FillBlanks fillBlanks =  fillBlanksFilter.get(position);
        holder.btn_MucDoDT.setText(fillBlanks.getMuc_Do());
        holder.btn_MucDoDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityAddListDT.class);
                intent.putExtra("Muc_DoDT", fillBlanks.getMuc_Do());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return fillBlanksFilter.size();
    }




    public class FillBlanksVH extends RecyclerView.ViewHolder{
        Button btn_MucDoDT;
        public FillBlanksVH(@NonNull View itemView) {
            super(itemView);
            btn_MucDoDT = itemView.findViewById(R.id.btn_mucdodt);
        }
    }

    public interface Listener{

        void OnItemListener(int pos, Vocab contact);
    }
}
