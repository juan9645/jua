package uni.edu.pe.farma.service;

import uni.edu.pe.farma.dto.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> obtenerClientes();
    Cliente registrarCliente(Cliente cliente);
}
