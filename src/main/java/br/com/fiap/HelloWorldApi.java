package br.com.fiap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
}
