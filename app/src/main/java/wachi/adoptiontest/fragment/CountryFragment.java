package wachi.adoptiontest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wachi.adoptiontest.R;
import wachi.adoptiontest.adapter.CountryAdapter;
import wachi.adoptiontest.interfaces.OnCountryClickedListener;
import wachi.adoptiontest.manager.DataManager;
import wachi.adoptiontest.pojo.CountryInfo;

/**
 * Created by Usagi on 2017/12/1.
 */

public class CountryFragment extends BaseFragment implements OnCountryClickedListener{
    final private String TAG = CountryFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private CountryAdapter adapter;

    @Override
    public void onResume() {
        super.onResume();
        onFragmentFunListener.setTitle(getString(R.string.country_list_text));
    }

    @Override
    protected void findView(ViewGroup viewGroup) {
        recyclerView = viewGroup.findViewById(R.id.recycler_view);
    }

    @Override
    protected void setupViewComponent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CountryAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setListener(this);
        getData();
    }

    private void getData(){
        Flowable.just("")
            .map(non -> DataManager.getInstance().getRegionsData(getString(R.string.adoption_data)))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(regionsData ->{
                Log.v(TAG, "FIN");
                adapter.setCountryInfoList(regionsData.getRegions());
                adapter.notifyDataSetChanged();
            });
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_country;
    }

    @Override
    public void onCounterClicked(CountryInfo countryInfo) {
        DivisionFragment fragment = new DivisionFragment();
        fragment.setCountryInfo(countryInfo);
        onFragmentFunListener.startNewFragment(fragment);
    }
}
