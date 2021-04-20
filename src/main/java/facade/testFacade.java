/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mathi
 */
public class testFacade {
        private static EntityManagerFactory emf;
        private static testFacade instance;
        
            private testFacade() {}

         /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static testFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new testFacade();
        }
        return instance;
    }
        
}

