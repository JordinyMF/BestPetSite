package com.jmf.system.bestpetsite.presentation.presenter.Pet;

import com.jmf.system.bestpetsite.data.entities.PetEntity;
import com.jmf.system.bestpetsite.data.entities.mapper.PetEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.PetDataRepository;
import com.jmf.system.bestpetsite.data.repository.datasource.pet.PetDataSourceFactory;
import com.jmf.system.bestpetsite.domain.exception.DefaultErrorBundle;
import com.jmf.system.bestpetsite.domain.exception.ErrorBundle;
import com.jmf.system.bestpetsite.domain.executor.JobExecutor;
import com.jmf.system.bestpetsite.domain.executor.UIThread;
import com.jmf.system.bestpetsite.domain.models.Pet;
import com.jmf.system.bestpetsite.domain.models.User;
import com.jmf.system.bestpetsite.domain.repository.PetRepository;
import com.jmf.system.bestpetsite.domain.usecase.Pet.AddPet;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;
import com.jmf.system.bestpetsite.presentation.exception.ErrorMessageFactory;
import com.jmf.system.bestpetsite.presentation.models.PetModel;
import com.jmf.system.bestpetsite.presentation.models.mapper.PetModelDataMapper;
import com.jmf.system.bestpetsite.presentation.presenter.BasePresenter;
import com.jmf.system.bestpetsite.presentation.view.AddPetView;

/**
 * Created by JORDINY on 18/11/2017.
 */

public class AddPetPresenter extends BasePresenter<AddPetView> {

    private final AddPet addPet;
    private final PetModelDataMapper petModelDataMapper;

    public AddPetPresenter(AddPetView view) {
        super(view);
        final PetRepository customerRepository = new PetDataRepository(
                new PetDataSourceFactory(), new PetEntityDataMapper());
        this.addPet = new AddPet(new JobExecutor(), new UIThread(), customerRepository);
        this.petModelDataMapper = new PetModelDataMapper();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        addPet.cancel();
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
    private void notifySavePetSuccess(Pet pet) {
        view.onPetSuccess(petModelDataMapper.transform(pet));
    }

    public void savePet(PetModel petModel){
        showLoadingView();
        addPet.setParams(petModelDataMapper.transform(petModel));
        addPet.execute(new UseCase.Callback<Pet>() {
            @Override
            public void onSuccess(Pet pet) {
                hideLoadingView();
                notifySavePetSuccess(pet);
            }

            @Override
            public void onError(Throwable e) {
                hideLoadingView();
                showErrorMessage(new DefaultErrorBundle((Exception) e));
            }
        });
    }

}