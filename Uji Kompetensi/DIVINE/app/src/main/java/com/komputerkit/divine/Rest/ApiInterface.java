package com.komputerkit.divine.Rest;

import com.komputerkit.divine.GetKategori;
import com.komputerkit.divine.GetModelhome;
import com.komputerkit.divine.GetModelmyads;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("/api/kategori")
    Call<GetKategori> GetKategori();
    @GET("/api/menu")
    Call<GetModelhome> GetModelhome();
    @GET("/api/menu")
    Call<GetModelmyads> GetModelmyads();
//    @FormUrlEncoded
//    @POST("kontak")
//    Call<PostPutDelKontak> postKontak(@Field("nama") String nama,
//                                      @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @PUT("kontak")
//    Call<PostPutDelKontak> putKontak(@Field("id") String id,
//                                     @Field("nama") String nama,
//                                     @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);
}

