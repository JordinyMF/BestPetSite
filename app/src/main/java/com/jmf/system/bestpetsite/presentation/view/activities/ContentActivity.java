package com.jmf.system.bestpetsite.presentation.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.view.fragments.AddPetFragment;
import com.jmf.system.bestpetsite.presentation.view.fragments.AddUserFragment;
import com.jmf.system.bestpetsite.presentation.view.fragments.ProfilePetFragment;

import java.io.File;

public class ContentActivity extends AppCompatActivity {

    private static final String TAG_PROFILE_USER_FRAGMENT = "profile_user_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_content);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, new AddPetFragment(), TAG_PROFILE_USER_FRAGMENT);
            ft.commit();
        }
    }

    public void btn_PetCreate(View view) {
        AddPetFragment addPetFragment = (AddPetFragment) getSupportFragmentManager()
                .findFragmentByTag(TAG_PROFILE_USER_FRAGMENT);
        if (addPetFragment != null) {
            addPetFragment.onSavePetActionClick();
        }
    }

    public void btn_PetPhoto(View view) {

        AddPetFragment addPetFragment = (AddPetFragment) getSupportFragmentManager()
                .findFragmentByTag(TAG_PROFILE_USER_FRAGMENT);
        if (addPetFragment != null) {
            addPetFragment.loadphoto();
        }
    }

}
