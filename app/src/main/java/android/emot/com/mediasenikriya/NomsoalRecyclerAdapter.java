package android.emot.com.mediasenikriya;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NomsoalRecyclerAdapter extends RecyclerView.Adapter<NomsoalRecyclerAdapter.NomsoalViewHolder> {
    ArrayList<Integer> nomsoal;
    ArrayList<Integer> isisoal;
    OnitemclickListener mlistener;

    public NomsoalRecyclerAdapter(ArrayList<Integer> nomsoal, ArrayList<Integer> isisoal) {
        this.nomsoal = nomsoal;
        this.isisoal = isisoal;
    }

    @NonNull
    @Override
    public NomsoalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contentview_numsoal,viewGroup,false);
        NomsoalViewHolder nomsoalViewHolder = new NomsoalViewHolder(view,mlistener);
        return nomsoalViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull NomsoalViewHolder holder, int i) {
        int x = nomsoal.get(i) + 1;
        holder.tv_nomsoal.setText(String.valueOf(x));
        if (isisoal.get(i) != null){
            holder.lyt_numsoal.setBackgroundResource(R.color.primaryColorblueLight);
        }else {
            holder.lyt_numsoal.setBackgroundResource(R.color.colorgrey);
        }
    }

    @Override
    public int getItemCount() {
        return nomsoal.size();
    }

    public static class NomsoalViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_nomsoal;
        public View lyt_numsoal;
        private OnitemclickListener mlistener;

        public NomsoalViewHolder(@NonNull View itemView,final OnitemclickListener listener) {
            super(itemView);
            lyt_numsoal = itemView.findViewById(R.id.lyt_numsoal);
            tv_nomsoal = itemView.findViewById(R.id.tv_numsoal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
//                            lyt_numsoal.setBackgroundColor(view.getResources().getColor(R.color.colorGreen));
                        }
                    }
                }
            });
        }
    }

    public interface OnitemclickListener{
        void onItemClick(int position);
    };

    public void setOnItemClickListener(OnitemclickListener listener){
        mlistener = listener;
    };
}