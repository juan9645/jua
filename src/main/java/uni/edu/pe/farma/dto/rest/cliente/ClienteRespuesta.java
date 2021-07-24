package uni.edu.pe.farma.dto.rest.cliente;

import uni.edu.pe.farma.dto.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRespuesta {
    List<Cliente> clientes = new ArrayList<>();
    Cliente cliente;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void registrarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
