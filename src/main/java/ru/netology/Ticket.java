package ru.netology;

public class Ticket implements Comparable<Ticket>{
    protected int id;
    protected int price;
    protected String airportDeparture;
    protected String airportArrival;
    protected int tripTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(String airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(String airportArrival) {
        this.airportArrival = airportArrival;
    }

    public int getTripTime() {
        return tripTime;
    }

    public void setTripTime(int tripTime) {
        this.tripTime = tripTime;
    }



    public Ticket(int id, int price, String airportDeparture, String airportArrival, int tripTime) {
        this.id = id;
        this.price = price;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
        this.tripTime = tripTime;
    }



    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
        return 0;
        }
    }
}

