package com.jmf.system.bestpetsite.presentation.view;

import com.jmf.system.bestpetsite.presentation.models.PetModel;

/**
 * Created by JORDINY on 18/11/2017.
 */

public interface AddPetView extends LoadingView {
    void savePet(PetModel petModel);

    void onPetSuccess(PetModel petModel);
}
