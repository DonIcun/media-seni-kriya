package android.emot.com.mediasenikriya;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoAdapterViewHolder> {
    private ArrayList<ItemVideo> arrayList;
    private OnitemclickListener mlistener;
    static Typeface typeface;

    public VideoAdapter(ArrayList<ItemVideo> arrayList) {
        this.arrayList = arrayList;
    }

    public interface OnitemclickListener{
        void onItemClick(int position);
    };
    public void setOnItemClickListener(OnitemclickListener listener){
        mlistener = listener;
    };

    @NonNull
    @Override
    public VideoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.carviewitem_video,viewGroup,false);
        VideoAdapterViewHolder viewHolder  = new VideoAdapterViewHolder(v,mlistener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapterViewHolder holder, int i) {
        holder.tvjudul.setText((i+1)+". "+arrayList.get(i).getNama());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VideoAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView tvjudul;

        public VideoAdapterViewHolder(@NonNull View itemView,final OnitemclickListener listener) {
            super(itemView);
            tvjudul = itemView.findViewById(R.id.judul_video);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
