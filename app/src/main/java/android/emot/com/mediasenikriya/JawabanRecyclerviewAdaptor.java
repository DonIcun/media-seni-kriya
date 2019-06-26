package android.emot.com.mediasenikriya;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Windows 8.1 on 29/04/2019.
 */

public class JawabanRecyclerviewAdaptor extends RecyclerView.Adapter<JawabanRecyclerviewAdaptor.JawabanViewHolder> {
    private ArrayList<ItemJawaban> mItemMateri;
    private MateriRecyclerAdapter.OnitemclickListener mlistener;


    @Override
    public JawabanRecyclerviewAdaptor.JawabanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewitem_hasiljawaban,parent,false);
        JawabanViewHolder viewHolder = new JawabanViewHolder(v,mlistener) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JawabanRecyclerviewAdaptor.JawabanViewHolder holder, int position) {
        ItemJawaban current = mItemMateri.get(position);

        holder.kondisijawaban.setText(current.getMhasilJawaban());
        holder.nojawaban.setText(current.getMnoJawaban());


    }

    @Override
    public int getItemCount() {
        return mItemMateri.size();
    }

    public class JawabanViewHolder extends RecyclerView.ViewHolder {
        TextView nojawaban,kondisijawaban;

        public JawabanViewHolder(View itemView, MateriRecyclerAdapter.OnitemclickListener mlistener) {
            super(itemView);
            nojawaban = itemView.findViewById(R.id.noJawaban);
            kondisijawaban = itemView.findViewById(R.id.kondisiJawaban);
        }
    }

    public JawabanRecyclerviewAdaptor (ArrayList<ItemJawaban> itemJawaben){
        mItemMateri = itemJawaben;
    }
}
