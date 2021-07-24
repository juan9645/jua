package uni.edu.pe.farma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.farma.dao.ClienteDao;
import uni.edu.pe.farma.dto.Cliente;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao dao;

    public List<Cliente> obtenerClientes(){
        return dao.obtenerClientes();
    }

    public Cliente registrarCliente(Cliente cliente){
        return dao.registrarCliente(cliente);
    }
}
