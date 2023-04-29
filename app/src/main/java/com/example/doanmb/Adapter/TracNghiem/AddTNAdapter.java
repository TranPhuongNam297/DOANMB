package com.example.doanmb.Adapter.TracNghiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;

import java.util.ArrayList;

public class AddTNAdapter extends RecyclerView.Adapter<AddTNAdapter.MultipleChoiceVH> implements Filterable {
    Context context;
    ArrayList<MultipleChoice> multipleChoices;
    ArrayList<MultipleChoice> multipleChoicesFilter;

    Listener listener;

    public AddTNAdapter(Context context, ArrayList<MultipleChoice> multipleChoices, Listener listener) {
        this.context = context;
        this.multipleChoices = multipleChoices;
        this.multipleChoicesFilter = multipleChoices;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public MultipleChoiceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowtracnghiem, parent,false);
        return new MultipleChoiceVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleChoiceVH holder, int position) {
        MultipleChoice multipleChoice= multipleChoicesFilter.get(position);
        holder.tv_Cau_HoiTN.setText(multipleChoice.getCau_Hoi());
        holder.tv_Dap_An_1.setText(multipleChoice.getDap_An_1());
        holder.tv_Dap_An_2.setText(multipleChoice.getDap_An_2());
        holder.tv_Dap_An_3.setText(multipleChoice.getDap_An_3());
        holder.tv_Dap_An_4.setText(multipleChoice.getDap_An_4());
        holder.tv_Dap_An_Dung_TN.setText(multipleChoice.getDap_An_Dung());
        holder.tv_Muc_Do_TN.setText(multipleChoice.getMuc_Do());
    }


    @Override
    public int getItemCount() {
        return multipleChoicesFilter.size();
    }




    public class MultipleChoiceVH extends RecyclerView.ViewHolder{
        TextView tv_Cau_HoiTN, tv_Dap_An_1, tv_Dap_An_2, tv_Dap_An_3, tv_Dap_An_4, tv_Dap_An_Dung_TN, tv_Muc_Do_TN;
        public MultipleChoiceVH(@NonNull View itemView) {
            super(itemView);
            tv_Cau_HoiTN = itemView.findViewById(R.id.tv_Cau_Hoi_DT);
            tv_Dap_An_1 = itemView.findViewById(R.id.tv_Dap_An_DT);
            tv_Dap_An_2 = itemView.findViewById(R.id.tv_Muc_Do_DT);
            tv_Dap_An_3 = itemView.findViewById(R.id.tv_Dap_An_3);
            tv_Dap_An_4 = itemView.findViewById(R.id.tv_Dap_An_4);
            tv_Dap_An_Dung_TN = itemView.findViewById(R.id.tv_Dap_An_Dung_TN);
            tv_Muc_Do_TN = itemView.findViewById(R.id.tv_Muc_Do_TN);
        }
    }

    public interface Listener{

        void OnItemListener(int pos, Vocab contact);
    }
}
