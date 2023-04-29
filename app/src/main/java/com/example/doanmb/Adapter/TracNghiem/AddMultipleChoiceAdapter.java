package com.example.doanmb.Adapter.TracNghiem;

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

import com.example.doanmb.Activity.Admin.TracNghiem.ActivityAddListTN;
import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;

import java.util.ArrayList;

public class AddMultipleChoiceAdapter extends RecyclerView.Adapter<AddMultipleChoiceAdapter.MultipleChoiceVH> implements Filterable {
    Context context;
    ArrayList<MultipleChoice> multipleChoices;
    ArrayList<MultipleChoice> multipleChoicesFilter;

    Listener listener;

    public AddMultipleChoiceAdapter(Context context, ArrayList<MultipleChoice> multipleChoices, Listener listener) {
        this.context = context;
        this.multipleChoices = multipleChoices;
        this.multipleChoicesFilter =  multipleChoices;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public MultipleChoiceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_mucdotracnghiemadd, parent,false);
        return new MultipleChoiceVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleChoiceVH holder, int position) {
        MultipleChoice multipleChoice =  multipleChoicesFilter.get(position);
        holder.btn_MucDo.setText(multipleChoice.getMuc_Do());
        holder.btn_MucDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityAddListTN.class);
                intent.putExtra("Muc_Do", multipleChoice.getMuc_Do());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return multipleChoicesFilter.size();
    }




    public class MultipleChoiceVH extends RecyclerView.ViewHolder{
        Button btn_MucDo;
        public MultipleChoiceVH(@NonNull View itemView) {
            super(itemView);
            btn_MucDo = itemView.findViewById(R.id.btn_MucDo);
        }
    }

    public interface Listener{

        void OnItemListener(int pos, Vocab contact);
    }
}
