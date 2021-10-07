package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String origin;
    private String destination;

    @Column(precision = 10, scale = 2)
    private Double amount;

    private @Temporal(TemporalType.TIMESTAMP)
    Date departureDate;

    private @Temporal(TemporalType.TIMESTAMP)
    Date arrivalDate;

    private String reason;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cost_center_id")
    private CostCenter costCenter;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private Users user;

    public Travel() {}

    public Travel(
            Long id,
            String status,
            String origin,
            String destination,
            Double amount,
            Date departureDate,
            Date arrivalDate,
            String reason,
            CostCenter costCenter,
            Users user
    ) {
        this.id = id;
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.reason = reason;
        this.costCenter = costCenter;
        this.user = user;
    }

    public Travel(
            String status,
            String origin,
            String destination,
            Double amount,
            Date departureDate,
            Date arrivalDate,
            String reason,
            CostCenter costCenter,
            Users user
    ) {
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.reason = reason;
        this.costCenter = costCenter;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
        result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
        result = prime * result + ((reason == null) ? 0 : reason.hashCode());
        result = prime * result + ((costCenter == null) ? 0 : costCenter.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Travel travel = (Travel) obj;
        if (id == null) {
            if (travel.id != null) {
                return false;
            }
        } else if (!id.equals(travel.id)) {
            return false;
        }

        if (status == null) {
            if (travel.status != null) {
                return false;
            }
        } else if (!status.equals(travel.status)) {
            return false;
        }

        if (origin == null) {
            if (travel.origin != null) {
                return false;
            }
        } else if (!origin.equals(travel.origin)) {
            return false;
        }

        if (destination == null) {
            if (travel.destination != null) {
                return false;
            }
        } else if (!destination.equals(travel.destination)) {
            return false;
        }

        if (amount == null) {
            if (travel.amount != null) {
                return false;
            }
        } else if (!amount.equals(travel.amount)) {
            return false;
        }

        if (departureDate == null) {
            if (travel.departureDate != null) {
                return false;
            }
        } else if (!departureDate.equals(travel.departureDate)) {
            return false;
        }

        if (arrivalDate == null) {
            if (travel.arrivalDate != null) {
                return false;
            }
        } else if (!arrivalDate.equals(travel.arrivalDate)) {
            return false;
        }

        if (reason == null) {
            if (travel.reason != null) {
                return false;
            }
        } else if (!reason.equals(travel.reason)) {
            return false;
        }

        if (costCenter == null) {
            if (travel.costCenter != null) {
                return false;
            }
        } else if (!costCenter.equals(travel.costCenter)) {
            return false;
        }

        if (user == null) {
            if (travel.user != null) {
                return false;
            }
        } else if (!user.equals(travel.user)) {
            return false;
        }

        return true;
    }
}
