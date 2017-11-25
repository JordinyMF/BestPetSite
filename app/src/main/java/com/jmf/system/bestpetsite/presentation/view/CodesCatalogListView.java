package com.jmf.system.bestpetsite.presentation.view;

import com.jmf.system.bestpetsite.presentation.models.CodesCatalogModel;

import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public interface CodesCatalogListView extends LoadingView {
    void renderCodesCatalogList(List<CodesCatalogModel> codesCatalogModelList);

    void viewCodesCatalog(CodesCatalogModel codesCatalogModel);
}
