package cn.jiangzehui.www.retrofittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<HttpService.Result.result.data> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this, WebActivity.class).putExtra("url", list.get(i).url));
            }
        });


        try {

            textGet();
           // textGet_query();
            //textGet_queryMap();
            //textPost_query();
            // textPost_formUrlEncoded();
            // textPost_formUrlEncoded_map();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //http://v.juhe.cn/toutiao/index?type=top&key=9e05423f7ac6acf6d0dce3425c4ea9fe
    void textGet() throws IOException {

        Api.getInstance().getService().testHttpGet().enqueue(new Callback<HttpService.Result>() {
            @Override
            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
                list = response.body().result.getData();
                updateUi();

            }

            @Override
            public void onFailure(Call<HttpService.Result> call, Throwable t) {
                Log.d("xxx", t.getMessage());
            }
        });

    }



    void textGet_query() throws IOException {
        Api.getInstance().getService().testHttpGet_query("top", "9e05423f7ac6acf6d0dce3425c4ea9fe").enqueue(new Callback<HttpService.Result>() {
            @Override
            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
                list = response.body().result.getData();
                updateUi();

            }

            @Override
            public void onFailure(Call<HttpService.Result> call, Throwable t) {
                Log.d("xxx", t.getMessage());
            }
        });


    }


    void textGet_queryMap() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/toutiao/").addConverterFactory(GsonConverterFactory.create()).build();
        HttpService service = retrofit.create(HttpService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("type", "top");
        map.put("key", "9e05423f7ac6acf6d0dce3425c4ea9fe");
        Call<HttpService.Result> call = service.testHttpGet_queryMap(map);
        call.enqueue(new Callback<HttpService.Result>() {
            @Override
            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
                list = response.body().result.getData();
                updateUi();

            }

            @Override
            public void onFailure(Call<HttpService.Result> call, Throwable t) {
                Log.d("xxx", t.getMessage());
            }
        });

    }


    //POST


    void textPost_query() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/toutiao/").addConverterFactory(GsonConverterFactory.create()).build();
        HttpService service = retrofit.create(HttpService.class);

        Call<HttpService.Result> call = service.testHttpPost_query("top", "9e05423f7ac6acf6d0dce3425c4ea9fe");
        call.enqueue(new Callback<HttpService.Result>() {
            @Override
            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
                list = response.body().result.getData();
                updateUi();

            }

            @Override
            public void onFailure(Call<HttpService.Result> call, Throwable t) {
                Log.d("xxx", t.getMessage());
            }
        });

    }


    void textPost_formUrlEncoded() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/toutiao/").addConverterFactory(GsonConverterFactory.create()).build();
        HttpService service = retrofit.create(HttpService.class);

        Call<HttpService.Result> call = service.testHttpPost_formUrlEncoded("top", "9e05423f7ac6acf6d0dce3425c4ea9fe");
        call.enqueue(new Callback<HttpService.Result>() {
            @Override
            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
                list = response.body().result.getData();
                updateUi();

            }

            @Override
            public void onFailure(Call<HttpService.Result> call, Throwable t) {
                Log.d("xxx", t.getMessage());
            }
        });

    }


    void textPost_formUrlEncoded_map() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/toutiao/").addConverterFactory(GsonConverterFactory.create()).build();
        HttpService service = retrofit.create(HttpService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("type", "top");
        map.put("key", "9e05423f7ac6acf6d0dce3425c4ea9fe");
        Call<HttpService.Result> call = service.testHttpPost_formUrlEncoded_map(map);
        call.enqueue(new Callback<HttpService.Result>() {
            @Override
            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
                list = response.body().result.getData();
                updateUi();

            }

            @Override
            public void onFailure(Call<HttpService.Result> call, Throwable t) {
                Log.d("xxx", t.getMessage());
            }
        });

    }

    void textPost_formUrlEncoded_map_header() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/toutiao/").addConverterFactory(GsonConverterFactory.create()).build();
        HttpService service = retrofit.create(HttpService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("type", "top");
        map.put("key", "9e05423f7ac6acf6d0dce3425c4ea9fe");
        Call<HttpService.Result> call = service.testHttpPost_formUrlEncoded_map_header("Content-type:application/x-www-from-urlencoded;charset=UTF-8", map);
        call.enqueue(new Callback<HttpService.Result>() {
            @Override
            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
                list = response.body().result.getData();
                updateUi();

            }

            @Override
            public void onFailure(Call<HttpService.Result> call, Throwable t) {
                Log.d("xxx", t.getMessage());
            }
        });

    }

//接口不支持，此方法为模拟用法
//    void textPost_body() throws IOException {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/").addConverterFactory(GsonConverterFactory.create()).build();
//        HttpService service = retrofit.create(HttpService.class);
//
//        Call<HttpService.Result> call = service.testHttpPost_body(new HttpService.Params("top","9e05423f7ac6acf6d0dce3425c4ea9fe"));
//        call.enqueue(new Callback<HttpService.Result>() {
//            @Override
//            public void onResponse(Call<HttpService.Result> call, Response<HttpService.Result> response) {
//                Log.d("xxx", response.body().reason);
//            }
//
//            @Override
//            public void onFailure(Call<HttpService.Result> call, Throwable t) {
//
//            }
//        });
//
//    }


    void updateUi() {
        if (list != null) {
            lv.setAdapter(new MyAdapter());
        }
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Holder holder;
            if (view == null) {
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, viewGroup, false);
                holder = new Holder(view);
                view.setTag(holder);
            } else {
                holder = (Holder) view.getTag();
            }
            holder.tv_title.setText(list.get(i).title);
            holder.tv_date.setText(list.get(i).date);
            Picasso.with(MainActivity.this).load(list.get(i).thumbnail_pic_s).into(holder.iv);


            return view;
        }

        class Holder {
            TextView tv_title, tv_date;
            ImageView iv;

            public Holder(View view) {
                tv_title = (TextView) view.findViewById(R.id.tv_title);
                tv_date = (TextView) view.findViewById(R.id.tv_date);
                iv = (ImageView) view.findViewById(R.id.iv);
            }
        }
    }


}
