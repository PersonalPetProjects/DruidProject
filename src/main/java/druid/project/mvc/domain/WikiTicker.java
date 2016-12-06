package druid.project.mvc.domain;

import java.sql.Time;

/**
 * Created by nichprud1 on 12/5/2016.
 */
public class WikiTicker {

    public Time time = null;
    public String channel = "";
    public String comment = "";
    public String countryIsoCode = "";
    public String countryName = "";
    public Boolean isAnoymous = false;
    public Boolean isMinor = false;
    public Boolean isNew = false;
    public Boolean isUnpatrolled = false;
    public String metroCode = "";
    public String nameSpace = "";
    public String page = "";
    public String regionIsoCode = "";
    public String cityName;
    public String user = "";
    public Integer delta = 0;
    public Integer added = 0;
    public Integer deleted = 0;

    public WikiTicker() {}

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public int getAdded() {
        return added;
    }

    public void setAdded(Integer added) {
        this.added = added;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    public String getRegionIsoCode() {
        return regionIsoCode;
    }

    public void setRegionIsoCode(String regionIsoCode) {
        this.regionIsoCode = regionIsoCode;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getMetroCode() {
        return metroCode;
    }

    public void setMetroCode(String metroCode) {
        this.metroCode = metroCode;
    }

    public boolean isUnpatrolled() {
        return isUnpatrolled;
    }

    public void setUnpatrolled(Boolean isUnpatrolled) {
        this.isUnpatrolled = isUnpatrolled;
    }

    public boolean isMinor() {
        return isMinor;
    }

    public void setMinor(Boolean isMinor) {
        this.isMinor = isMinor;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isAnoymous() {
        return isAnoymous;
    }

    public void setAnoymous(Boolean isAnoymous) {
        this.isAnoymous = isAnoymous;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
