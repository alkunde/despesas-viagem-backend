package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import br.ufpr.andrekunde.travelexpenses.entities.Users;

public class CreateTravelDTO {

    private String origin;
    private String destination;
    private int departureYear, departureMonth, departureDay;
    private int arrivalYear, arrivalMonth, arrivalDay;
    private Double amount;
    private String reason;
    private Users user;

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getDepartureYear() {
        return departureYear;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public int getArrivalYear() {
        return arrivalYear;
    }

    public int getArrivalMonth() {
        return arrivalMonth;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public Double getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    public Users getUser() {
        return user;
    }
}
