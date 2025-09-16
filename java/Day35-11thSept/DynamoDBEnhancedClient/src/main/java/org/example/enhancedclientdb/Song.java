package org.example.enhancedclientdb;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;
import java.util.Objects;

@DynamoDbBean
public class Song {
    private String songId;   // partition key
    private String title;    // sort key
    private String artist;
    private String album;
    private Integer year;
    private String genre;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("SongId")
    public String getSongId() { return songId; }
    public void setSongId(String songId) { this.songId = songId; }

    @DynamoDbSortKey
    @DynamoDbAttribute("Title")
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @DynamoDbAttribute("Artist")
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    @DynamoDbAttribute("Album")
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    @DynamoDbAttribute("Year")
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    @DynamoDbAttribute("Genre")
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    // equals/hashCode/toString (optional but recommended)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(songId, song.songId) && Objects.equals(title, song.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, title);
    }

    @Override
    public String toString() {
        return "Song{" + "songId='" + songId + '\'' + ", title='" + title + '\'' + ", artist='" + artist + '\'' + ", album='" + album + '\'' + ", year=" + year + ", genre='" + genre + '\'' + '}';
    }
}
