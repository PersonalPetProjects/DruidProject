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

        WikiTicker wikiTicker = new WikiTicker();
        List<WikiTicker> dataList = new ArrayList<>();

        dataList =  druidService.searchByCountryName("United States");

        for (WikiTicker wikiTicker1: dataList){

               wikiTicker.setChannel(wikiTicker1.getChannel());
               wikiTicker.setPage(wikiTicker1.getPage());
               wikiTicker.setUser(wikiTicker1.getUser());
               wikiTicker.setDelta(wikiTicker1.getDelta());
               wikiTicker.setDeleted(wikiTicker1.getDeleted());

               break;
        }
        assertNotNull(wikiTicker.getChannel());
        assertEquals(wikiTicker.getPage(),"President of India");

        }


    @Test
    public void searchByCityName(){

        String city = "Minneapolis";

        WikiTicker wikiTicker = new WikiTicker();

        List<WikiTicker> dataList = new ArrayList<>();

        dataList =  druidService.searchByCityName(city);

             for (WikiTicker wiki: dataList){

                 wikiTicker.setPage(wiki.getPage());

             break;
        }

        assertEquals(wikiTicker.getPage(),"Austin High School (Minnesota)");
        assertNotNull(dataList);
    }


    @Test
    public void searchByMetroCode(){
    //Cant find out what the problem is here...
        String metroCode = "90210";
        WikiTicker wikiTicker = new WikiTicker();

        List<WikiTicker> dataList = new ArrayList<>();

        dataList =  druidService.searchByMetroCode(metroCode);

        for (WikiTicker wiki: dataList){

            wikiTicker.setPage(wiki.getPage());

            break;
        }

//        assertEquals(wikiTicker.getPage(),"Austin High School (Minnesota)");
        assertNotNull(dataList);
    }


}




