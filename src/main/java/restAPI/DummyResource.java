/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.DummyEntity;
import facade.testFacade;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import utils.EntityManagerCreator;

/**
 *
 * @author mathi
 */

@Path("dummyAPI")
public class DummyResource {
    
    @Path("/getStatus")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
              public String demo() {
        return "{\"msg\":\"SC SC ONLINE\"}";
    }
                  private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManager();
            private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
                private static final testFacade facade = testFacade.getDummyFacade(EMF);

    @Path("/all")          
    @GET
    @Produces({MediaType.APPLICATION_JSON})
      public String getFromDB(){
         List<DummyEntity> list = new ArrayList();
        list.addAll(facade.getAllPersons());
        return GSON.toJson(list);
      }
      
      @Path("/add")
      @POST
    @Produces({MediaType.APPLICATION_JSON})
     @Consumes(MediaType.APPLICATION_JSON)
        public void addNewPerson(DummyEntity p){
            System.out.println(p);
            try {
                 if(p.getName()== null){
                   throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("Missing info please check %s", p.toString()))
          .build());
            }
        }
      catch(Exception e){
                  throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience",501);
    }finally{
              facade.createPerson(p.getName());
        }
    }

}
