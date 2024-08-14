package dao.impl;

import dao.OdontologoDAO;
import model.Odontologo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementacion de log4j
import org.apache.log4j.Logger;
private static Logger logger = Logger.getLogger(OdontologoH2DAO.class);

public class OdontologoH2DAO implements OdontologoDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/odontologos", "user", "password");
    }

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        String SQL_INSERT = "INSERT INTO ODONTOLOGO (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT)) {
            pstmt.setInt(1, odontologo.getNumeroMatricula());
            pstmt.setString(2, odontologo.getNombre());
            pstmt.setString(3, odontologo.getApellido());
            pstmt.executeUpdate();
            logger.info("Odontólogo guardado con éxito.");
        } catch (SQLException e) {
            logger.error("Error al guardar el odontólogo.", e);
        }
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        List<Odontologo> odontologos = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM ODONTOLOGO";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_SELECT)) {
            while (rs.next()) {
                int matricula = rs.getInt("MATRICULA");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                odontologos.add(new Odontologo(matricula, nombre, apellido));
            }
            logger.info("Lista de odontólogos obtenida con éxito.");
        } catch (SQLException e) {
            logger.error("Error al listar los odontólogos.", e);
        }
        return odontologos;
    }
}