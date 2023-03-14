package pres;

import métier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Pressprinversannota {
      public static void main(String[] args){
          ApplicationContext context=new AnnotationConfigApplicationContext("dao","métier");//je lui ai dis de me scanner les packages que je lui ecris
          IMetier metier=(IMetier) context.getBean(IMetier.class);//je lui ai dis donne moi un bean qui implemente l'interface IMetier
          System.out.println(metier.calcule());
      }
}
