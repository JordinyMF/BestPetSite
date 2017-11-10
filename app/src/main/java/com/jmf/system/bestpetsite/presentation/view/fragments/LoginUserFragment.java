package com.jmf.system.bestpetsite.presentation.view.fragments;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jmf.system.bestpetsite.MainActivity;
import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.data.network.retrofit.Token;
import com.jmf.system.bestpetsite.presentation.models.UserModel;
import com.jmf.system.bestpetsite.presentation.presenter.user.LoginUserPresenter;
import com.jmf.system.bestpetsite.presentation.view.LoginUserView;

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


    @BindView(R.id.progressa)
    ProgressBar progressBar;

    private Unbinder unbinder;

    private LoginUserPresenter loginUserPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.activity_main,container,false);
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
        this.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        this.progressBar.setVisibility(View.GONE);
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
            startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
        }
    }

    public void onLoginActionClick(){
        UserModel userModel = new UserModel();
        userModel.setEmail(edtLoginName.getText().toString());

        userModel.setPassword(edtLoginPassword.getText().toString());
        loginUser(userModel);
    }


}
