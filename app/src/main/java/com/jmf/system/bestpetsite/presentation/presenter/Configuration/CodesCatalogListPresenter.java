package com.jmf.system.bestpetsite.presentation.presenter.Configuration;

import com.jmf.system.bestpetsite.data.entities.mapper.CodesCatalogEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.ConfigurationDataRepository;
import com.jmf.system.bestpetsite.data.repository.datasource.configuration.ConfigurationDataSourceFactory;
import com.jmf.system.bestpetsite.domain.exception.DefaultErrorBundle;
import com.jmf.system.bestpetsite.domain.exception.ErrorBundle;
import com.jmf.system.bestpetsite.domain.executor.JobExecutor;
import com.jmf.system.bestpetsite.domain.executor.UIThread;
import com.jmf.system.bestpetsite.domain.models.CodesCatalog;
import com.jmf.system.bestpetsite.domain.repository.ConfigurationRepository;
import com.jmf.system.bestpetsite.domain.usecase.Configuration.GetCodesCatalog;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;
import com.jmf.system.bestpetsite.presentation.exception.ErrorMessageFactory;
import com.jmf.system.bestpetsite.presentation.models.CodesCatalogModel;
import com.jmf.system.bestpetsite.presentation.models.mapper.CodesCatalogModelDataMapper;
import com.jmf.system.bestpetsite.presentation.presenter.BasePresenter;
import com.jmf.system.bestpetsite.presentation.view.CodesCatalogListView;

import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalogListPresenter  extends BasePresenter<CodesCatalogListView> {
    private final GetCodesCatalog getCodesCatalog;
    private final CodesCatalogModelDataMapper codesCatalogModelDataMapper;

    public CodesCatalogListPresenter(CodesCatalogListView view) {
        super(view);
        final ConfigurationRepository configurationRepository = new ConfigurationDataRepository(
                new ConfigurationDataSourceFactory(), new CodesCatalogEntityDataMapper());
        this.getCodesCatalog = new GetCodesCatalog(new JobExecutor(), new UIThread(), configurationRepository);
        this.codesCatalogModelDataMapper = new CodesCatalogModelDataMapper();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        getCodesCatalog.cancel();
        view = null;
    }
    private void renderCodesCatalogListInView(List<CodesCatalog> codesCatalogList) {
        view.renderCodesCatalogList(codesCatalogModelDataMapper.transform(codesCatalogList));
    }

    public void onCodesCatalogClicked(CodesCatalogModel codesCatalogModel) {
        view.viewCodesCatalog(codesCatalogModel);
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }

    private void showLoadingView() {
        view.showLoading();
    }

    private void hideLoadingView() {
        view.hideLoading();
    }

    public void getCodesCatalogList(int id) {
        showLoadingView();
        this.getCodesCatalog.setParams(id);
        this.getCodesCatalog.execute(new UseCase.Callback<List<CodesCatalog>>() {
            @Override
            public void onSuccess(List<CodesCatalog> codesCatalogList) {
                hideLoadingView();
                renderCodesCatalogListInView(codesCatalogList);
            }

            @Override
            public void onError(Throwable e) {
                hideLoadingView();
                showErrorMessage(new DefaultErrorBundle((Exception) e));
            }
        });
    }
}