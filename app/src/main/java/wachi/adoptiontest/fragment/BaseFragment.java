package wachi.adoptiontest.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wachi.adoptiontest.interfaces.OnFragmentFunListener;

/**
 * Created by Usagi on 2017/12/1.
 */

abstract public class BaseFragment extends Fragment{
    private ViewGroup container;
    protected OnFragmentFunListener onFragmentFunListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(this.container == null){
            this.container = (ViewGroup) inflater.inflate(getResId(), null, false);
            findView(this.container);
            setupViewComponent();
        } else{
            ViewGroup viewGroup = (ViewGroup) this.container.getParent();
            if(viewGroup != null) {
                viewGroup.removeView(this.container);
            }
        }


        return this.container;
    }

    public void setOnFragmentFunListener(OnFragmentFunListener onFragmentFunListener) {
        this.onFragmentFunListener = onFragmentFunListener;
    }

    protected abstract int getResId();
    protected abstract void findView(ViewGroup viewGroup);
    protected abstract void setupViewComponent();

}
