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

    @FormUrlEncoded
    @POST("user/info")
    Call<ServerUserResult> userInfo(@Field("user_kakao_id") String kakaoID);

    @FormUrlEncoded
    @POST("content/write")
    Call<ServerBoolResult> writeContent(
            @Field("contents_title") String contentTitle,
            @Field("contents_image") String contentImage,
            @Field("contents_description") String contentDescription,
            @Field("contents_status") int contentsStatus,
            @Field("contents_owner") String contentOwner);
}
