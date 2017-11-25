package com.jmf.system.bestpetsite.presentation.view.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.models.PetModel;
import com.jmf.system.bestpetsite.presentation.presenter.Pet.AddPetPresenter;
import com.jmf.system.bestpetsite.presentation.view.AddPetView;
import com.jmf.system.bestpetsite.presentation.view.activities.MainActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by JORDINY on 18/11/2017.
 */

public class AddPetFragment extends Fragment implements AddPetView {

    @BindView(R.id.edtPetName)
    EditText edtPetName;

    @BindView(R.id.edtPetAge)
    EditText edtPetAge;

    @BindView(R.id.edtPetRace)
    EditText edtPetRace;

    @BindView(R.id.edtPetColor)
    EditText edtPetColor;

    ProgressDialog progressDialog;

    @BindView(R.id.FotoCC)
    ImageView fotoCC;

    private Unbinder unbinder;

    private AddPetPresenter addPetPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_pet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        addPetPresenter = new AddPetPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {

        /*progressBar.setVisibility(View.VISIBLE)*/
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Procesando...");
        progressDialog.setMessage("Espere por favor.");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
       /* progressBar.setVisibility(View.GONE);*/
        progressDialog.dismiss();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void savePet(PetModel petModel) {
        addPetPresenter.savePet(petModel);
    }

    @Override
    public void onPetSuccess(PetModel petModel) {
        Toast.makeText(getContext(), "Se registro correctamente", Toast.LENGTH_SHORT).show();
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
        startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));

    }

    public void onSavePetActionClick() {
        PetModel petModel = new PetModel();
        petModel.setName(edtPetName.getText().toString());
        petModel.setAge(Integer.valueOf(edtPetAge.getText().toString()));
        petModel.setRace(edtPetRace.getText().toString());
        petModel.setColor(edtPetColor.getText().toString());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bm = ((BitmapDrawable)fotoCC.getDrawable()).getBitmap();
        bm.compress(Bitmap.CompressFormat.JPEG, 50, baos );
        byte[] imageBytes = baos.toByteArray();
        String byteArray = Base64.encodeToString( imageBytes, Base64.DEFAULT );

        petModel.setPhoto(byteArray);
        savePet(petModel);
    }
    String rutaArchivo;
    public void loadphoto(){
        Intent irParaCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);



        startActivityForResult(irParaCamara, 123);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123){
            if(resultCode == Activity.RESULT_OK){
                Bitmap photo = (Bitmap) data.getExtras().get("data");

                Bitmap scaledBitmap = Bitmap.createScaledBitmap(photo, 100, 100, true);
                fotoCC.setImageBitmap(scaledBitmap);



            }else{
                rutaArchivo = null;
            }
        }
    }
}