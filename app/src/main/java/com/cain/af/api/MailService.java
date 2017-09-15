package com.cain.af.api;


import com.cain.af.api.param.MailParam;
import com.cain.af.domain.GetIpInfoResponseVo;
import com.cain.af.domain.MainVo;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by cain on 16/5/18.
 */
public interface MailService {

    @GET("service/getIpInfo.php")
    Call<GetIpInfoResponseVo> getIpInfo(@Query("ip") String ip);


    /**
     * http://www.kuaidi100.com/query?type=ems&postid=9745531155532
     * @param
     * @return
     */
    @GET("query")
    Call<MainVo> getkuaiDi(@Query("type") String ems, @Query("postid") String postid);

    @GET("query")
    Observable<MainVo> getkuaiDiObSe(@Query("type") String ems, @Query("postid") String postid);

    @GET("query")
    Flowable<MainVo> getkuaiDiObS(@Query("type") String ems, @Query("postid") String postid);


    @POST("query")
    Call<MainVo> getkuaiDiPost(@Body MailParam mailParam);








}
