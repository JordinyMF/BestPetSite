package com.jmf.system.bestpetsite.presentation.view.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.models.CodesCatalogModel;
import com.jmf.system.bestpetsite.presentation.models.PetControlTypeModel;
import com.jmf.system.bestpetsite.presentation.view.fragments.AddPetControlTypeFragment;

public class PetControlTypesActivity extends AppCompatActivity {

    private static final String TAG_ADD_CONTROLTYPES_FRAGMENT = "add_controltypes_fragment";
    public static final String TAG_CRUD_CONTROLTYPES = "data";

    CodesCatalogModel codesCatalogModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.fragment_add_pet_control_type);

        if (savedInstanceState == null) {
            Intent intent=   getIntent();
            codesCatalogModel=  intent.getParcelableExtra(TAG_CRUD_CONTROLTYPES);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content,  AddPetControlTypeFragment .newInstance(codesCatalogModel), TAG_ADD_CONTROLTYPES_FRAGMENT);
            ft.commit();
        }
    }

    public void btn_PetRemember(View view) {
        AddPetControlTypeFragment addPetControlTypeFragment = (AddPetControlTypeFragment) getSupportFragmentManager()
                .findFragmentByTag(TAG_ADD_CONTROLTYPES_FRAGMENT);
        if (addPetControlTypeFragment != null) {
            addPetControlTypeFragment.onSavePetControlTypeActionClick();
        }
    }




    public void setActionBar(Toolbar toolbarPet) {

        setSupportActionBar(toolbarPet);

    getSupportActionBar().setTitle("");

    }
}
