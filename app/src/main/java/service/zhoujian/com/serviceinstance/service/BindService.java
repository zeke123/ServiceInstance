package service.zhoujian.com.serviceinstance.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by zhoujian on 2016/11/10.
 */

public class BindService  extends Service
{

    private MyBinder binder = new MyBinder();
    private int  count;
    private boolean quit;
    public class MyBinder extends Binder{
        public int getCount(){
            return count;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread()
        {
            @Override
            public void run()
            {
                while (!quit)
                {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                    }
                    count++;
                }
            }
        }.start();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        quit=true;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

}
