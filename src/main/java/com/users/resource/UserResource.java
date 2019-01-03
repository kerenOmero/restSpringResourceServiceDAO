package com.users.resource;

import com.users.domain.User;
import com.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
@Component
public class UserResource {

    @Autowired
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") String userId) {
        return userService.getUserById(userId);
    }

     @GET
     @Path("/relevant-users/{id}")
     @Produces(MediaType.APPLICATION_JSON)
     public List<User> getUsersByRole(@PathParam("id") String loggedInUserId) {
      return userService.getUsersByRole(loggedInUserId);
  }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        int id = userService.create(user);
        return Response.status(Response.Status.CREATED).entity(id).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserById(@PathParam("id") String userId, User newUser) {
        Boolean foundUserById = userService.updateUserById(userId, newUser);
        if (foundUserById) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.BAD_GATEWAY).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteUserById(@PathParam("id") String userId) {
        Boolean deleteUserById= userService.deleteUserById(userId);
        if(deleteUserById){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
