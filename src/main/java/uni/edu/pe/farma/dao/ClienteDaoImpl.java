package uni.edu.pe.farma.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.farma.dto.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteDaoImpl implements ClienteDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Connection conexion;

    private void obtenerConexion(){
        try {
            conexion = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void cerrarConexion(){
        try {
            conexion.close();
            conexion = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            obtenerConexion();
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT dni, nombres, apellidos, telefono FROM Cliente";
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
                String dni = resultado.getString("dni");
                String nombres = resultado.getString("nombres");
                String apellidos = resultado.getString("apellidos");
                String telefono = resultado.getString("telefono");
                Cliente cliente = new Cliente(dni, nombres, apellidos, telefono);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente){
        try {
            obtenerConexion();
            Statement sentencia = conexion.createStatement();
            String sql = "INSERT INTO Cliente VALUES (" + cliente.getDni() + ", " + cliente.getNombres() + ", " + cliente.getApellidos() + ", " + cliente.getTelefono() + ")";
            ResultSet resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
