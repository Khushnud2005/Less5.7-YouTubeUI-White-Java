package uz.exemple.less57_youtubeui_white_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less57_youtubeui_white_java.R;
import uz.exemple.less57_youtubeui_white_java.model.Feed;


public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Feed> items;

    int ITEM_SHORT = 0;
    int ITEM_VIDEO = 1;

    public FeedAdapter(Context context, ArrayList<Feed> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Feed item = items.get(position);
        if(item.getList()!=null){
            return ITEM_SHORT;
        }
        return ITEM_VIDEO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_SHORT){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shorts,parent,false);
            return new ShortsViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_video,parent,false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof FeedViewHolder){
            Feed item = items.get(position);
            ImageView video = ((FeedViewHolder) holder).video;
            ImageView profile = ((FeedViewHolder) holder).profile;
            TextView title = ((FeedViewHolder) holder).title;
            TextView channel = ((FeedViewHolder) holder).channel;
            TextView countV = ((FeedViewHolder) holder).countV;
            TextView created = ((FeedViewHolder) holder).created;
            TextView time = ((FeedViewHolder) holder).time;

            video.setImageResource(item.getPhoto());
            profile.setImageResource(item.getProfile());
            title.setText(item.getTitle());
            channel.setText(item.getChannel()+" · ");
            countV.setText(item.getCount_views()+" · ");
            created.setText(item.getCreated());
            time.setText(item.getTime());
        }
        if (holder instanceof ShortsViewHolder){
            Feed shorts = items.get(position);

            RecyclerView rv_shorts = ((ShortsViewHolder) holder).rv_shorts;
            context = ((ShortsViewHolder) holder).itemView.getContext();

            rv_shorts.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            ShortsAdapter adapter = new ShortsAdapter(context, shorts.getList());
            rv_shorts.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder{
        ImageView video;
        ImageView profile;
        TextView title;
        TextView channel;
        TextView countV;
        TextView created;
        TextView time;
        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);
            video = itemView.findViewById(R.id.iv_video);
            profile = itemView.findViewById(R.id.iv_profile);
            title = itemView.findViewById(R.id.tv_title);
            channel = itemView.findViewById(R.id.tv_channel);
            countV = itemView.findViewById(R.id.tv_countV);
            created = itemView.findViewById(R.id.tv_created);
            time = itemView.findViewById(R.id.tv_videoTime);
        }
    }
    public class ShortsViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rv_shorts;

        public ShortsViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_shorts = itemView.findViewById(R.id.rv_shorts);
        }
    }
}
