package cn.jiangzehui.www.retrofittext;

import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by jiangzehui on 16/10/26.
 */
public class Api {
    private HttpService service;
    private static Api instances = new Api();
    private String uri = "http://v.juhe.cn/toutiao/";
    private Converter.Factory factory = GsonConverterFactory.create();


    public static Api getInstance() {

        return instances;
    }




    private Api() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(uri).addConverterFactory(factory).build();
        service = retrofit.create(HttpService.class);

    }

    public HttpService getService() {
        return service;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setFactory(Converter.Factory factory) {
        this.factory = factory;
    }

}
