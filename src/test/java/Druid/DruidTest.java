package Druid;

import druid.project.mvc.Application;
import druid.project.mvc.domain.WikiTicker;
import druid.project.mvc.services.DruidService;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nichprud1 on 12/5/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class DruidTest {
    private Logger log = Logger.getLogger(DruidTest.class);

    @Autowired
    DruidService druidService;

    @Test
    public void searchByCountryName(){

        List<WikiTicker> dataList = druidService.searchByCountryName("United States");

        assertEquals(dataList.get(0).getPage(),"President of India");

     }

    @Test
    public void searchByCityName(){
    	
    	
    	
    	String home = "woodBury";
    	
        String city = "Minneapolis";

        List<WikiTicker> dataList = druidService.searchByCityName(city);

        String actual = dataList.get(0).getPage();

        String expected ="Austin High School (Minnesota)";

        assertEquals(expected,actual);
    }

    @Test
    public void searchByRegion(){
    //Cant find out what the problem is here...
        String regionName = "Provincia di Bologna";

        WikiTicker wikiTicker = new WikiTicker();

        List<WikiTicker> dataList = druidService.searchByRegionName(regionName);

        assertEquals(12, dataList.size());
    }


}




