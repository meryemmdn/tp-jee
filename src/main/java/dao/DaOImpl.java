package dao;

import org.springframework.stereotype.Component;

@Component("dao2")
public class DaOImpl implements IDao{
    @Override
    public double getData() {
        /*
        Se connecter à la BD pour récupérer la température
         */
        System.out.println("base de donné");
        double temp=Math.random()*40;
        return temp;
    }
}
