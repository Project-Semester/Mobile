package com.example.daiscrivi_mobileapp_semester4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.daiscrivi_mobileapp_semester4.Adapter.Constant;
import com.example.daiscrivi_mobileapp_semester4.Adapter.PostAdapterHome;
import com.example.daiscrivi_mobileapp_semester4.Models.Post;
import com.example.daiscrivi_mobileapp_semester4.Models.User;
import com.example.daiscrivi_mobileapp_semester4.Models.response.StoriesResponse;
import com.example.daiscrivi_mobileapp_semester4.retrofit.ApiClient;
import com.example.daiscrivi_mobileapp_semester4.retrofit.StoriesApi;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {
    public Context context;
    private View view;
    private ArrayList<News> newsArrayList;
    private String[] newsHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerview , recyclerView;
    private ArrayList<Post> arrayList;
    private SwipeRefreshLayout refreshLayout;
    private PostAdapterHome postAdapter;
    private SharedPreferences sharedPreferences;

    public HomeFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
            @NonNull Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        view = v.findViewById(R.id.imageView2);
        recyclerView = v.findViewById(R.id.recyclerHome);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailHomeFragment.class);
                startActivity(intent);
            }
        });


        return v;

    }

    private void init() {

        sharedPreferences = getContext().getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);


       //refreshLayout = view.findViewById(R.id.swipeHome);

        Retrofit retrofit = ApiClient.getRetrofit(UtilMethod.getToken(context));
        StoriesApi api = retrofit.create(StoriesApi.class);
        System.out.println(UtilMethod.getToken(context));
        Call<StoriesResponse> responseCall = api
                .getStories();
        responseCall.enqueue(new Callback<StoriesResponse>() {
            @Override
            public void onResponse(Call<StoriesResponse> call, Response<StoriesResponse> response) {
                if(response.isSuccessful()){
                    postAdapter = new PostAdapterHome(getContext(), response.body());
                    recyclerView.setAdapter(postAdapter);
                }else{
                    try {
                        Log.i("api", response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<StoriesResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });


//        getPosts();

//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getPosts();
//            }
//        });
    }

    private void getPosts() {
        arrayList = new ArrayList<>();
        refreshLayout.setRefreshing(true);

        StringRequest request = new StringRequest(Request.Method.GET, Constant.POSTS, response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getBoolean("success")) {
                    JSONArray array = new JSONArray(object.getString("posts"));
                    for(int i = 0; i < array.length(); i++) {
                        JSONObject dataObject = array.getJSONObject(i);
                        JSONObject userObject = dataObject.getJSONObject("user");

                        User user = new User();
                        user.setId(userObject.getInt("id"));
                        user.setUserName(userObject.getString("username"));
                        user.setPhoto(userObject.getString("photo"));

                        Post post = new Post();
                        post.setId(dataObject.getInt("id"));
                        post.setUser(user);
                        post.setLikes(dataObject.getInt("likes_count"));
                        post.setComments(dataObject.getInt("comments_count"));
                        post.setDate(dataObject.getString("created_at"));
                        post.setDesc(dataObject.getString("synopsis"));
                        post.setPhoto(dataObject.getString("cover"));

                        arrayList.add(post);
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            refreshLayout.setRefreshing(false);
        },error -> {
            error.printStackTrace();
            refreshLayout.setRefreshing(false);
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String token = sharedPreferences.getString("token", "");
                HashMap<String, String> map = new HashMap<>();
                map.put("Authorization", "Baerer" + token);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        recyclerview = view.findViewById(R.id.horizontalRv);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL , false) );
        init();
        AdapterHome adapter = new AdapterHome(getContext(), newsArrayList);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void dataInitialize() {

        newsArrayList = new ArrayList<>();

        newsHeading = new String[] {
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5)
        };

        imageResourceID = new int[] {
                R.drawable.judul_wattpad,
                R.drawable.judul_wattpad2,
                R.drawable.judul_wattpad3,
                R.drawable.judul_wattpad4,
                R.drawable.judul_wattpad5
        };

        for (int i = 0; i < newsHeading.length; i++) {

            News news = new News(newsHeading[i], imageResourceID[i]);
            newsArrayList.add(news);

        }
    }

}
