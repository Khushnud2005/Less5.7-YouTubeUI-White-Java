package uz.exemple.less57_youtubeui_white_java.model;

import java.util.ArrayList;

public class Feed {
    private int profile;
    private int photo;
    private String title;
    private String channel;
    private String count_views;
    private String time;
    private String created;
    private ArrayList<ShortsModel> shortsList;

    public Feed(String title, ArrayList<ShortsModel> shortsList) {
        this.title = title;
        this.shortsList = shortsList;
    }

    public Feed(int profile, int photo, String title, String channel, String count_views, String time, String created) {
        this.profile = profile;
        this.photo = photo;
        this.title = title;
        this.channel = channel;
        this.count_views = count_views;
        this.time = time;
        this.created = created;
    }

    public ArrayList<ShortsModel> getList() {
        return shortsList;
    }

    public String getTitle() {
        return title;
    }

    public String getChannel() {
        return channel;
    }

    public String getCount_views() {
        return count_views;
    }

    public String getTime() {
        return time;
    }

    public String getCreated() {
        return created;
    }

    public int getProfile() {
        return profile;
    }

    public int getPhoto() {
        return photo;
    }
}
