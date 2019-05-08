package com.wwy.domain;

public class District {
    private String id;//主键
    private String districtId;//区id
    private String cityIdId;//市id
    private String cityName;//市名称
    private String districtName;//区名称
    private String provinceNo;//省编号

    public District(String id, String districtId, String cityIdId, String cityName, String districtName, String provinceNo) {
        this.id = id;
        this.districtId = districtId;
        this.cityIdId = cityIdId;
        this.cityName = cityName;
        this.districtName = districtName;
        this.provinceNo = provinceNo;
    }

    public District() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getCityIdId() {
        return cityIdId;
    }

    public void setCityIdId(String cityIdId) {
        this.cityIdId = cityIdId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    @Override
    public String toString() {
        return "District{" +
                "id='" + id + '\'' +
                ", districtId='" + districtId + '\'' +
                ", cityIdId='" + cityIdId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", provinceNo='" + provinceNo + '\'' +
                '}';
    }
}


