package com.jmf.system.bestpetsite.presentation.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.presentation.models.CodesCatalogModel;
import com.jmf.system.bestpetsite.presentation.view.activities.PetControlTypesActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class CodesCatalogAdapter  extends RecyclerView.Adapter<CodesCatalogAdapter.ViewHolder> {

    private List<CodesCatalogModel> codesCatalogList;
    private OnItemClickListener onItemClickListener;


    @Override
    public CodesCatalogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.card_codes_catalog,parent,false);

       return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CodesCatalogAdapter.ViewHolder holder, int position) {
        final CodesCatalogModel codesCatalogModel = codesCatalogList.get(position);
        holder.bind(codesCatalogModel);
        holder.rememberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context,
                        PetControlTypesActivity.class);
                intent.putExtra(PetControlTypesActivity.TAG_CRUD_CONTROLTYPES,codesCatalogModel);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return codesCatalogList != null ? codesCatalogList.size() : 0;
    }

    public void setCodesCatalogList(List<CodesCatalogModel> codesCatalogList) {
        this.codesCatalogList = codesCatalogList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pictureCodeCatalog)
        ImageView pictureCodeCatalog;
        @BindView(R.id.descriptionTextView)
        TextView descriptionTextView;
        @BindView(R.id.rememberTextView)
        TextView rememberTextView;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            context=itemView.getContext();
        }


        public  void  bind(CodesCatalogModel codesCatalogModel){

            int id = context.getResources().getIdentifier(codesCatalogModel.getPicture(), "mipmap",context.getPackageName());
            pictureCodeCatalog.setImageResource(id);
            descriptionTextView.setText(codesCatalogModel.getDescription());

        }
    }
    public interface OnItemClickListener {
        void onCodesCatalogItemClick(CodesCatalogModel codesCatalogModel);
    }
}
