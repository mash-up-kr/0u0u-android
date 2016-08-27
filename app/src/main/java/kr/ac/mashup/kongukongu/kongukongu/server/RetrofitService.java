package kr.ac.mashup.kongukongu.kongukongu.server;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("user/login")
    Call<ServerBoolResult> checkUser(@Field("user_kakao_id") String kakaoID);

    @FormUrlEncoded
    @POST("user/register")
    Call<ServerBoolResult> registerUser(
            @Field("user_kakao_id") String kakaoID,
            @Field("user_kakao_profileImage") String kakaoProfileImage,
            @Field("user_nickname") String nickname,
            @Field("user_region") int regionNum);
}
