package com.jmf.system.bestpetsite.presentation.view.fragments;


import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.models.CodesCatalogModel;
import com.jmf.system.bestpetsite.presentation.models.PetControlTypeModel;
import com.jmf.system.bestpetsite.presentation.presenter.Configuration.CodesCatalogListPresenter;
import com.jmf.system.bestpetsite.presentation.presenter.PetControlType.AddPetControlTypePresenter;
import com.jmf.system.bestpetsite.presentation.view.AddPetControlTypeView;
import com.jmf.system.bestpetsite.presentation.view.CodesCatalogListView;
import com.jmf.system.bestpetsite.presentation.view.activities.PetControlTypesActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPetControlTypeFragment extends Fragment implements AddPetControlTypeView,CodesCatalogListView {
    private static final String ARG_TASK= "task";
    @BindView(R.id.toolbarPet)
    Toolbar toolbarPet;

    @BindView(R.id.toolbar_layoutPet)
    CollapsingToolbarLayout toolbar_layoutPet;

    @BindView(R.id.app_barPet)
    AppBarLayout app_barPet;

    @BindView(R.id.edtPetControlDescription)
    EditText edtPetControlDescription;

    @BindView(R.id.spnFrequency)
    AppCompatSpinner spnFrequency;

    @BindView(R.id.edtPetControlStartDate)
    EditText edtPetControlStartDate;

    @BindView(R.id.edtPetControlAttentionHour)
    EditText edtPetControlAttentionHour;

    @BindView(R.id.edtPetControlNotes)
    EditText edtPetControlNotes;

    @BindView(R.id.picturePetCodeCatalog)
    ImageView picturePetCodeCatalog;

    @BindView(R.id.descriptionTextView)
    TextView descriptionTextView;

    private Unbinder unbinder;
    private int code_catalog_id=1002;
    private AddPetControlTypePresenter addPetControlTypePresenter;
    private CodesCatalogListPresenter codesCatalogListPresenter;
    List<CodesCatalogModel> codesCatalogModelList;
    ProgressDialog progressDialog;
    private CodesCatalogModel codesCatalogModel;
    public AddPetControlTypeFragment() {
        // Required empty public constructor
    }

    public static AddPetControlTypeFragment newInstance(CodesCatalogModel codesCatalogModel) {
        AddPetControlTypeFragment f = new AddPetControlTypeFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TASK, codesCatalogModel);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            codesCatalogModel =  getArguments().getParcelable(ARG_TASK);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_pet_control_type, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((PetControlTypesActivity)getActivity()).setActionBar(toolbarPet);



        toolbar_layoutPet.setTitle("");
        app_barPet.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbar_layoutPet.setTitle("Tipo de Control");
                    isShow = false;
                } else if (!isShow) {
                    toolbar_layoutPet.setTitle("");
                    isShow = true;
                }
            }
        });


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        addPetControlTypePresenter = new AddPetControlTypePresenter(this);

        codesCatalogListPresenter = new CodesCatalogListPresenter(this);
        codesCatalogListPresenter.getCodesCatalogList(code_catalog_id);
        if (codesCatalogModel != null) {
            int id = getContext().getResources().getIdentifier(codesCatalogModel.getPicture(), "mipmap",getContext().getPackageName());
            picturePetCodeCatalog.setImageResource(id);

            edtPetControlDescription.setText(codesCatalogModel.getDescription());
            descriptionTextView.setText(codesCatalogModel.getDescription());
        }




    }

    @Override
    public void onDestroyView() {
        ((PetControlTypesActivity)getActivity()).setActionBar((Toolbar) null);
        super.onDestroyView();

        unbinder.unbind();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        codesCatalogListPresenter.destroy();
    }

    @Override
    public void showLoading() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Procesando...");
        progressDialog.setMessage("Espere por favor.");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void savePetControlType(PetControlTypeModel petControlTypeModel) {
        addPetControlTypePresenter.savePetControlType(petControlTypeModel);
    }
    public void onSavePetControlTypeActionClick() {

    }
    @Override
    public void onPetControlTypeSuccess(PetControlTypeModel petControlTypeModel) {

    }

    @Override
    public void renderCodesCatalogList(List<CodesCatalogModel> codesCatalogModelList) {
       this.codesCatalogModelList= codesCatalogModelList;
        if(this.codesCatalogModelList.size()>0){
            ArrayAdapter<CodesCatalogModel> adapter=new ArrayAdapter<CodesCatalogModel>(getContext(),android.R.layout.simple_spinner_item,this.codesCatalogModelList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spnFrequency.setAdapter(adapter);
        }
    }

    @Override
    public void viewCodesCatalog(CodesCatalogModel codesCatalogModel) {

    }

    public void onSaveActionClick() {
        PetControlTypeModel petControlTypeModel = new PetControlTypeModel();
        petControlTypeModel.setPetId(1);
        petControlTypeModel.setDescription(edtPetControlDescription.getText().toString());
        //petControlTypeModel.setStartDateAttention(edtEmail.getText().toString());
        //petControlTypeModel.setPassword(edtPassword.getText().toString());
        petControlTypeModel.setControlType(codesCatalogModel.getId());
        petControlTypeModel.setFrequency((int) (spnFrequency.getSelectedItemId()+1));
        petControlTypeModel.setNotes(edtPetControlNotes.getText().toString());
        savePetControlType(petControlTypeModel);
    }
}
