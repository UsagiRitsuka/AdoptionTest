package wachi.adoptiontest.interfaces;

import wachi.adoptiontest.fragment.BaseFragment;

/**
 * Created by Usagi on 2017/12/1.
 */

public interface OnFragmentFunListener {
    void setTitle(String title);
    void startNewFragment(BaseFragment fragment);
    void popBackStack();
}
