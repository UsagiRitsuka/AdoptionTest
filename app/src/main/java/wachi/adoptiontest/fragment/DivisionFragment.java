package wachi.adoptiontest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;

import wachi.adoptiontest.R;
import wachi.adoptiontest.adapter.DivisionAdapter;
import wachi.adoptiontest.pojo.CountryInfo;

/**
 * Created by Usagi on 2017/12/3.
 */

public class DivisionFragment extends BaseFragment{
    final private String TAG = CountryFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private DivisionAdapter adapter;
    private CountryInfo countryInfo;

    @Override
    public void onResume() {
        super.onResume();
        onFragmentFunListener.setTitle(countryInfo.getName() + "\n" + getString(R.string.division_list_text));
    }

    @Override
    protected void findView(ViewGroup viewGroup) {
        recyclerView = viewGroup.findViewById(R.id.recycler_view);
    }

    @Override
    protected void setupViewComponent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DivisionAdapter();
        adapter.setDivisionList(countryInfo.getDivisions());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_division;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }
}
