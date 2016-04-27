package com.company;

import DataAccessLayer.ConnectionModule;
import DataAccessLayer.DataProvider;
import Objects.City;
import Objects.Country;
import Objects.CountryLanguage;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ConnectionModule());

        DataProvider dp = injector.getInstance(DataProvider.class);
        dp.getData("Select * from b1tj0tfe4jfdirv1.Country", new Country.CountryFactory());
    }
}
