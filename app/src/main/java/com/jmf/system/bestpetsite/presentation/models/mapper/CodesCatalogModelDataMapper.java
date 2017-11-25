package com.jmf.system.bestpetsite.presentation.models.mapper;

import com.jmf.system.bestpetsite.domain.models.CodesCatalog;
import com.jmf.system.bestpetsite.presentation.models.CodesCatalogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalogModelDataMapper {
    public CodesCatalogModel transform(CodesCatalog codesCatalog){
        CodesCatalogModel codesCatalogModel=new CodesCatalogModel();
        codesCatalogModel.setId(codesCatalog.getId());
        codesCatalogModel.setDescription(codesCatalog.getDescription());
        codesCatalogModel.setValue(codesCatalog.getValue());
        codesCatalogModel.setPicture(codesCatalog.getPicture());
        return codesCatalogModel;
    }
    public List<CodesCatalogModel> transform(List<CodesCatalog> codesCatalogList) {
        List<CodesCatalogModel> codesCatalogModelList = new ArrayList<>();
        for(CodesCatalog codesCatalog: codesCatalogList) {
            codesCatalogModelList.add(transform(codesCatalog));
        }
        return codesCatalogModelList;
    }

    public CodesCatalog transform(CodesCatalogModel codesCatalogModel) {
        CodesCatalog codesCatalog = new CodesCatalog();
        codesCatalog.setId(codesCatalogModel.getId());
        codesCatalog.setDescription(codesCatalogModel.getDescription());
        codesCatalog.setValue(codesCatalogModel.getValue());
        codesCatalog.setPicture(codesCatalogModel.getPicture());
        return codesCatalog;
    }
}
