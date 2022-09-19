package uz.exemple.less57_youtubeui_white_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import uz.exemple.less57_youtubeui_white_java.adapter.FeedAdapter;
import uz.exemple.less57_youtubeui_white_java.adapter.FilterAdapter;
import uz.exemple.less57_youtubeui_white_java.model.Feed;
import uz.exemple.less57_youtubeui_white_java.model.Filter;
import uz.exemple.less57_youtubeui_white_java.model.ShortsModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerFilter;
    RecyclerView recyclerFeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        recyclerFilter = findViewById(R.id.recyclerFilter);
        recyclerFilter.setLayoutManager(new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );
        recyclerFeed = findViewById(R.id.recyclerFeed);
        recyclerFeed.setLayoutManager(new GridLayoutManager(this, 1));

        refreshFilterAdapter(getAllFilters());
        refreshFeedAdapter(getAllFeeds());
    }

    void refreshFilterAdapter(ArrayList<Filter> filters ) {
        FilterAdapter adapter = new FilterAdapter(this, filters);
        recyclerFilter.setAdapter(adapter);
    }

    void refreshFeedAdapter(ArrayList<Feed> feeds ) {
        FeedAdapter adapter = new FeedAdapter(this, feeds);
        recyclerFeed.setAdapter(adapter);
    }

    ArrayList<Filter> getAllFilters()  {
        ArrayList<Filter> filters =new  ArrayList();
        filters.add(new Filter("Explore"));
        filters.add(new Filter("Computer Programming"));
        filters.add(new Filter("Android Native"));
        filters.add(new Filter("Mobile Development"));
        return filters;
    }

    ArrayList<Feed> getAllFeeds()  {
        ArrayList<Feed> feeds = new ArrayList<Feed>();
        feeds.add(new Feed(R.drawable.profile1, R.drawable.fon1,"QAYTISH seriali I: Bu tush emas, SON!/ Xvicha “Milan”ni xivichladi/ Hujumchi Noyer/ #allegriout ","Xayrulla HAMIDOV","7k views","22:02","15 hour ago"));
        feeds.add(new Feed("Shorts",getShorts()));
        feeds.add(new Feed(R.drawable.profile2, R.drawable.fon2,"How to Make a Clean Architecture Note App (MVVM / CRUD / Jetpack Compose) - Android Studio Tutorial","Philipp Lackner","158k views","2:23:58","1 year ago"));
        feeds.add(new Feed(R.drawable.profile3, R.drawable.fon3,"Studentlar dardi\uD83D\uDE02","Sariq Bola TV","208k views","2:12","1 week ago"));
        feeds.add(new Feed(R.drawable.profile4, R.drawable.fon4,"O‘zbekistondagi ta’lim illyuziyasi – Oliy ta’lim | SUBYEKTIV","SUBYEKTIV","990k views","1:19:14","2 weeks ago"));
        feeds.add(new Feed(R.drawable.profile5, R.drawable.fon5,"Laravel 9 Ecom - Part 40: Checkout Updates | Checkout place order in laravel 9 livewire","Funda of Web IT","363 views","12:19","3 days ago"));
        feeds.add(new Feed(R.drawable.profile6, R.drawable.fon6,"Gelsin Hayat Bildiği Gibi - 9.Bölüm","Gelsin Hayat","4M 573k views","2:20:04","3 days ago"));
        return feeds;
    }
    ArrayList<ShortsModel> getShorts(){
        ArrayList<ShortsModel> shorts = new ArrayList<>();
        shorts.add(new ShortsModel(R.drawable.short1,"Real or Fake","872k views"));
        shorts.add(new ShortsModel(R.drawable.short2,"Depresyondayım, Unutuldum, Aldatıldım İçeceği","203k views"));
        shorts.add(new ShortsModel(R.drawable.short3,"Hünkârbeğendi \uD83D\uDE0D","1.5k views"));
        shorts.add(new ShortsModel(R.drawable.short1,"Real or Fake","872k views"));
        shorts.add(new ShortsModel(R.drawable.short2,"Depresyondayım, Unutuldum, Aldatıldım İçeceği","203k views"));
        shorts.add(new ShortsModel(R.drawable.short3,"Hünkârbeğendi \uD83D\uDE0D","1.5k views"));
        shorts.add(new ShortsModel(R.drawable.short2,"Depresyondayım, Unutuldum, Aldatıldım İçeceği","203k views"));
        shorts.add(new ShortsModel(R.drawable.short3,"Hünkârbeğendi \uD83D\uDE0D","1.5k views"));

        return shorts;
    }
}