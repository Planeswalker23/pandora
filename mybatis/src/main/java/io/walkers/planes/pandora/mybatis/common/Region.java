package io.walkers.planes.pandora.mybatis.common;

/**
 * 地区实体类
 *
 * @author planeswalker23
 */
public class Region {
    /**
     * 国家
     */
    private String country;
    /**
     * 地区
     */
    private String area;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Region{" +
                "country='" + country + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
