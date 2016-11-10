package service.zhoujian.com.serviceinstance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import service.zhoujian.com.serviceinstance.R;
import service.zhoujian.com.serviceinstance.service.FirstService;

public class MainActivity extends Activity {

    private Button mStartButton;
    private Button mStopButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //option+command+k   抽取变量
        mStartButton = (Button) findViewById(R.id.start_service);
        mStopButton = (Button) findViewById(R.id.stop_service);


        //开启服务的按钮
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //当第一次开启服务的时候，onCreate（）和onStartCommand（）方法都会被调用
                //当第二次点击的时候，只会调用onStartCommand（）方法
                intent = new Intent(MainActivity.this, FirstService.class);
                startService(intent);
            }
        });

        //停止服务的按钮
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //会调用onDestroy（）方法
                intent = new Intent(MainActivity.this, FirstService.class);
                stopService(intent);
            }
        });
    }
}
