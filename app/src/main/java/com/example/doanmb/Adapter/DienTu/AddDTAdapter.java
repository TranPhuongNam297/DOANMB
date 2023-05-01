package com.example.doanmb.Adapter.DienTu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.Admin.DienTu.ActivityFormDt;
import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;

import java.util.ArrayList;

public class AddDTAdapter extends RecyclerView.Adapter<AddDTAdapter.FillBlanksVH> implements Filterable {
    Context context;
    ArrayList<FillBlanks> fillBlanks;
    ArrayList<FillBlanks> fillBlanksFilter;

    Listener listener;

    public AddDTAdapter(Context context, ArrayList<FillBlanks> fillBlanks, Listener listener) {
        this.context = context;
        this.fillBlanks = fillBlanks;
        this.fillBlanksFilter = fillBlanks;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public FillBlanksVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowdientuadmin, parent,false);
        return new FillBlanksVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FillBlanksVH holder, int position) {
        FillBlanks fillBlanks =  fillBlanksFilter.get(position);
        holder.tv_CauHoi_DT.setText(fillBlanks.getCau_Hoi());
        holder.tv_Muc_Do_DT.setText(fillBlanks.getMuc_Do());
        holder.tv_Dap_An_DT.setText(fillBlanks.getDap_An());
        holder.btn_editt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, ActivityFormDt.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID",fillBlanks.getId());
                bundle.putString("Cau_Hoi",fillBlanks.getCau_Hoi());
                bundle.putString("Dap_An",fillBlanks.getDap_An());
                bundle.putString("Muc_Do",fillBlanks.getMuc_Do());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.btn_dell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnDeleteListener(fillBlanks);
            }
        });
    }



    @Override
    public int getItemCount() {
        return fillBlanksFilter.size();
    }




    public class FillBlanksVH extends RecyclerView.ViewHolder{
        TextView tv_CauHoi_DT, tv_Dap_An_DT, tv_Muc_Do_DT;
        ImageView btn_editt,btn_dell;
        public FillBlanksVH(@NonNull View itemView) {
            super(itemView);
            tv_CauHoi_DT = itemView.findViewById(R.id.tv_Cau_Hoi_DT);
            tv_Dap_An_DT = itemView.findViewById(R.id.tv_Dap_An_DT);
            tv_Muc_Do_DT = itemView.findViewById(R.id.tv_Muc_Do_DT);
            btn_editt = itemView.findViewById(R.id.btn_editt);
            btn_dell = itemView.findViewById(R.id.btn_dell);
        }
    }

    public interface Listener{

        void OnItemListener(int pos, FillBlanks fillBlanks);
        void OnDeleteListener(FillBlanks fillBlanks);
    }
}
