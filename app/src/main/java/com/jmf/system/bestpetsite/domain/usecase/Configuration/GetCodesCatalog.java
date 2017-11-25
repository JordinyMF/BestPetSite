package com.jmf.system.bestpetsite.domain.usecase.Configuration;

import com.jmf.system.bestpetsite.domain.executor.PostExecutionThread;
import com.jmf.system.bestpetsite.domain.executor.ThreadExecutor;
import com.jmf.system.bestpetsite.domain.models.CodesCatalog;
import com.jmf.system.bestpetsite.domain.repository.ConfigurationRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;

import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class GetCodesCatalog extends UseCase<List<CodesCatalog>> {

    private final ConfigurationRepository configurationRepository;

    private int id;

    public GetCodesCatalog(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ConfigurationRepository configurationRepository) {
        super(threadExecutor, postExecutionThread);
        this.configurationRepository = configurationRepository;
    }

    public void setParams(int id){this.id =id;}


    @Override
    protected void buildUseCase() {
        try {
            List<CodesCatalog> returnedCustomerList = this.configurationRepository.getCodesListById(this.id);
            notifyUseCaseSuccess(returnedCustomerList);
        } catch (Exception e) {
            notifyUseCaseError(e);
        }
    }
}