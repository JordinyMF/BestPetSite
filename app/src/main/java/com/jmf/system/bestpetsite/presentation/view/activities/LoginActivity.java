package com.jmf.system.bestpetsite.presentation.view.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.jmf.system.bestpetsite.presentation.view.fragments.LoginUserFragment;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG_LOGIN_FRAGMENT = "login_user_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_login);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, new LoginUserFragment(),TAG_LOGIN_FRAGMENT);
            ft.commit();
        }
        getSupportActionBar().hide();
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void onClickBreak(View view) {
        LoginUserFragment addTaskFragment = (LoginUserFragment) getSupportFragmentManager()
                .findFragmentByTag(TAG_LOGIN_FRAGMENT);
        if (addTaskFragment != null) {
            addTaskFragment.onLoginActionClick();
        }
    }
}
