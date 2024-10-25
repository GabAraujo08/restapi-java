package br.com.fiap.controller;

import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.exceptions.PessoaNotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.dtos.PessoaDto;
import br.com.fiap.models.Pessoa;
import br.com.fiap.service.PessoaService;
import br.com.fiap.service.PessoaServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/rest/pessoa")
public class PessoaController {

    private final PessoaService pessoaService = PessoaServiceFactory.create();

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(PessoaDto input) throws UnsupportedServiceOperationException {
        if (input.getId() == null) {
            try {
                Pessoa pessoa = this.pessoaService.create(new Pessoa(null, input.getNome()));
                return Response
                        .status(Response.Status.CREATED)
                        .entity(pessoa)
                        .build();
            } catch (SQLException | PessoaNotSavedException e){
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(Map.of("mensagem","erro inesperado ao tentar inserir pessoa")).build();
            }

        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(
                            Map.of(
                                    "mensagem",
                                    "esse método só permite a criação de novas pessoas"))
                    .build();
        }
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.status(Response.Status.OK)
                .entity(this.pessoaService.findAll()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, PessoaDto input){
        try {
            Pessoa updated = this.pessoaService.update(new Pessoa(id, input.getNome()));
            return Response.status(Response.Status.OK).entity(updated).build();
        } catch (PessoaNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar atualizar pessoa")).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id")Long id){
        try {
            this.pessoaService.deleteById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (PessoaNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException s) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("mensagem","erro inesperado ao tentar deletar pessoa")).build();
        }
    }
}
