package service.zhoujian.com.serviceinstance.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by zhoujian on 2016/11/10.
 *
 * 需要在清单文件中配置
 *
 *
 * Android中有两种方式开启服务
 *
 * （1） 通过startService（）方法启动的Service，访问者与Service之间没有关联，即访问者退出了，Sevice仍在运行
 *
 *       生命周期：onCreate（）--->onStartCommand()----->onDestroy()
 *
 * （2）  通过bindService（）方法启动Service，访问者与Sevice绑定在一起，访问者一旦退出，Sevice也就终止了
 *
 *       生命周期：onCreate（）--->onBind()----->onUnbind------>onDestroy()
 *
 *
 */

public class FirstService extends Service {

    private static final String TAG = "FirstService";

    //必须实现的方法,可以通过该对象与Service组件通信
    @Override
    public IBinder onBind(Intent intent) {

        Log.e(TAG, "onBind()方法执行了");

        return null;
    }

    //Service第一次创建后回调此方法
    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG, "onCreate()方法执行了");
    }

    //每次调用startService方法时，都会调用此方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e(TAG, "onStartCommand()方法执行了");
        return super.onStartCommand(intent, flags, startId);


    }

    //Service被关闭时回调此方法
    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "onDestroy()方法执行了");
    }


    //当该Service上绑定的所有客户端都断开连接时会调用该方法
    @Override
    public boolean onUnbind(Intent intent) {


        Log.e(TAG, "onUnbind()方法执行了");

        return super.onUnbind(intent);
    }
}
