import java.util.Arrays;
import java.util.Comparator;

public class Spotijy {
    private static Artist[] artists;

    public Spotijy(Artist[] artists){
        this.artists = artists;
    }

    public Artist[] getArtists() {
        return artists;
    }
    public void addArtists(Artist other){
        for (int i = 0; i < artists.length ; i++) {
            if(other == artists[i]){
                break;
        }
            Artist[] artist1 = new Artist[artists.length+1];
            artist1[artist1.length -1] = other;
            this.artists = artist1;
        }
    }

    public String[] getTopTrendingArtist(){
        if(artists.length == 0){
            return new String[]{"nuh","uh"};
        }
        Arrays.stream(artists).sorted(Comparator.comparing(Artist::totalLikes)).toArray(Artist[]::new);
        String[] x = new String[2];
        x[0] = artists[artists.length-1].getFirstName();
        x[1] = artists[artists.length -1].getLastName();
        return x;
    }

    public String getTopTrendingAlbum(){
        Album max = artists[0].getAlbums()[0];
        for(int i = 0; i< artists.length;i++){
            for (int j = 0; j < artists[i].albums.length ; j++) {
                if(artists[i].getAlbums()[j].getAllLikes() > max.getAllLikes()){
                    max = artists[i].getAlbums()[j];
                }
            }
        }
        return max.getTitle();
    }
    public String getTopTrendingSong(){
        if(artists.length == 0){
            return "You have no artists in your playlist";
        }
        Song bestSong = artists[0].getAlbums()[0].getSongs()[0];
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                for (Song song : album.getSongs()) {
                    if (bestSong == null || song.getLikes() > bestSong.getLikes()) {
                        bestSong = song;
                    }
                }
            }
            for(Song single : artist.getSingles()){
                if(bestSong == null || single.getLikes() > bestSong.getLikes()){
                    bestSong = single;
                }

            }
        }
        return bestSong.getTitle();
    }
}
