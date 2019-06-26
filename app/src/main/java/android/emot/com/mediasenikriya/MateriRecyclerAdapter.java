package android.emot.com.mediasenikriya;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Windows 8.1 on 03/04/2019.
 */

public class MateriRecyclerAdapter extends RecyclerView.Adapter<MateriRecyclerAdapter.MateriViewHolder> {
    private ArrayList<ItemMateri> mItemMateri;
    private OnitemclickListener mlistener;
    static Typeface type;



    public interface OnitemclickListener{
        void onItemClick(int position);
    };
    public void setOnItemClickListener(OnitemclickListener listener){
        mlistener = listener;
    };


    public static class MateriViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageMateri;
        public TextView mJudulMateri;

        public MateriViewHolder(View itemView, final OnitemclickListener listener) {
            super(itemView);
            mImageMateri = itemView.findViewById(R.id.imageCard_materi);
            mJudulMateri = itemView.findViewById(R.id.judul_materi);
            type = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/TrajanPro-Bold.otf");
            mJudulMateri.setTypeface(type);
            mJudulMateri.setTextColor(itemView.getResources().getColor(R.color.colorBlack));



            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                           listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public MateriRecyclerAdapter(ArrayList<ItemMateri> itemMateris){
        mItemMateri = itemMateris;


    }

    @Override
    public MateriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewitem_materi,parent,false);
        MateriViewHolder viewHolder = new MateriViewHolder(v,mlistener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MateriViewHolder holder, int position) {
        ItemMateri currentItem = mItemMateri.get(position);

        holder.mImageMateri.setImageResource(currentItem.getmImageMateri());
        holder.mJudulMateri.setText(currentItem.getmJudulMateri());

    }

    @Override
    public int getItemCount() {
        return mItemMateri.size();
    }



}
