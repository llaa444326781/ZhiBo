package com.hoarse.library.mvp;

import com.hoarse.library.base.MyApplication;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.ResponseBean;
import com.hoarse.library.net.RetrofitHelper;

import java.net.SocketTimeoutException;
import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BaseModel<E> implements IBaseModel {
    private Retrofit mRetrofit;

    @Override
    public void onStart() {
        mRetrofit = RetrofitHelper.getRetrofit(MyApplication.getMyApplication().getBaseUrl());
    }
    protected E api;
    private Subscription mSubscription;
    public void setApi(E api) {
        this.api = api;
    }

    public E getApi() {
        return api;
    }
    protected Observable threadControl(Observable observable){
        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    protected Subscription subscribe(Observable observable,
                                     final ICallback callback){
        return observable
                .subscribe(new Subscriber<ResponseBean>() {
                    @Override

                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callback!=null){
                            if(e instanceof SocketTimeoutException)
                                callback.onFailed("服务器异常");
                            else
                                callback.onFailed(e.getMessage());
                        }

                    }
                    @Override
                    public void onNext(ResponseBean response) {
                        if(callback!=null) {
                            callback.onCompleted(response);
                        }
                    }
                });
    }

    protected Subscription deploy(Observable observable, final ICallback callback){
        mSubscription = subscribe(threadControl(observable),callback);
        return mSubscription;
    }
    protected Subscription subscribe1(Observable observable,
                                     final ICallback callback){
        return observable
                .subscribe(new Subscriber<List<ResponseBean>>() {
                    @Override

                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callback!=null){
                            if(e instanceof SocketTimeoutException)
                                callback.onFailed("服务器异常");
                            else
                                callback.onFailed(e.getMessage());
                        }

                    }
                    @Override
                    public void onNext(List<ResponseBean> response) {
                        if(callback!=null) {
                            callback.onCompleted(response);
                        }
                    }
                });
    }

    protected Subscription deploy1(Observable observable, final ICallback callback){
        mSubscription = subscribe1(threadControl(observable),callback);
        return mSubscription;
    }

    @Override
    public void onDestroy() {
        if (null != mSubscription && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
            mRetrofit = null;
        }
    }
}
