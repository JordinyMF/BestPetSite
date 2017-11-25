package com.jmf.system.bestpetsite.presentation.view.fragments;

import android.app.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jmf.system.bestpetsite.presentation.view.activities.AccountCreateActivity;
import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.data.network.retrofit.Token;
import com.jmf.system.bestpetsite.presentation.models.UserModel;
import com.jmf.system.bestpetsite.presentation.presenter.user.LoginUserPresenter;
import com.jmf.system.bestpetsite.presentation.view.LoginUserView;
import com.jmf.system.bestpetsite.presentation.view.activities.CustomerActivity;
import com.jmf.system.bestpetsite.presentation.view.activities.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import  android.support.v4.app.Fragment;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class LoginUserFragment extends Fragment implements LoginUserView {

    @BindView(R.id.edt_loginname)
    EditText edtLoginName;

    @BindView(R.id.edt_loginpassword)
    EditText edtLoginPassword;


    ProgressDialog progressDialog;

    private Unbinder unbinder;

    private LoginUserPresenter loginUserPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.activity_login,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbinder= ButterKnife.bind(this,view);
        loginUserPresenter=new LoginUserPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Procesando...");
        progressDialog.setMessage("Espere por favor.");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {

        progressDialog.dismiss();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getActivity().getApplicationContext(),errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    @Override
    public void loginUser(UserModel userModel) {
        loginUserPresenter.loginUser(userModel);
    }

    @Override
    public void onUserSuccess(UserModel userModel) {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
        if(!Token.TOKEN_SERVICE_REST.isEmpty()){
            Log.i("**** Token de Acceso: ",Token.TOKEN_SERVICE_REST);
            startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
        }else {
            Toast.makeText(getActivity().getApplicationContext(),"Usuario y/o Password Incorrecto",Toast.LENGTH_SHORT).show();
        }
    }

    public void onLoginActionClick(){
        UserModel userModel = new UserModel();
        userModel.setEmail(edtLoginName.getText().toString());

        userModel.setPassword(edtLoginPassword.getText().toString());
        loginUser(userModel);
    }

    public void onAccountCreateActionClick(){
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
        startActivity(new Intent(getActivity().getApplicationContext(), AccountCreateActivity.class));
    }
}
