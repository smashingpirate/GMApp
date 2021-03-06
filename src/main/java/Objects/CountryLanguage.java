package Objects;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CountryLanguage implements PropertiesExtractor{

    private String countryCode;
    private String language;
    private boolean isOfficial;
    private double percent;

    public CountryLanguage(String countryCode, String language, boolean isOfficial, double percent) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percent = percent;
    }

    private CountryLanguage() {}

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public CountryLanguage extract(ResultSet rs, ResultSetMetaData rsmd) {
        try {
            CountryLanguage cL = new CountryLanguage();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                String prop = rsmd.getColumnLabel(i);
                if (prop.equals("CountryCode")) {
                    this.countryCode = rs.getString(i);
//                    System.out.println(name);
                } else if (prop.equals("Language")) {
                    this.language = rs.getString(i);
                } else if (prop.equals("IsOfficial")) {
                    this.isOfficial = rs.getBoolean(i);
                } else if (prop.equals("Percentage")) {
                    this.percent = rs.getDouble(i);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new CountryLanguage(this.countryCode, this.language, this.isOfficial, this.percent);
    }

    public static class CountryLanguageFactory implements Factory<CountryLanguage>{
        public CountryLanguage create() {
            return new CountryLanguage();
        }
    }
}
