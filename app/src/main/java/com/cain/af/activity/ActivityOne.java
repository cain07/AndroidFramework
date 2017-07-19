package com.cain.af.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cain.af.R;
import com.cain.af.api.ApiService;
import com.cain.af.domain.MainVo;
import com.cain.af.model.MailModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityOne extends Activity implements View.OnClickListener {

    private static final String ENDPOINT = "http://www.kuaidi100.com/";

    protected CompositeDisposable subscriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        subscriptions = new CompositeDisposable();

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        switch (v.getId()) {
            case R.id.button1:
                Log.e("111","button1");

                Call<MainVo> call = apiService.getkuaiDi("ems","9745531155532");

                //Call<MainVo> call = apiService.getkuaiDiPost(new MailParam("ems","9745531155532"));
                call.enqueue(new Callback<MainVo>() {
                    @Override
                    public void onResponse(Call<MainVo> call, Response<MainVo> response) {
                        Log.e("MainActivity","----"+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<MainVo> call, Throwable t) {

                    }
                });

                break;

            case R.id.button2:
                //rxjava 写法
                apiService.getkuaiDiObSe("ems","9745531155532")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<MainVo>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(MainVo value) {
                                Log.e("onNext","----"+value.toString());
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

                break;
            case R.id.button3:

                //subscriptions.add(MailModel.getInstance().getkuaiDiObSe("ems","9745531155532")


                break;

        }
    }
}
