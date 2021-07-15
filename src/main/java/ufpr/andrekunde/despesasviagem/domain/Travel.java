package ufpr.andrekunde.despesasviagem.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;
    private @Temporal(TemporalType.DATE) Date departureDate;
    private @Temporal(TemporalType.DATE) Date arrivalDate;
    private double advancedAmount;
    private String reason;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Travel() {
    }

    public Travel(
            Long id,
            String origin,
            String destination,
            Date departureDate,
            Date arrivalDate,
            double advancedAmount,
            String reason,
            String status,
            User user
    ) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.advancedAmount = advancedAmount;
        this.reason = reason;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getAdvancedAmount() {
        return advancedAmount;
    }

    public void setAdvancedAmount(double advancedAmount) {
        this.advancedAmount = advancedAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
