package service.zhoujian.com.serviceinstance.activity;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import service.zhoujian.com.serviceinstance.R;
import service.zhoujian.com.serviceinstance.service.BindService;

/**
 * Created by zhoujian on 2016/11/10.
 */

public class SecondActivity extends Activity {

    private BindService.MyBinder mBinder;
    private Intent mIntent;
    @InjectView(R.id.bind_service)
    Button mBindService;
    @InjectView(R.id.unbind_service)
    Button mUnbindService;
    @InjectView(R.id.bind_state)
    Button mBindState;

    //option+command+k   对生命周期方法进行排序


    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            //服务连接
            mBinder = (BindService.MyBinder) binder;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //服务断开
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.inject(this);

        clickEvent();


    }

    private void clickEvent()
    {
        //绑定服务
        mBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntent = new Intent(SecondActivity.this, BindService.class);
                bindService(mIntent, conn, Service.BIND_AUTO_CREATE);

            }
        });

        //解除绑定
        mUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(conn!=null){
                    unbindService(conn);
                }
            }
        });

        //绑定状态
        mBindState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SecondActivity.this, "Service的count值为："+mBinder.getCount(), Toast.LENGTH_SHORT).show();

            }
        });
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
