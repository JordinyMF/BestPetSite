package com.jmf.system.bestpetsite.presentation.view.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.models.CodesCatalogModel;
import com.jmf.system.bestpetsite.presentation.presenter.Configuration.CodesCatalogListPresenter;
import com.jmf.system.bestpetsite.presentation.view.CodesCatalogListView;
import com.jmf.system.bestpetsite.presentation.view.adapters.CodesCatalogAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalogListFragment extends Fragment implements CodesCatalogListView,CodesCatalogAdapter.OnItemClickListener {

    private CodesCatalogListPresenter codesCatalogListPresenter;
    private CodesCatalogAdapter codesCatalogAdapter;

    @BindView(R.id.codesCatalogRecyclerView)
    RecyclerView recyclerView;

    RecyclerView.LayoutManager codesCatalogLayoutManager;

    ProgressDialog progressDialog;

    private Unbinder unbinder;

    private int code_catalog_id=1001;

    public CodesCatalogListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_codes_catalog_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbinder = ButterKnife.bind(this, view);
        initUi();
        codesCatalogListPresenter = new CodesCatalogListPresenter(this);
        codesCatalogListPresenter.getCodesCatalogList(code_catalog_id);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        codesCatalogListPresenter.destroy();
    }
    private void initUi() {
        codesCatalogAdapter=new CodesCatalogAdapter();
        codesCatalogAdapter.setOnItemClickListener(this);

        codesCatalogLayoutManager=new GridLayoutManager(getContext(),
                getSpanCountFor(getResources().getConfiguration()));
        recyclerView.setLayoutManager(codesCatalogLayoutManager);
        recyclerView.setAdapter(codesCatalogAdapter);
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
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void renderCodesCatalogList(List<CodesCatalogModel> codesCatalogModelList) {
        codesCatalogAdapter.setCodesCatalogList(codesCatalogModelList);
    }

    @Override
    public void viewCodesCatalog(CodesCatalogModel codesCatalogModel) {
        /*Intent intent = new Intent(getContext(), UserDetailsActivity.class);
        intent.putExtra(UserDetailsActivity.EXTRA_USER_ID, userModel.getId());
        startActivity(intent);*/
    }

    @Override
    public void onCodesCatalogItemClick(CodesCatalogModel codesCatalogModel) {
        codesCatalogListPresenter.onCodesCatalogClicked(codesCatalogModel);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateLayoutAccordingTo(newConfig);
    }

    private void updateLayoutAccordingTo(Configuration configuration) {
        ((GridLayoutManager) codesCatalogLayoutManager).setSpanCount(
                getSpanCountFor(configuration));

    }
    private int getSpanCountFor(Configuration configuration) {
        return configuration.orientation == ORIENTATION_LANDSCAPE ? 3 : 2;
    }
}
