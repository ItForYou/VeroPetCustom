package util.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SetRetrofit {
    public RetrofitService getRetrofitService(){
        //httpok 로그 보기
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //클라이언트 설정
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        //레트로핏 설정
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.dreamforone.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        return retrofitService;
    }
}
