package uz.exemple.less57_youtubeui_white_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less57_youtubeui_white_java.R;
import uz.exemple.less57_youtubeui_white_java.model.Filter;


public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Filter> items;

    int EXPLORE_ITEM = 0;
    int FILTER_ITEM = 1;

    @Override
    public int getItemViewType(int position) {
        Filter item = items.get(position);
        if (item.getTitle().equals("Explore")){
            return EXPLORE_ITEM;
        }
        return FILTER_ITEM;
    }

    public FilterAdapter(Context context, ArrayList<Filter> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == EXPLORE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_exp,parent,false);
            return new ViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_filter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Filter item = items.get(position);
        holder.tv_filter.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_filter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_filter = itemView.findViewById(R.id.tv_title);

        }
    }
}
