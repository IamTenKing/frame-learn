package com.example.framelearn.retrofit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author jt
 * @date 2020-8-14
 */
@Slf4j
public class Test {

    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8088/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ShopService service = retrofit.create(ShopService.class);


//pageSize = 10,curPage=1
//        Call<ShopBean> callShops = service.getShop(10,1);
        Call<ShopBean> shopBeanCall = service.pageByOptions();


        Response<ShopBean> execute = shopBeanCall.execute();
        System.out.println(execute.raw());
        ShopBean body = execute.body();
        System.out.println(body.getError_code()+" "+body.getReason());




//        System.out.println(objectResponseEntity.toString());

//        responseEntityCall.enqueue(new Callback<ResponseEntity<ShopBean>>() {
//            @Override
//            public void onResponse(Call<ResponseEntity<ShopBean>> call, Response<ResponseEntity<ShopBean>> response) {
//                log.info("response",response.toString());
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseEntity<ShopBean>> call, Throwable t) {
//               t.printStackTrace();
//            }
//        });
    }



}
