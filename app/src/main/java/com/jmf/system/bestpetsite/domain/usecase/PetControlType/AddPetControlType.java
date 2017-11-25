package com.jmf.system.bestpetsite.domain.usecase.PetControlType;

import com.jmf.system.bestpetsite.domain.executor.PostExecutionThread;
import com.jmf.system.bestpetsite.domain.executor.ThreadExecutor;
import com.jmf.system.bestpetsite.domain.models.PetControlType;
import com.jmf.system.bestpetsite.domain.repository.PetControlTypeRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class AddPetControlType extends UseCase<PetControlType> {
    private final PetControlTypeRepository petControlTypeRepository;
    private PetControlType petControlType;

    public AddPetControlType(ThreadExecutor threadExecutor,
                  PostExecutionThread postExecutionThread, PetControlTypeRepository petControlTypeRepository) {
        super(threadExecutor, postExecutionThread);

        this.petControlTypeRepository = petControlTypeRepository;
    }

    public void setParams(PetControlType petControlType){this.petControlType=petControlType;}

    @Override
    protected void buildUseCase() {
        try{
            PetControlType returnedPetControlType=this.petControlTypeRepository.insertPetControlType(this.petControlType);
            notifyUseCaseSuccess(returnedPetControlType);
        }catch (Exception e){
            notifyUseCaseError(e);
        }
    }
}
