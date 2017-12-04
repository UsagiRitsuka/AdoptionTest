package wachi.adoptiontest.fragment;

import android.view.ViewGroup;
import android.widget.Button;

import wachi.adoptiontest.R;

/**
 * Created by Usagi on 2017/12/1.
 */

public class HomeFragment extends BaseFragment{
    private Button enter;

    @Override
    public void onResume() {
        super.onResume();
        onFragmentFunListener.setTitle(getString(R.string.adoption));
    }

    @Override
    protected void findView(ViewGroup viewGroup) {
        enter = viewGroup.findViewById(R.id.enter);
    }

    @Override
    protected void setupViewComponent() {
        enter.setOnClickListener(view -> onFragmentFunListener.startNewFragment(new CountryFragment()));
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_home;
    }
}
