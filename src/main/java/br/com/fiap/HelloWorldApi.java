package br.com.fiap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/rest")
public class HelloWorldApi {



    @GET
    @Path("/v1")
    public String hello() {
        return "{\"Mensagem\" : \"Hello World\"}";
    }
    @GET
    @Path("/v2")
    public String helloV2() {
        return """
                {
                    "Mensagem" : "Hello World V2"
                }
                """;
    }
    @GET
    @Path("/testando")
    public String testando() {
        return """
                <h1 style="color:red;">Testando</h1>
                """;
    }
    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarNome(InputDto input){
        if(input.getId() != null){
            FakeDb.nomesCadastrados.put(input.getId(), input);
            return Response.status(Response.Status.CREATED).entity(input).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("mensagem","id não pode ser nulo.")).build();
        }

    }
    @GET
    @Path("/localizar-nome")
    @Produces(MediaType.APPLICATION_JSON)
    public Response localizarNomes(){

        return Response.status(Response.Status.OK)
                .entity(FakeDb.nomesCadastrados).build();
    }
    @GET
    @Path("/update//{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, InputDto input){
        if(FakeDb.nomesCadastrados.containsKey(input.getId())){
            FakeDb.nomesCadastrados.put(input.getId(), input);
            return Response.status(Response.Status.OK).entity(input).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}
