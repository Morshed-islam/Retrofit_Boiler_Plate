package pro.muthobank.retrofitboilerplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.ResponseBody;
import pro.muthobank.retrofitboilerplate.api.ApiInterface;
import pro.muthobank.retrofitboilerplate.api.ApiUtils;
import pro.muthobank.retrofitboilerplate.model.PostRegModel;
import pro.muthobank.retrofitboilerplate.model.PostSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                postReg();

                postSubscribe();
            }
        });

    }

    private void postSubscribe() {


        PostSubscribe postSubscribe= new PostSubscribe("0122364324","morshed","islam","morsh777@gmail.com","dev","234000","24");
        ApiInterface apiInterface = ApiUtils.getApiInterface();
        Call<ResponseBody> call = apiInterface.postSubscribe(postSubscribe);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()){
                    try {
                        Log.i("DATA", "onResponse: success --"+response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    Log.i("DATA", "onResponse: Below --"+response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }


    private void postReg(){

        PostRegModel postRegModel = new PostRegModel("morshed","islam","mmm@gmail.com","029535823","11","1234");

        ApiInterface apiInterface = ApiUtils.getApiInterface();
        Call<ResponseBody> call = apiInterface.postReg(postRegModel);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()){
                    try {
                        Log.i("DATA", "onResponse: success --"+response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {

                    Log.i("DATA", "onResponse: Below --"+response.body());

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.i("DATA", "onResponse: Below --"+t.getMessage());

            }
        });

    }
}
