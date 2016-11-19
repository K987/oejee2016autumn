/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjjpit;

import java.util.List;

/**
 *
 * @author nut
 */
class BjjpeopleService {
    List<people> ppllist = ProbaLista.getInstance();

    public List<people> bjjppllist(){
    	return ppllist;
    }
}
