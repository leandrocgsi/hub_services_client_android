package br.com.erudio.simplecrud.remote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.erudio.simplecrud.model.PessoaFisica;

public class PessoaFisicaAdapter extends RecyclerView.Adapter<PessoaFisicaAdapter.ViewHolder> {

    private List<PessoaFisica> mPessoaFisicas;
    private Context mContext;
    private PessoaFisicaListener mPessoaFisicaListener;

    public PessoaFisicaAdapter(Context context, List<PessoaFisica> posts, PessoaFisicaListener pessoaFisicaListener) {
        mPessoaFisicas = posts;
        mContext = context;
        mPessoaFisicaListener = pessoaFisicaListener;
    }

    @Override
    public PessoaFisicaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //TODO
        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mPessoaFisicaListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PessoaFisicaAdapter.ViewHolder holder, int position) {

        PessoaFisica pessoaFisica = mPessoaFisicas.get(position);
        TextView textView = holder.titleTv;
        textView.setText(pessoaFisica.getNomeNomeFantasia());
    }

    @Override
    public int getItemCount() {
        return mPessoaFisicas.size();
    }

    public void updatePessoaFisica(List<PessoaFisica> pessoaFisicas) {
        mPessoaFisicas = pessoaFisicas;
        notifyDataSetChanged();
    }

    private PessoaFisica getPessoaFisica(int adapterPosition) {
        return mPessoaFisicas.get(adapterPosition);
    }

    public interface PessoaFisicaListener {
        void onPostClick(long id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView titleTv;
        PessoaFisicaListener mPessoaFisicaListener;

        public ViewHolder(View pessoaFisicaView, PessoaFisicaListener postPessoaFisicaListener) {
            super(pessoaFisicaView);
            titleTv = (TextView) pessoaFisicaView.findViewById(android.R.id.text1);

            this.mPessoaFisicaListener = postPessoaFisicaListener;
            pessoaFisicaView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            PessoaFisica pessoa = getPessoaFisica(getAdapterPosition());
            this.mPessoaFisicaListener.onPostClick(pessoa.getId());

            notifyDataSetChanged();
        }
    }
}