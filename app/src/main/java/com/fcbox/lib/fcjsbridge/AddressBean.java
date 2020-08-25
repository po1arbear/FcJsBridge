package com.fcbox.lib.fcjsbridge;

import java.io.Serializable;

public class AddressBean implements Serializable {

    private double latitude;
    private double longitude;
    private String address;
    private String distCode;
    private String distName;
    private String siteType;
    private String province;
    private String city;
    private String area;
    private String name;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address == null ? "" : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistCode() {
        return distCode == null ? "" : distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

    public String getDistName() {
        return distName == null ? "" : distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public String getSiteType() {
        return siteType == null ? "" : siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getProvince() {
        return province == null ? "" : province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city == null ? "" : city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area == null ? "" : area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}