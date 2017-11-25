package com.jmf.system.bestpetsite.presentation.view.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.view.fragments.AddPetFragment;
import com.jmf.system.bestpetsite.presentation.view.fragments.CodesCatalogListFragment;

public class CodesCatalogActivity extends AppCompatActivity {

    private static final String TAG_CODESCATALOG_LIST_FRAGMENT = "codes_catalog_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_codes_catalog);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, new CodesCatalogListFragment(), TAG_CODESCATALOG_LIST_FRAGMENT);
            ft.commit();
        }
    }
}
