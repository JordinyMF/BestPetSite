package com.jmf.system.bestpetsite.data.network.interfaces;

import com.jmf.system.bestpetsite.data.entities.CodesCatalogEntity;

import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public interface ConfigurationDataStore {

    List<CodesCatalogEntity> getCodesListById(int id) throws Exception;
}
