package pres;

import dao.IDao;
import métier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
/*
     injection des dépandances par
     instanciation dynamique =>couplage faible fermer a la modification ouvert a l'extension
     je peux ajouter une classe DaoImplVWS c'est une extension et il sufit d'aller vers config.txt
     et ajouter ext.DaoImplvWS
      */
public class pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scaner=new Scanner(new File("config.txt"));
        String doaClassName=scaner.nextLine();//connaitre le nom de la classe
        Class cDao=Class.forName(doaClassName);//charger la classe de memoire kaykon le type class
        IDao dao=(IDao)cDao.newInstance();//instancier la classe comme new ici dynamique
       // System.out.println((dao.getData()));

        String metierlassName=scaner.nextLine();//connaitre le nom de la classe
        Class cMetier=Class.forName(metierlassName);//charger la classe de memoire kaykon le type class
        IMetier metier=(IMetier) cMetier.newInstance();//instancier la classe comme new ici dynamique
        //je peux pas faire metier.setDao pour ca on afait methode
        Method method =cMetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao);//j'execute la methode //metier.setDao(dao); c'est la meme chose
        System.out.println("Resultat =>"+metier.calcule());
    }
}
