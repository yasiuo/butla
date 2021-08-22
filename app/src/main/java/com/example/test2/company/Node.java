package com.example.test2.company;

public class Node {
    private String imie;
    private int waga;

    @Override
    public String toString() {
        return "Node{" +
                "imie='" + imie + '\'' +
                ", waga=" + waga +
                '}';
    }

    public Node(String imie) {
        this.imie = imie;
        this.waga = 1;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }
}
