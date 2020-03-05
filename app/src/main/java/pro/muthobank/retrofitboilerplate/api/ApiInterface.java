package pro.muthobank.retrofitboilerplate.api;

import okhttp3.ResponseBody;
import pro.muthobank.retrofitboilerplate.model.PostRegModel;
import pro.muthobank.retrofitboilerplate.model.PostSubscribe;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiInterface {
//
//    @POST(HttpParams.API_REGISTRATION)
//    Call<RegPostResponse> postReg(@Body RegistrationPostModel postModel);

    @POST(HttpParams.API_REGISTRATION)
    Call<ResponseBody> postReg(@Body PostRegModel postModel);

    @POST(HttpParams.API_SUBSCRIBER)
    Call<ResponseBody> postSubscribe(@Body PostSubscribe postSubscribe);
}
