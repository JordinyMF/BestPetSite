package com.jmf.system.bestpetsite.presentation.presenter.PetControlType;

import com.jmf.system.bestpetsite.data.entities.mapper.PetControlTypeEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.PetControlTypeDataRepository;
import com.jmf.system.bestpetsite.data.repository.datasource.PetControlType.PetControlTypeDataSourceFactory;
import com.jmf.system.bestpetsite.domain.exception.DefaultErrorBundle;
import com.jmf.system.bestpetsite.domain.exception.ErrorBundle;
import com.jmf.system.bestpetsite.domain.executor.JobExecutor;
import com.jmf.system.bestpetsite.domain.executor.UIThread;
import com.jmf.system.bestpetsite.domain.models.PetControlType;
import com.jmf.system.bestpetsite.domain.repository.PetControlTypeRepository;
import com.jmf.system.bestpetsite.domain.usecase.PetControlType.AddPetControlType;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;
import com.jmf.system.bestpetsite.presentation.exception.ErrorMessageFactory;
import com.jmf.system.bestpetsite.presentation.models.PetControlTypeModel;
import com.jmf.system.bestpetsite.presentation.models.mapper.PetControlTypeModelDataMapper;
import com.jmf.system.bestpetsite.presentation.presenter.BasePresenter;
import com.jmf.system.bestpetsite.presentation.view.AddPetControlTypeView;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class AddPetControlTypePresenter  extends BasePresenter<AddPetControlTypeView> {
    private final AddPetControlType addPetControlType;
    private final PetControlTypeModelDataMapper petControlTypeModelDataMapper;
    public AddPetControlTypePresenter(AddPetControlTypeView view) {
        super(view);

        final PetControlTypeRepository customerRepository = new PetControlTypeDataRepository(
                new PetControlTypeDataSourceFactory(), new PetControlTypeEntityDataMapper());
        this.addPetControlType = new AddPetControlType(new JobExecutor(), new UIThread(), customerRepository);
        this.petControlTypeModelDataMapper = new PetControlTypeModelDataMapper();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        addPetControlType.cancel();
        view = null;
    }
    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }
    private void showLoadingView(){
        view.showLoading();
    }
    private void hideLoadingView(){
        view.hideLoading();
    }
    private void notifySavePetControlTypeSuccess(PetControlType petControlType) {
        view.onPetControlTypeSuccess(petControlTypeModelDataMapper.transform(petControlType));
    }

    public void savePetControlType(PetControlTypeModel petControlTypeModel){
        showLoadingView();
        addPetControlType.setParams(petControlTypeModelDataMapper.transform(petControlTypeModel));
        addPetControlType.execute(new UseCase.Callback<PetControlType>() {
            @Override
            public void onSuccess(PetControlType petControlType) {
                hideLoadingView();
                notifySavePetControlTypeSuccess(petControlType);
            }

            @Override
            public void onError(Throwable e) {
                hideLoadingView();
                showErrorMessage(new DefaultErrorBundle((Exception) e));
            }
        });
    }

}
