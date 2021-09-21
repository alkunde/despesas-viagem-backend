package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;

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

    private String reason;

    public Travel() {}

    public Travel(
            Long id,
            String status,
            String origin,
            String destination,
            Double amount,
            String reason
    ) {
        this.id = id;
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
        this.reason = reason;
    }

    public Travel(
            String status,
            String origin,
            String destination,
            Double amount,
            String reason
    ) {
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
        this.reason = reason;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        result = prime * result + ((reason == null) ? 0 : reason.hashCode());

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

        if (reason == null) {
            if (travel.reason != null) {
                return false;
            }
        } else if (!reason.equals(travel.reason)) {
            return false;
        }

        return true;
    }
}
