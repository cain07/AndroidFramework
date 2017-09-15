package com.cain.af.model;

import com.cain.af.api.MailService;
import com.cain.af.api.utils.ServiceGenerator;
import com.cain.af.domain.MainVo;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * model 层
 *
 */
public class MailModel {

    private static MailModel instance;
    private MailService service;
    private static boolean DEMO_FLAG = false;

    public MailModel() {
        service = ServiceGenerator.createService(MailService.class);
    }


    synchronized public static MailModel getInstance() {
        if (instance == null) {
            synchronized (MailModel.class) {
                if (instance == null) {
                    instance = new MailModel();
                }
            }
        }
        return instance;
    }


    /**
     *
     *
     * @param
     * @return
     */

    public Flowable<MainVo> getkuaiDiObS(String ems,String postid){

        return service.getkuaiDiObS(ems,postid).subscribeOn(Schedulers.io());

    }
    public Observable<MainVo> getkuaiDiObSe( String ems,String postid) {
        Observable<MainVo> observable = null;
        if (DEMO_FLAG) {
            /*BaseEntity<BMTargetContainerData> entity = new BaseEntity<>();
            entity.setError_code(ConstantValues.RESULT_OK);
            BMTargetContainerData data = new BMTargetContainerData();
            data.setBindLocation("CL-01-1-01");
            entity.setData(data);
            observable = RxUtils.demo(entity);*/
        } else {
            observable = service.getkuaiDiObSe(ems,postid);
        }
        return observable.subscribeOn(Schedulers.io());
    }



}
