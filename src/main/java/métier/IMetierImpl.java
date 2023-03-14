package métier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier1")
public class IMetierImpl implements IMetier {
    //couplage faible
 @Autowired
 @Qualifier("dao2")
 /* pour faire l'injection des depandances on utilise  @Autowired si comme que
je demande a spring au moment au je vais instancier la classe metieripl cherche moi un objet
de type idao cherche parmi les objet que tu as deja créé si tu trouve un objet de type
idao tu vas me l'injecter dans cette variable dao automatiquement il fait l'injection
des depandances */
    private IDao dao;//objet non initialisé en java c'est null
//je peux pas faire new IDao psk c'est le couplage fort new=couplage fort

    //injecter dans la variable dao un objet d'une classe qui implémente l'interface IDao
/*public  IMetierImpl(IDao dao){//l'injection avec constructeur
    this.dao = dao;
}*/
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcule() {
        double tmp=dao.getData();//je sais pas si bd ou capteur ou web service
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
}
