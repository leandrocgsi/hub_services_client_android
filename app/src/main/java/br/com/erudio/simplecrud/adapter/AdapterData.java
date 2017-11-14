package br.com.erudio.simplecrud.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.erudio.simplecrud.R;
import br.com.erudio.simplecrud.activities.LegalPersonActivity;
import br.com.erudio.simplecrud.model.LegalPerson;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private List<LegalPerson> mList ;
    private Context ctx;


    public AdapterData(Context ctx, List<LegalPerson> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        LegalPerson dm = mList.get(position);
        holder.companyName.setText(dm.getCompanyName());
        holder.tradeName.setText(dm.getNameTradeName());
        holder.cnpj.setText(dm.getCpfcnpj());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView companyName, tradeName, cnpj;
        LegalPerson dm;
        public HolderData (View v)
        {
            super(v);

            companyName  = (TextView) v.findViewById(R.id.tvCompanyName);
            tradeName = (TextView) v.findViewById(R.id.tvTradeName);
            cnpj = (TextView) v.findViewById(R.id.tvCNPJ);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx,LegalPersonActivity.class);
                    goInput.putExtra("id", dm.getId());
                    goInput.putExtra("et_company_name", dm.getCompanyName());
                    goInput.putExtra("et_trading_name", dm.getNameTradeName());
                    //goInput.putExtra("et_cnpj", dm.getCpfcnpj());

                    ctx.startActivity(goInput);
                }
            });
        }
    }
}
