package ufpr.andrekunde.despesasviagem.requests.travel;

import ufpr.andrekunde.despesasviagem.domain.User;

import java.util.Date;

public class TravelPostRequest {

    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String reason;
    private Double advancedAmout;
    private User user;

    public TravelPostRequest() {
    }

    public TravelPostRequest(
            String origin,
            String destination,
            Date departureDate,
            Date arrivalDate,
            String reason,
            Double advancedAmout,
            User user
    ) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.reason = reason;
        this.advancedAmout = advancedAmout;
        this.user = user;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getAdvancedAmout() {
        return advancedAmout;
    }

    public void setAdvancedAmout(Double advancedAmout) {
        this.advancedAmout = advancedAmout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
