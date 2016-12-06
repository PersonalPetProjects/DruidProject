package druid.project.mvc.services;

import druid.project.mvc.domain.WikiTicker;


import java.util.List;

/**
 * Created by nichprud1 on 12/5/2016.
 */
public interface DruidService {


    public List<WikiTicker> searchByCountryName(String countryName);

    public List<WikiTicker> searchByCityName(String cityName);

    public List<WikiTicker> searchByMetroCode(String metroCode);





}
