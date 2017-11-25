package com.jmf.system.bestpetsite.domain.repository;

import com.jmf.system.bestpetsite.domain.models.CodesCatalog;

import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public interface ConfigurationRepository {

    List<CodesCatalog> getCodesListById(int id) throws Exception;
}
