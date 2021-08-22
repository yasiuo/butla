package com.example.test2.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LosingMachine {

    public static ArrayList<Node> ludzie = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public LosingMachine(){

    }

    public  void dodGracz(String imie){
        ludzie.add(new Node(imie));
    }

    public ArrayList<Node> getLudzie(){
        return ludzie;
    }

    public String los(){
        return losuj();
    }

//    public static void main(String[] args) {
//        System.out.println("podaj liczbe graczy");
//        int liczba = scan.nextInt();
//
//        genLista(liczba);
//        for (int i=0;i<30;i++){
//            System.out.println("wylosowano :" + losuj());
//        }
//
//    }

    static void genLista(int ile){
        for (int i=0;i<ile;i++){
            System.out.println("podaj imie gracza [" + (i+1) + "]");
            String imie = scan.next();
            ludzie.add(new Node(imie));
        }
        showList();
    }

    static String losuj(){
        ArrayList<String> pula = new ArrayList<>();
        for (Node x : ludzie) {
            for (int i=0;i<x.getWaga();i++){
                pula.add(x.getImie());
            }
            x.setWaga(x.getWaga()+1);
        }

        Collections.shuffle(pula);
        String zwrot = pula.get(0);
        for (Node x : ludzie){
            if (x.getImie().equals(zwrot)) x.setWaga(0);
        }

        return zwrot;
    }

    static void showList(){
        for(Node x : ludzie){
            System.out.println(x);
        }
    }


}
