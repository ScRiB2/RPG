package parsing;

class Geo {
    String geoName;
    String geoId;
    int pop2013;
    int pop2014;
    int pop2015;
    int pop2016;

    Geo(String geoName, String geoId, int pop2013, int pop2014, int pop2015, int pop2016) {
        this.geoName = geoName;
        this.geoId = geoId;
        this.pop2013 = pop2013;
        this.pop2014 = pop2014;
        this.pop2015 = pop2015;
        this.pop2016 = pop2016;
    }

    int getDiff() {
        return pop2016 - pop2013;
    }

    int getForecast() {
        return ((pop2014 - pop2013) + (pop2015 - pop2014) + (pop2016 - pop2013)) / 3;
    }
}
