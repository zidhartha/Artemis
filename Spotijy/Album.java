import java.util.*;
import java.util.stream.Collectors;

public class Album {
    private String title;
    private Song[] songs;
    private int releaseYear;


    public Album(String title, int releaseYear, Song[] songs) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.songs = songs;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return this.title;
    }

    public Song[] getSongs() {
        return songs;
    }

    public int addSongs(Song[] songs1) {
        List<Song> x = Arrays.stream(songs).toList();
        List<Song> y = Arrays.stream(songs1).toList();
        for (Song z : y) {
            if (!x.contains(z)) {
                x.add(z);
            }
        }
        Song[] newSongs = new Song[x.size()];
        int i = 0;
        for (Song s : x) {
            songs[i] = s;
            i++;
        }
        return newSongs.length;
    }

    Song[] shuffle() {
        List<Song> x = new ArrayList<>(Arrays.stream(songs).toList());
        Collections.shuffle(x);

        return x.toArray(new Song[0]);
    }

    Song[] sortByTitle(boolean isAscending) {
        List<Song> x = Arrays.stream(this.songs).
                sorted(Comparator.comparing(Song::getTitle)).
                toList();
        if (isAscending) {
            return x.toArray(new Song[0]);
        }
        return x.stream().
                sorted(Comparator.comparing(Song::getTitle).reversed()).
                toArray(Song[]::new);
    }

    Song[] sortByPopularity(boolean isAscending) {
        List<Song> x = Arrays.stream(this.songs).
                sorted(Comparator.comparing(Song::getLikes)).
                toList();
        if (isAscending) {
            return x.toArray(new Song[0]);
        }
        return x.stream().
                sorted(Comparator.comparing(Song::getLikes).reversed()).
                toArray(Song[]::new);
    }

    Song[] sortByReleaseYear(boolean isAscending) {
        List<Song> x = Arrays.stream(this.songs).
                sorted(Comparator.comparing(Song::getReleaseYear)).
                toList();
        if (isAscending) {
            return x.toArray(new Song[0]);
        }
        return x.stream().
                sorted(Comparator.comparing(Song::getReleaseYear).reversed()).
                toArray(Song[]::new);
    }

    Song[] sortByDuration(boolean isAscending) {
        List<Song> x = Arrays.stream(this.songs).
                sorted(Comparator.comparing(Song::getDuration)).
                toList();
        if (isAscending) {
            return x.toArray(new Song[0]);
        }
        return x.stream().
                sorted(Comparator.comparing(Song::getDuration).reversed()).
                toArray(Song[]::new);
    }

    public static Song[] reverse(Song[] other) {
        List<Song> songs1 = Arrays.stream(other).toList();
        Collections.reverse(songs1);
        return songs1.toArray(new Song[0]);
    }

    public String toString() {
        return "Album{" +
                "releaseYear=" + releaseYear +
                ", songs=" + Arrays.toString(songs) +
                ", title='" + title + '\'' +
                '}';
    }

    public int getAllLikes() {
        if(songs.length == 0 || songs == null){
            return 0;
        }
        int temp = 0;
        for (int i = 0; i <songs.length;i++){
            temp+=songs[i].getLikes();
        }
        return temp;
    }

    public Song leastLiked(){
        if(songs.length == 0 || songs == null){
            return null;
        }
        Song[] x = this.sortByPopularity(true);
        return x[0];
    }

    public Song mostLiked(){
        if(songs.length == 0 || songs == null){
            return null;
        }
        Song[] temp = this.sortByPopularity(true);
        return temp[temp.length - 1];
    }
}

