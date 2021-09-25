package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import br.ufpr.andrekunde.travelexpenses.entities.Users;

public class CreateTravelDTO {

    private String status;
    private String origin;
    private String destination;
    private Double amount;
    private String reason;
    private Users user;
}
