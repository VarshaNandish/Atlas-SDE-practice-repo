package org.example.mapperdb;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Movies")
public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private int year;

    @DynamoDBHashKey(attributeName = "MovieId")
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    @DynamoDBRangeKey(attributeName = "Title")
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @DynamoDBAttribute(attributeName = "Genre")
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @DynamoDBAttribute(attributeName = "Year")
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}

