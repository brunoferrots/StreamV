package com.lychee.streamv.domain.movie;

public class Movie {
    private String name;
    private Integer duration;
    private Integer releaseYear;
    private String category;

    public Movie(MovieDTO movieDTO) {
        this.name = movieDTO.name();
        this.duration = movieDTO.duration();
        this.releaseYear = movieDTO.year();
        this.category = movieDTO.category();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", releaseYear=" + releaseYear +
                ", category='" + category + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
