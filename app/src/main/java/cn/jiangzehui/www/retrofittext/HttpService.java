package cn.jiangzehui.www.retrofittext;

import java.util.ArrayList;
import java.util.HashMap;


import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by jiangzehui on 16/10/17.
 */
public interface HttpService {
    @GET("index?type=top&key=9e05423f7ac6acf6d0dce3425c4ea9fe")
    Call<Result> testHttpGet();


    @GET("index")
    Call<Result> testHttpGet_query(@Query("type") String type, @Query("key") String key);


    @GET("index")
    Call<Result> testHttpGet_queryMap(@QueryMap HashMap<String, String> map);


    @POST("index")
    Call<Result> testHttpPost_query(@Query("type") String type, @Query("key") String key);


    @FormUrlEncoded
    @POST("index")
    Call<Result> testHttpPost_formUrlEncoded(@Field("type") String type, @Field("key") String key);

    @FormUrlEncoded
    @POST("index")
    Call<Result> testHttpPost_formUrlEncoded_map(@FieldMap HashMap<String, String> map);

    @Headers("Content-type:application/x-www-from-urlencoded;charset=UTF-8")
    @FormUrlEncoded
    @POST("index")
    Call<Result> testHttpPost_formUrlEncoded_map_headers(@FieldMap HashMap<String, String> map);


    @FormUrlEncoded
    @POST("index")
    Call<Result> testHttpPost_formUrlEncoded_map_header(@Header("Content-Type") String contentType, @FieldMap HashMap<String, String> map);

    //接口不支持，模拟用法
//    @POST("toutiao")
//    Call<Result> testHttpPost_body(@Body Params params);

//    class Params {
//        String type;
//        String key;
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getKey() {
//            return key;
//        }
//
//        public void setKey(String key) {
//            this.key = key;
//        }
//
//        public Params(String type, String key) {
//            this.type = type;
//            this.key = key;
//        }
//    }


    // GET GSON - BEAN
    class Result {
        String reason;
        result result;


        class result {
            public String stat;
            public ArrayList<data> data;

            public String getStat() {
                return stat;
            }

            public void setStat(String stat) {
                this.stat = stat;
            }

            public ArrayList<Result.result.data> getData() {
                return data;
            }

            public void setData(ArrayList<Result.result.data> data) {
                this.data = data;
            }

            class data {
                String title;
                String date;
                String author_name;
                String thumbnail_pic_s;
                String thumbnail_pic_s02;
                String url;
                String uniquekey;
                String type;
                String realtype;

            }
        }


    }
}
