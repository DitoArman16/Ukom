package com.komputerkit.divine.Regristasi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/api/login")
    Call<LoginResponse> loginuser(@Body LoginRequest loginRequest);
    @POST("/api/register")
    Call<RegisterResponse> registerusers(@Body RegisterRequest registerRequest);
    @POST("/api/register")
    Call<LupapassResponse> lupapassuser(@Body LupapassRequest lupapassRequest);

}
