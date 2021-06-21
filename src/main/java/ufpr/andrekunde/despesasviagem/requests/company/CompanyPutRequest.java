package ufpr.andrekunde.despesasviagem.requests.company;

public class CompanyPutRequest {

    private Long id;
    private String fantasyName;
    private String address;

    public CompanyPutRequest() {
    }

    public CompanyPutRequest(Long id, String fantasyName, String address) {
        this.id = id;
        this.fantasyName = fantasyName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
