package uz.exemple.less57_youtubeui_white_java.model;

public class ShortsModel {
    private int image_short;
    private String title;
    private String view_count;

    public ShortsModel(int image_short, String title, String view_count) {
        this.image_short = image_short;
        this.title = title;
        this.view_count = view_count;
    }

    public int getImage_short() {
        return image_short;
    }

    public String getTitle() {
        return title;
    }

    public String getView_count() {
        return view_count;
    }
}
