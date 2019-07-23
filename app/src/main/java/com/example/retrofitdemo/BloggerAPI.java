package com.example.retrofitdemo;

import android.content.ClipData;

import java.security.Key;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class BloggerAPI {
    public static final String key="AIzaSyAXbO-BzkqzcFX8wKZfuX9QX4u15fO_UxE";
    public static final String url="https://www.googleapis.com/blogger/v3/blogs/1150475271359553464/";

    public static PostService postService=null;//singleton method ha just 1 dfa he bny ga
    public static PostService getService()
    {
        if(postService==null)
        {
            Retrofit retrofit=new Retrofit.Builder()//retrofit object bnany k liye builder use hota
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService=retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService
    {
        @GET("?Key="+key)
       Call<PostList> getPostList();


        /*@GET("(postId)/?Key="+ Key)
        Call<Item>getPostById(@Path("postId") String id);*/

    }


}
