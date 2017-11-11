package com.jmf.system.bestpetsite.presentation.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jmf.system.bestpetsite.R;

import butterknife.ButterKnife;

public class AccountCreateActivity extends AppCompatActivity {

    private TextView mTextMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_user);
        ButterKnife.bind(this);
    }

    public void btn_AccountCreate(View view) {

    }
}
