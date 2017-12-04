package wachi.adoptiontest.manager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import wachi.adoptiontest.pojo.CountryInfo;
import wachi.adoptiontest.pojo.RegionsData;

/**
 * Created by Usagi on 2017/12/1.
 */

public class DataManager {
    static private DataManager instance;

    static public DataManager getInstance(){
        if(instance == null){
            instance = new DataManager();
        }

        return instance;
    }

    public RegionsData getRegionsData(String jsonStr){
        RegionsData regionsData;
        Gson gson = new Gson();
        regionsData = gson.fromJson(jsonStr, RegionsData.class);

        return regionsData;
    }
}
