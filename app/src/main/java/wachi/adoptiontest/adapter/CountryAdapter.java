package wachi.adoptiontest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wachi.adoptiontest.R;
import wachi.adoptiontest.interfaces.OnCountryClickedListener;
import wachi.adoptiontest.pojo.CountryInfo;

/**
 * Created by Usagi on 2017/12/3.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>{
    private List<CountryInfo> countryInfoList;
    private OnCountryClickedListener listener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CountryInfo countryInfo = countryInfoList.get(position);
        holder.name.setText(countryInfo.getName());
        holder.root.setOnClickListener(view -> {
            if(listener != null){
                listener.onCounterClicked(countryInfo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryInfoList == null ? 0 : countryInfoList.size();
    }

    public void setCountryInfoList(List<CountryInfo> countryInfoList) {
        this.countryInfoList = countryInfoList;
    }

    public void setListener(OnCountryClickedListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public View root;
        public ViewHolder(View view){
            super(view);
            root = view;
            name = view.findViewById(R.id.country_name);
        }
    }
}
