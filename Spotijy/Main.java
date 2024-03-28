import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Making 4.5 album
        Song myBookOfRegrets = new Song("My Book of Regrets", 2016, 575, 1000);
        Song yearOfThePlague = new Song("Year of the Plague", 2016, 259, 150);
        Song happiness3 = new Song("Happiness III", 2016, 272, 352);
        Song sundayRainSetsIn = new Song("Sunday Rain Sets in", 2016, 236, 705);
        Song vermillioncore = new Song("Vermillioncore", 2016, 313, 800);
        Song[] songArr1 = {myBookOfRegrets, yearOfThePlague, happiness3, sundayRainSetsIn, vermillioncore};
        Album fourAndAHalf = new Album("4.5", 2016,songArr1);
        Song theIncident = new Song("The Incident", 2009, 575, 1000);
        Song octaneTwisted = new Song("Octane Twisted", 2009, 600, 12000);
        Song fearOfABlankPlanet = new Song("Fear of a Blank Planet", 2008, 450, 1200);
        Song myAshes = new Song("Fear of a Blank Planet", 2008, 309, 200);
        Song anesthetize = new Song("Anesthetize", 2008, 1072, 10000);
        Song sentimental = new Song("Sentimental", 2008, 332, 653);
        Song wayOutOfHere = new Song("Way out of Here", 2008, 457, 1201);
        Song sleepTogether = new Song("Sleep Together",2008,444,1567);
        Song[] songArr2 = {fearOfABlankPlanet, myAshes, anesthetize, sentimental, wayOutOfHere, sleepTogether};
        Album foabp = new Album("Fear of a Blank Planet", 2008, songArr2);
        Album[] stevensAlbums = {fourAndAHalf, foabp};
        Song[] single ={theIncident, octaneTwisted};
        Artist stevenWilson = new Artist("Steven", "Wilson", 1967, stevensAlbums, single);
        Song schizoidMan = new Song("21st century schizoid man", 1969, 600,1120125);
        Song crimsonCourt = new Song("ITCOTK", 1969, 602, 12005);
        Song starless = new Song("Starless", 1974, 600,200);
        Song red = new Song("red", 1974, 600, 10);
        Song[] songs = {schizoidMan, crimsonCourt};
        Album ITCOTCK = new Album("ITCOTCK",1969,songs);
        Song catFood = new Song("Cat food", 1970, 500, 4500);
        Song lizard = new Song("Lizard", 1970,720,120);
        Song[] singles = {red, starless};
        Song[] songs1 = {catFood, lizard};
        Album inTheWakeOfPoseidon = new Album("In the wake of poseidon", 1969,songs1);
        Album[] albums = {inTheWakeOfPoseidon, ITCOTCK};
        Artist kingCrimson = new Artist("King", "Crimson", 1969, albums, singles);
        Artist[] artists = {stevenWilson, kingCrimson};
        Spotijy spotiJy = new Spotijy(artists);
        System.out.println(spotiJy.getTopTrendingSong());
        System.out.println(spotiJy.getTopTrendingArtist().toString());
        System.out.println(Arrays.toString(songs1));
        System.out.println(inTheWakeOfPoseidon.mostLiked());
        System.out.println(Arrays.toString(spotiJy.getArtists()));
    }
}