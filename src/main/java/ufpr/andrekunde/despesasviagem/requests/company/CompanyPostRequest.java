package ufpr.andrekunde.despesasviagem.requests.company;

public class CompanyPostRequest {

    private String fantasyName;
    private String address;

    public CompanyPostRequest() {
    }

    public CompanyPostRequest(String fantasyName, String address) {
        this.fantasyName = fantasyName;
        this.address = address;
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
