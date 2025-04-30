package com.example.aplikacija1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class CapitalCities {
    private String name, country, num_residents, size, major;
    public CapitalCities(String name, String country, String num_residents, String size, String major) {
        this.name = name;
        this.country = country;
        this.num_residents = num_residents;
        this.size = size;
        this.major = major;
    }

    public CapitalCities() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNum_residents() {
        return num_residents;
    }

    public void setNum_residents(String num_residents) {
        this.num_residents = num_residents;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public static CapitalCities parseJsonObject(JSONObject object) {
        CapitalCities list_of_capital_cities = new CapitalCities();
        try  {
            if (object.has("name")) {
                list_of_capital_cities.setName(object.getString("name"));
            }
            if (object.has("country")) {
                list_of_capital_cities.setCountry(object.getString("country"));
            }
            if (object.has("num_residents")) {
                list_of_capital_cities.setNum_residents(object.getString("num_residents"));
            }
            if (object.has("size")) {
                list_of_capital_cities.setSize(object.getString("size"));
            }
            if (object.has("major")) {
                list_of_capital_cities.setMajor(object.getString("major"));
            }
        } catch (Exception e) {}
        return list_of_capital_cities;
    }

    public static LinkedList<CapitalCities> parseJsonArray(JSONArray  array) {
        LinkedList<CapitalCities>  list_of_cities_to_be_set = new LinkedList<>();
        try {
            for (int i  =  0; i < array.length(); i++) {
                CapitalCities capitalCities =  parseJsonObject(array.getJSONObject(i));
                list_of_cities_to_be_set.add(capitalCities);
            }
        } catch (Exception e) {}
        return list_of_cities_to_be_set;
    }
}
