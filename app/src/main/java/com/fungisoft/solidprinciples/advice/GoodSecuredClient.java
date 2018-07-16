package com.fungisoft.solidprinciples.advice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoodSecuredClient extends BaseClient {
    public void fetchUser(String userId, final UserListener listener) {
        getSecuredService().fetchUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                listener.onUserReceived(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
