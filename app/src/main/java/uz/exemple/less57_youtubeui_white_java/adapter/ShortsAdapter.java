package uz.exemple.less57_youtubeui_white_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less57_youtubeui_white_java.R;
import uz.exemple.less57_youtubeui_white_java.model.ShortsModel;


public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ShortsModel> items;

    public ShortsAdapter(Context context, ArrayList<ShortsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_short_video,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShortsModel item = items.get(position);
        holder.image.setImageResource(item.getImage_short());
        holder.title.setText(item.getTitle());
        holder.count_views.setText(item.getView_count());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView count_views;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_shortVideo);
            title = itemView.findViewById(R.id.tv_title_shortVideo);
            count_views = itemView.findViewById(R.id.tv_count_shortVideo);
        }
    }
}
