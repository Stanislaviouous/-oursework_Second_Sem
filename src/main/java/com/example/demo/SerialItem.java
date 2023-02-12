package com.example.demo;

import java.util.ArrayList;
public class SerialItem implements Comparable<SerialItem>{
    private String title, // название
            photoUrl, // ссылка на картинку
            year; // год выпуска
    private int id, // номер
            seasons, // количество сезонов
            series, // количество серий
            duration; // длительность эпизода
    private double rating; // рейтинг
    private ArrayList<String> genre; // жанры
    private String link; // ссылка
    public SerialItem(String title, String photoUrl, String year, int id, int seasons, int series, int duration, double rating, ArrayList<String> genre, String link) throws Exception {
        setTitle(title);;
        setPhotoUrl(photoUrl);
        setId(id);
        setYear(year);
        setRating(rating);
        setSeasons(seasons);
        setSeries(series);
        setDuration(duration);
        setGenre(genre);
        setLink(link);
    }
    public void setYear(String year) throws Exception {
        if (year.isBlank()) {
            throw new Exception("Blank!");
        }
        this.year = year;
    }
    public void setRating(double rating) throws Exception {
        if (year.isBlank()) {
            throw new Exception("Blank!");
        }
        this.rating = rating;
    }
    public String getYear() {
        return year;
    }
    public double getRating() {
        return rating;
    }
    public SerialItem(){

    }
    public String getTitle() {
        return title;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public int getId() {
        return id;
    }
    public int getSeasons() {
        return seasons;
    }
    public int getSeries() {
        return series;
    }
    public int getDuration() {
        return duration;
    }
    public ArrayList<String> getGenre() {
        return genre;
    }
    public String getLink() {
        return link;
    }
    public void setTitle(String title) throws Exception {
        if (title.isBlank()) {
            throw new Exception("Blank!");
        }
        this.title = title;
    }
    public void setPhotoUrl(String photoUrl) throws Exception {
        if (!photoUrl.startsWith("https://")) {
            throw new Exception("Url must start with 'https://'");
        }
        this.photoUrl = photoUrl;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSeasons(int seasons) throws Exception {
        if (seasons < 2) {
            throw new Exception("More seasons!");
        }
        this.seasons = seasons;
    }
    public void setSeries(int series) throws Exception {
        if (series < 5) {
            throw new Exception("More series!");
        }
        this.series = series;
    }
    public void setDuration(int duration) throws Exception {
        if (duration < 24) {
            throw new Exception("It is not anime!");
        }
        this.duration = duration;
    }
    public void setGenre(ArrayList<String> genre) throws Exception {
        if (genre.size() < 1) {
            throw new Exception("Minimum size is 1");
        }
        this.genre = genre;
    }
    public void setLink(String link) throws Exception {
        if (!link.startsWith("https://")) {
            throw new Exception("Link must start with 'https://'");
        }
        this.link = link;
    }
    @Override
    public int compareTo(SerialItem o) {
        if (this.id >= o.id) {
            return 1;
        }
        return 0;
    }
}
