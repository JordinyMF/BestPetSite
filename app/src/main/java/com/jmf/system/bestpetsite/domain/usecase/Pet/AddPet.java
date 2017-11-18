package com.jmf.system.bestpetsite.domain.usecase.Pet;

import com.jmf.system.bestpetsite.domain.executor.PostExecutionThread;
import com.jmf.system.bestpetsite.domain.executor.ThreadExecutor;
import com.jmf.system.bestpetsite.domain.models.Pet;
import com.jmf.system.bestpetsite.domain.repository.PetRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;

/**
 * Created by JORDINY on 18/11/2017.
 */

public class AddPet extends UseCase<Pet> {
    private final PetRepository petRepository;
    private Pet pet;

    public AddPet(ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread, PetRepository userRepository) {
        super(threadExecutor, postExecutionThread);

        this.petRepository = userRepository;
    }

    public void setParams(Pet pet){this.pet=pet;}

    @Override
    protected void buildUseCase() {
        try{
            Pet returnedUser=this.petRepository.insertPet(this.pet);
            notifyUseCaseSuccess(returnedUser);
        }catch (Exception e){
            notifyUseCaseError(e);
        }
    }
}
