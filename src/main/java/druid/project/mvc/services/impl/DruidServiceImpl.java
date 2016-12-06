package druid.project.mvc.services.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.metamx.common.guava.Sequence;
import com.metamx.common.guava.Sequences;
import druid.project.mvc.domain.WikiTicker;
import druid.project.mvc.druid.query.DruidClient;
import druid.project.mvc.services.DruidService;
import io.druid.query.Druids;
import io.druid.query.Result;
import io.druid.query.filter.AndDimFilter;
import io.druid.query.filter.DimFilter;
import io.druid.query.filter.SelectorDimFilter;
import io.druid.query.select.EventHolder;
import io.druid.query.select.PagingSpec;
import io.druid.query.select.SelectQuery;
import io.druid.query.select.SelectResultValue;
import org.apache.log4j.Logger;
import org.joda.time.Interval;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nichprud1 on 12/5/2016.
 */
@Service
public class DruidServiceImpl implements DruidService {
    @Value("${druid.host}")
    String DRUIDHOST;
    private Logger log = Logger.getLogger(DruidServiceImpl.class);

    @Override
    public List<WikiTicker> searchByCountryName(String countryName) {
        List<WikiTicker> dataList = new ArrayList<>();

        try (final DruidClient druidClient = DruidClient.create(DRUIDHOST)) {
            // Create a simple select query using the Druids query builder.
            final int threshold = 50;
            final SelectQuery selectQuery = Druids
                    .newSelectQueryBuilder()
                    .dataSource("wikiticker")
                    .intervals(ImmutableList.of(new Interval("1000/3000")))
                    .filters(
                            new AndDimFilter(
                                    ImmutableList.<DimFilter>of(
                                            new SelectorDimFilter("countryName", countryName, null)
                                    )
                            )
                    )
                    .dimensions(ImmutableList.of("page", "user"))
                    .pagingSpec(new PagingSpec(null, threshold))
                    .build();

            final Sequence<Result<SelectResultValue>> resultSequence = druidClient.execute(selectQuery);


            final List<Result<SelectResultValue>> resultList = Sequences.toList(resultSequence, Lists.<Result<SelectResultValue>>newArrayList());


            dataList = returnDataList(resultList);


        } catch (Exception e) {
            System.out.println(e);

        }
        printDataList(dataList);
        return dataList;

    }

    @Override
    public List<WikiTicker> searchByCityName(String cityName) {
        List<WikiTicker> dataList = new ArrayList<>();

        try (final DruidClient druidClient = DruidClient.create(DRUIDHOST)) {
            // Create a simple select query using the Druids query builder.
            final int threshold = 50;
            final SelectQuery selectQuery = Druids
                    .newSelectQueryBuilder()
                    .dataSource("wikiticker")
                    .intervals(ImmutableList.of(new Interval("1000/3000")))
                    .filters(
                            new AndDimFilter(
                                    ImmutableList.<DimFilter>of(
                                            new SelectorDimFilter("cityName", cityName, null)
                                    )
                            )
                    )
                    .dimensions(ImmutableList.of("page", "user"))
                    .pagingSpec(new PagingSpec(null, threshold))
                    .build();

            final Sequence<Result<SelectResultValue>> resultSequence = druidClient.execute(selectQuery);

            final List<Result<SelectResultValue>> resultList = Sequences.toList(resultSequence, Lists.<Result<SelectResultValue>>newArrayList());

            dataList = returnDataList(resultList);
            printDataList(dataList);
        } catch (Exception e) {
            System.out.println(e);

        }

        return dataList;
    }

    public List<WikiTicker> searchByRegionName(String regionName) {
        List<WikiTicker> dataList = new ArrayList<>();

        try (final DruidClient druidClient = DruidClient.create(DRUIDHOST)) {
            // Create a simple select query using the Druids query builder.
            final int threshold = 50;
            final SelectQuery selectQuery = Druids
                    .newSelectQueryBuilder()
                    .dataSource("wikiticker")
                    .intervals(ImmutableList.of(new Interval("1000/3000")))
                    .filters(
                            new AndDimFilter(
                                    ImmutableList.<DimFilter>of(
                                            new SelectorDimFilter("regionName", regionName, null)
                                    )
                            )
                    )
                    .dimensions(ImmutableList.of("page", "user"))
                    .pagingSpec(new PagingSpec(null, threshold))
                    .build();

            final Sequence<Result<SelectResultValue>> resultSequence = druidClient.execute(selectQuery);

            final List<Result<SelectResultValue>> resultList = Sequences.toList(resultSequence, Lists.<Result<SelectResultValue>>newArrayList());

            dataList = returnDataList(resultList);
            printDataList(dataList);
        } catch (Exception e) {
            System.out.println(e);

        }

        return dataList;
    }

    //Build data list
    public List<WikiTicker> returnDataList(List<Result<SelectResultValue>> resultList) {
        List<WikiTicker> dataList = new ArrayList<>();
        for (final Result<SelectResultValue> result : resultList) {

            for (EventHolder eventHolder : result.getValue().getEvents()) {

                JSONObject jObject = new JSONObject(eventHolder.getEvent());

                dataList.add(wikiTicker(jObject));
            }
        }
        return dataList;
    }

    //Build up JSON object
    public WikiTicker wikiTicker(JSONObject jsonObject) {

        WikiTicker wikiTicker = new WikiTicker();


        wikiTicker.setPage(jsonObject.getString("page"));
        wikiTicker.setAdded(jsonObject.getInt("added"));
        wikiTicker.setUser(jsonObject.getString("user"));
        wikiTicker.setDelta(jsonObject.getInt("delta"));
        wikiTicker.setDeleted(jsonObject.getInt("deleted"));


        return wikiTicker;
    }

    //Print results
    public void printDataList(List<WikiTicker> dataList){
//        WikiTicker wikiTicker = new WikiTicker();
        for (WikiTicker wiki: dataList){
            System.out.println("Page: " + wiki.getPage());
            System.out.print(" Added: " + wiki.getAdded());
            System.out.print(" Delta: " + wiki.getDelta());
            System.out.print(" Deleted: " + wiki.getDeleted());
            System.out.print(" User: " + wiki.getUser());
        }
    }



}
