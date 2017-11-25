package com.jmf.system.bestpetsite.presentation.view;

import com.jmf.system.bestpetsite.presentation.models.PetControlTypeModel;

/**
 * Created by JORDINY on 25/11/2017.
 */

public interface AddPetControlTypeView extends LoadingView {
    void savePetControlType(PetControlTypeModel petControlTypeModel);

    void onPetControlTypeSuccess(PetControlTypeModel petControlTypeModel);
}
