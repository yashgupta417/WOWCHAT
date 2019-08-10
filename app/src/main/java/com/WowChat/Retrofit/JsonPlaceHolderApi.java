package com.WowChat.Retrofit;



import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @POST("login/")
    Call<User> loginAndGetToken(@Body User user);

    @POST("signup/")
    Call<User> signUp(@Body User user);

    @POST("logout/{id}/")
    Call<User> logout(@Path("id") String id);

    @GET("user_detail/{username}")
    Call<User> searchByUsername(@Path("username") String username);

    @GET("get_last_seen/")
    Call<User> getLastSeen(@Query("username") String username);

    @Multipart
    @PATCH("user_detail/{username}/")
    Call<User> updateProfileImage(@Path("username") String username, @Part MultipartBody.Part image);


    @PATCH("user_detail/{username}/")
    Call<User> updateLastSeen(@Body User user,@Path("username") String username);

    @POST("message_list/")
    Call<Message> sendMessage(@Body Message message);

    @POST("create_fcm_token/")
    Call<FCMToken> createFCMToken(@Body FCMToken fcmToken);

    @PATCH("update_fcm_token/")
    Call<FCMToken> updateFCMToken(@Query("registration_id") String registration_id, @Query("user") String user);

    @GET("shot_list/")
    Call<List<Shot>> getShots(@Query("id_me") String id_me, @Query("id_friend") String id_friend);

    @Multipart
    @POST("shot_list/")
    Call<Shot_Write> uploadShot(@Part("title") RequestBody title,
                                @Part("text") RequestBody text,
                                @Part("by") RequestBody by,
                                @Part("to") RequestBody to,
                                @Part MultipartBody.Part image);

    @POST("update_message_status/")
    Call<Message> updateMessageStatus(@Query("id")String id,@Query("status") String status);
}
