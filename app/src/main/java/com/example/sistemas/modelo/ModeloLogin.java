package com.example.sistemas.modelo;

public class ModeloLogin {
    private String username;
    private String password;
    private String passe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }

    @Override
    public String toString() {
        return "ModeloLogin{" +
                "passe='" + passe + '\'' +
                '}';
    }
}
