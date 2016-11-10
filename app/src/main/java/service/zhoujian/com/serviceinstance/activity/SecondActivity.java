package service.zhoujian.com.serviceinstance.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import service.zhoujian.com.serviceinstance.R;

/**
 * Created by zhoujian on 2016/11/10.
 */

public class SecondActivity extends Activity {

    @InjectView(R.id.bind_service)
    Button mBindService;
    @InjectView(R.id.unbind_service)
    Button mUnbindService;
    @InjectView(R.id.bind_state)
    Button mBindState;

    //option+command+k   对生命周期方法进行排序


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.inject(this);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
