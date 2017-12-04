package wachi.adoptiontest.activity;

import android.os.Bundle;
import android.widget.TextView;

import wachi.adoptiontest.R;
import wachi.adoptiontest.fragment.BaseFragment;
import wachi.adoptiontest.fragment.HomeFragment;
import wachi.adoptiontest.interfaces.OnFragmentFunListener;

public class MainActivity extends BaseActivity implements OnFragmentFunListener{
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findView() {
        title = findViewById(R.id.title);
    }

    @Override
    protected void setupViewComponent() {
        HomeFragment fragment = new HomeFragment();
        fragment.setOnFragmentFunListener(this);
        getFragmentManager().beginTransaction()
            .add(R.id.frame, fragment)
            .commit();
    }

    @Override
    public void startNewFragment(BaseFragment fragment) {
        fragment.setOnFragmentFunListener(this);
        getFragmentManager().beginTransaction()
            .addToBackStack(fragment.getClass().getSimpleName())
            .replace(R.id.frame, fragment, fragment.getClass().getSimpleName())
            .commit();
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void popBackStack() {
        getFragmentManager().popBackStackImmediate();
    }
}
