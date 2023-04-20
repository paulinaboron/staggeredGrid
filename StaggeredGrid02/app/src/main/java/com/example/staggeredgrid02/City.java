package com.example.staggeredgrid02;

//https://mocki.io/v1/8cd48005-d2aa-42b7-9cab-aa073894d940

public class City {
    private String name;
    private String url;

    public City(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
