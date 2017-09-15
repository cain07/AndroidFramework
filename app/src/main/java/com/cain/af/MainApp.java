package com.cain.af;

import android.app.Application;
import android.content.Context;


/**
 *
 */
public class MainApp extends Application {

    /**
     * ss
     */
    public static final  String DESTROY_MODEL_INSTANCE = "destroy_model_instance";
    private Context context = this;

    private static MainApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        LeakCanary.install(this);
        //LogUtils.setDefaultTag(BuildOptions.APP_TAG);
        //LogUtils.setContext(this);
        //LogUtils.updateLogFile();
      //  Stetho.initializeWithDefaults(this);
        //CommonUtils.setContext(this);
//        CrashHandler.getInstance().init(this);
        //NotificationUtil.init(this);
        /*try {
            RestUtil.init(getApplicationContext());
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e(e);
        }*/

        /*RxBus.getDefault().register(EventNaviLogin.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<EventNaviLogin>() {
                    @Override
                    public void call(EventNaviLogin event) {

                        setDialogWindow(event.getText(), new DialogInterface() {
                            @Override
                            public void onClickListener() {
                                Intent intent = new Intent(MainApp.this, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        });

                    }
                });
*/
        //手机版,二维码扫描功能执行初始化操作
       // ZXingLibrary.initDisplayOpinion(this);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public static MainApp getInstance() {
        return instance;
    }

}
