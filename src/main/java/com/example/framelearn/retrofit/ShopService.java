package com.example.framelearn.retrofit;

import org.springframework.http.ResponseEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author jt
 * @date 2020-8-14
 */
public interface ShopService {

    @GET("/course_api/wares/hot")
    Call<ShopBean> getShop(@Query("pageSize") int pageSize,
                           @Query("curPage") int curPage);

    @GET("/pageByOptions")
    Call<ShopBean> pageByOptions();



}
