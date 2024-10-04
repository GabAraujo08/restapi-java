package br.com.fiap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("/rest")
public class HelloWorldApi {
    private FakeDb fakeDb = new FakeDb();


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
    public String cadastrarNome(InputDto input){

        fakeDb.add(input.getNome());
        return """
                "response" : "Nome cadastrado com sucesso"
                """;
    }
    @GET
    @Path("/localizar-nome")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> localizarNomes(){

        return fakeDb;
    }
}
