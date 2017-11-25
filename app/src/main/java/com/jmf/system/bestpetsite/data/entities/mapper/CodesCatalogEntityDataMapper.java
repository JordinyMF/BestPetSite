package com.jmf.system.bestpetsite.data.entities.mapper;

import com.jmf.system.bestpetsite.data.entities.CodesCatalogEntity;
import com.jmf.system.bestpetsite.domain.models.CodesCatalog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalogEntityDataMapper {
    public CodesCatalog transform(CodesCatalogEntity codesCatalogEntity){
        CodesCatalog codesCatalog=new CodesCatalog();
        codesCatalog.setId(codesCatalogEntity.getId());
        codesCatalog.setDescription(codesCatalogEntity.getDescription());
        codesCatalog.setValue(codesCatalogEntity.getValue());
        codesCatalog.setPicture(codesCatalogEntity.getPicture());
        return codesCatalog;
    }
    public List<CodesCatalog> transform(List<CodesCatalogEntity> codesCatalogEntityList) {
        List<CodesCatalog> codesCatalogList = new ArrayList<>();
        for(CodesCatalogEntity codesCatalogEntity : codesCatalogEntityList) {
            codesCatalogList.add(transform(codesCatalogEntity));
        }
        return codesCatalogList;
    }

    public CodesCatalogEntity transform(CodesCatalog codesCatalog) {
        CodesCatalogEntity codesCatalogEntity = new CodesCatalogEntity();
        codesCatalogEntity.setId(codesCatalog.getId());
        codesCatalogEntity.setDescription(codesCatalog.getDescription());
        codesCatalogEntity.setValue(codesCatalog.getValue());
        codesCatalogEntity.setPicture(codesCatalog.getPicture());
        return codesCatalogEntity;
    }
}
