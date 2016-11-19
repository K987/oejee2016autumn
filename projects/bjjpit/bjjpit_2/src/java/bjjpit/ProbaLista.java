package bjjpit;

import bjjpit.people;
import java.util.ArrayList;
import java.util.List;

public class ProbaLista{
    private static final List<people> PplList =new ArrayList();
    
    
    static
    {
        PplList.add(new people("Bob Ross",42,"Blackbelt",180,92,10,0,1,"Tatami"));
        PplList.add(new people("Eddie Bravo",39,"Blackbelt",160,62,32,2,2,"Lucky"));
        PplList.add(new people("Rickson Gracie",20,"Brownbelt",175,86,13,3,3,"Venum"));
        PplList.add(new people("Meckenzie Dern",23,"Purplebelt",168,49,101,2,4,"Venum"));
        PplList.add(new people("Gabi Garcia",30,"Blackbelt",192,92,10,0,5,"360"));
        

    }
    private ProbaLista()
    {
        
    }

    public static List <people> getInstance(){
        return PplList;
    }

    
}