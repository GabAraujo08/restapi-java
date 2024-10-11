package br.com.fiap.controller;

import br.com.fiap.infra.FakeDb;
import br.com.fiap.dtos.PessoaDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/rest/pessoa")
public class PessoaController {
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarNome(PessoaDto input){
        if(input.getId() != null){
            FakeDb.nomesCadastrados.put(input.getId(), input);
            return Response.status(Response.Status.CREATED).entity(input).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("mensagem","id não pode ser nulo.")).build();
        }

    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response localizarNomes(){

        return Response.status(Response.Status.OK)
                .entity(FakeDb.nomesCadastrados).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, PessoaDto input){
        if(FakeDb.nomesCadastrados.containsKey(input.getId())){
            FakeDb.nomesCadastrados.put(input.getId(), input);
            return Response.status(Response.Status.OK).entity(input).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @DELETE@Path("/{id}")
    public Response delete(@PathParam("id")Long id){
        if(FakeDb.nomesCadastrados.containsKey(id)){
            FakeDb.nomesCadastrados.remove(id);
            return Response.status(Response.Status.NO_CONTENT).build();    }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();    }
    }
}
