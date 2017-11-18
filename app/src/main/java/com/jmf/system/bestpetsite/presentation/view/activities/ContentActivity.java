package com.jmf.system.bestpetsite.presentation.view.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.view.fragments.AddUserFragment;
import com.jmf.system.bestpetsite.presentation.view.fragments.ProfilePetFragment;

public class ContentActivity extends AppCompatActivity {

    private static final String TAG_PROFILE_USER_FRAGMENT = "profile_user_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_content);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, new ProfilePetFragment(), TAG_PROFILE_USER_FRAGMENT);
            ft.commit();
        }
    }
}
