package service.zhoujian.com.serviceinstance.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by zhoujian on 2016/11/10.
 */

public class BindService  extends Service{


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


}
