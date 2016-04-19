package kf.qf.com.fgongpermisssion;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;


/**
 * Created by 84903 on 2016/4/18.
 */
public class MyServer  extends Service{
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showDialog();
       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog();
            }
        }, 0);*/

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dialogIntent = new Intent(MyServer.this, MainActivity.class);
                dialogIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
            }
        }, 1000);*/
        return START_STICKY;
    }

    private void showDialog() {
        final CustomDialog builder = new CustomDialog(getApplicationContext());
        builder.setTitle("Title");
        //方法名是自定义的 理解成跳转主界面就好
        //自定义的dialog，调用自定义dialog中定义的监听方法
        builder.setLocalUpDownListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("rr", "跳转主界面");

                intentToMainHome();
                builder.dismiss();
            }
        });
        //系统关机就是对话框就是这种属性
        builder.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        builder.show();
    }
    //跳转主界面的意图
    private void intentToMainHome() {
        Intent intent=new Intent(this,Main2Activity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, MyServer.class));
    }

}
