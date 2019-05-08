package com.wwy.domain;

public class City {
    private String id;
    private String cityId;
    private String provinceId;
    private String name;

    public City() {
    }

    public City(String id, String cityId, String provinceId, String name) {
        this.id = id;
        this.cityId = cityId;
        this.provinceId = provinceId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", cityId='" + cityId + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
