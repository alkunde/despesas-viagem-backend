package ufpr.andrekunde.despesasviagem.requests.session;

public class SessionPostRequest {

    private String email;

    public SessionPostRequest() {
    }

    public SessionPostRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
