package com.jmf.system.bestpetsite.presentation.view.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.view.fragments.AddUserFragment;

import butterknife.ButterKnife;

public class AccountCreateActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static final String TAG_ADD_USER_FRAGMENT = "add_user_fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.fragment_add_user);
        //ButterKnife.bind(this);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, new AddUserFragment(), TAG_ADD_USER_FRAGMENT);
            ft.commit();
        }
    }

    public void btn_AccountCreate(View view) {
        AddUserFragment addUserFragment = (AddUserFragment) getSupportFragmentManager()
                .findFragmentByTag(TAG_ADD_USER_FRAGMENT);
        if (addUserFragment != null) {
            addUserFragment.onSaveActionClick();
        }
    }
}
