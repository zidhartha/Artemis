public class Song {
    private String title;
    private double duration;
    private int releaseYear;
    private int likes;

    public Song(String title,int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
        duration = 60;
        likes = 0;
    }
    public Song(String title,int releaseYear,double duration){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        likes = 0;
    }

    public Song(String title,int releaseYear,double duration,int likes){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public double getDuration() {
        return duration;
    }

    public int getLikes() {
        return likes;
    }
    public int getReleaseYear(){
        return releaseYear;
    }
    public String getTitle() {
        return title;
    }

    public boolean changeDuration(int otherDuration){
        if(otherDuration <= 0 || otherDuration>720){
            return false;
        }
        this.duration = otherDuration;
        return true;
    }

    void like(){
        this.likes++;
    }
    void unlike() {
        if(this.likes != 0){
            this.likes--;
        }
    }

    public String toString(){
        return "Title: " + this.title + ",Duration: " + this.duration/60 +
                ", Release Year: " + this.releaseYear + ", Likes: "+ this.likes;
    }

    public boolean isEqual(Song other){
        return this.title.equals(other.title) &&
                this.releaseYear == other.releaseYear &&
                this.duration == other.duration;
    }
}
