package com.example.lmbapp;

public class Client {

    private int idClient;
    private String nomClient;
    private String prenomClient;
    private int numeroClient;
    private String emailClient;
    private String adresseClient;
    private int codePostalClient;
    private String villeClient;

    public Client() {}

    public Client(int idClient, String nomClient, String prenomClient, String emailClient, int numeroClient, String adresseClient, int codePostalClient, String villeClient) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.emailClient = emailClient;
        this.numeroClient = numeroClient;
        this.adresseClient = adresseClient;
        this.codePostalClient = codePostalClient;
        this.villeClient = villeClient;
    }


}
