package wachi.adoptiontest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wachi.adoptiontest.R;

/**
 * Created by Usagi on 2017/12/3.
 */

public class DivisionAdapter extends RecyclerView.Adapter<DivisionAdapter.ViewHolder>{
    private List<String> divisionList;

    @Override
    public DivisionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_division, null, false);
        return new DivisionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DivisionAdapter.ViewHolder holder, int position) {
        holder.name.setText(divisionList.get(position));
    }

    @Override
    public int getItemCount() {
        return divisionList == null ? 0 : divisionList.size();
    }

    public void setDivisionList(List<String> divisionList) {
        this.divisionList = divisionList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.divition_name);
        }
    }
}