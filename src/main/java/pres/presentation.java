package pres;

import ext.DaoImpl2;
import métier.IMetierImpl;
//cette couche est la seule qui est ouvert a la modification donc l'app n'est pas à 100% couplage faible
public class presentation {
    public static void main(String[] args){
        /*
        injection des dépandances par
        instanciation statique =>new(couplage fort =poubele)
         */
        DaoImpl2 dao=new DaoImpl2();
        //DaOImpl dao=new DaOImpl();//injection des dépandances
     //  IMetierImpl metier=new IMetierImpl(dao);//injection des dépandances
      IMetierImpl metier=new IMetierImpl();
      metier.setDao(dao);//injection des dépandances
        System.out.println("Résultat est :"+metier.calcule());
    }
}
