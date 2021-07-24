package uni.edu.pe.farma.dao;

import uni.edu.pe.farma.dto.Cliente;

import java.util.List;

public interface ClienteDao {
    List<Cliente> obtenerClientes();
    Cliente registrarCliente(Cliente cliente);
}
