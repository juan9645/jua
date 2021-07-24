package uni.edu.pe.farma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.edu.pe.farma.dto.Cliente;
import uni.edu.pe.farma.dto.rest.cliente.ClienteRespuesta;
import uni.edu.pe.farma.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    ClienteService service;

    @RequestMapping(value = "/obtenerClientes",
        method = RequestMethod.POST,
            produces = "application/json;charset=utf-8"
    )
    public ClienteRespuesta obtenerClientes(){
        ClienteRespuesta rpta = new ClienteRespuesta();
        rpta.setClientes(service.obtenerClientes());
        return rpta;
    }

    @RequestMapping(value = "/registrarCliente",
        method = RequestMethod.POST,
            produces = "aplication/json;charset=utf-8"
    )
    public ClienteRespuesta registrarCliente(Cliente cliente){
        ClienteRespuesta rpta = new ClienteRespuesta();
        rpta.registrarCliente(service.registrarCliente(cliente));
        return rpta;
    }
}
