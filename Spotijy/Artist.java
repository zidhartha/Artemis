public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    Album[] albums;
    Song[] singles;


    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.albums = albums;
        this.singles = singles;
    }

    public Song mostLikedSong() {
        if (albums == null || albums.length == 0) {
            return null;
        }
        Song popularSong = albums[0].mostLiked();
        int popular = albums[0].mostLiked().getLikes();
        for (int i = 0; i < albums.length; i++) {
            if (popular < albums[i].mostLiked().getLikes()) {
                popular = albums[i].mostLiked().getLikes();
                popularSong = albums[i].mostLiked();
            }
        }
        for (Song x : singles) {
            if (x.getLikes() > popular) {
                popularSong = x;
                popular = x.getLikes();
            }
        }
        return popularSong;
    }

    public Song leastLikedSong() {
        Song unpopularSong = albums[0].leastLiked();
        int unpopular = albums[0].leastLiked().getLikes();

        for (int i = 0; i < albums.length; i++) {
            if (unpopular > albums[i].leastLiked().getLikes()) {
                unpopularSong = albums[i].leastLiked();
                unpopular = albums[i].leastLiked().getLikes();
            }
        }
        for (Song x : singles) {
            if (x.getLikes() < unpopular) {
                unpopularSong = x;
                unpopular = x.getLikes();
            }
        }
        return unpopularSong;
    }

    public int totalLikes() {
        int temp = 0;
        for (Album album : albums) {
            temp += album.getAllLikes();
        }
        for (Song songs : singles) {
            temp += songs.getLikes();
        }
        return temp;
    }


    public boolean isEqual(Artist other){
        return this.lastName.equals(other.lastName) &&
                this.firstName.equals(other.firstName) &&
                this.birthYear == other.birthYear;
    }
    public String toString() {
        return "Artist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public Song[] getSingles() {
        return singles;
    }
}
