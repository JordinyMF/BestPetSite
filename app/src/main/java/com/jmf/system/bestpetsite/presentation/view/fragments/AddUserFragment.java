package com.jmf.system.bestpetsite.presentation.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.models.UserModel;
import com.jmf.system.bestpetsite.presentation.presenter.user.AddUserPresenter;
import com.jmf.system.bestpetsite.presentation.view.AddUserView;
import com.jmf.system.bestpetsite.presentation.view.activities.AccountCreateActivity;
import com.jmf.system.bestpetsite.presentation.view.activities.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by JORDINY on 11/11/2017.
 */

public class AddUserFragment extends Fragment implements AddUserView {

    @BindView(R.id.edtFirstName)
    EditText edtFirstName;

    @BindView(R.id.edtLastName)
    EditText edtLastName;

    @BindView(R.id.edtEmail)
    EditText edtEmail;

    @BindView(R.id.edtPassword)
    EditText edtPassword;

    @BindView(R.id.progressAccount)
    ProgressBar progressBar;

    private Unbinder unbinder;

    private AddUserPresenter addUserPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        addUserPresenter = new AddUserPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
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
    public void saveUser(UserModel userModel) {
        addUserPresenter.saveUser(userModel);
    }

    @Override
    public void onUserSuccess(UserModel userModel) {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
        startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
    }

    public void onSaveActionClick() {
        UserModel userModel = new UserModel();
        userModel.setFirstName(edtFirstName.getText().toString());
        userModel.setLastName(edtLastName.getText().toString());
        userModel.setEmail(edtEmail.getText().toString());
        userModel.setPassword(edtPassword.getText().toString());
        saveUser(userModel);
    }
}