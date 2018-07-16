package com.fungisoft.solidprinciples.advice;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SecuredActivity extends Activity implements UserListener {
    private BadSecuredClient securedClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String user = PreferencesUtil.getUser(this);
        String token = PreferencesUtil.getToken(this);

        securedClient.fetchUser(user, token, "1", this);
    }

    @Override
    public void onUserReceived(User user) {

    }
}
