package wachi.adoptiontest.activity;

import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import wachi.adoptiontest.pojo.Constant;

/**
 * Created by Usagi on 2017/12/1.
 */

abstract public class BaseActivity extends AppCompatActivity {
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        findView();
        setupViewComponent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Constant.SCREEN_HEIGHT == -1 || Constant.SCREEN_WIDTH == -1){
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            Constant.SCREEN_HEIGHT = dm.heightPixels;
            Constant.SCREEN_WIDTH = dm.widthPixels;
        }
    }

    protected abstract void findView();
    protected abstract void setupViewComponent();
}
