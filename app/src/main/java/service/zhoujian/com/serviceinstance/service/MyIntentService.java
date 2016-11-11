package service.zhoujian.com.serviceinstance.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by zhoujian on 2016/11/11.
 *
 */

    //IntentService  使用新的工作线程来处理Intent请求，IntentSevice不会阻塞主线程，可以自己处理耗时任务
    //最重要的一个方法onHandleIntent（）
    //IntentService会创建单独的worker线程来处理所有的Intent请求
    //IntentService会创建单独的worker线程来处理onHandleIntent（）方法实现的代码，无需考虑多线程问题
    //当所有请求处理完成后，ntentService会自动停止，无需调用stopSelf（）方法来停止该Service


public class MyIntentService extends IntentService
{

    private long mLong;

    public  MyIntentService()
    {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        //模拟耗时任务，让线程暂停20s
        //这段代码要是放在普通Service中会阻塞主线程。ANR异常，放在IntentSevice中不会有问题
        mLong = System.currentTimeMillis() + 20 * 1000;
        while (System.currentTimeMillis()<mLong)
        {
            synchronized (this)
            {
                try
                {
                    //线程等待20秒
                    wait(mLong-System.currentTimeMillis());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
