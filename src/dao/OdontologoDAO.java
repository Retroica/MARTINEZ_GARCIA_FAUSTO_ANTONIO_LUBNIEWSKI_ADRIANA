package dao;

import model.Odontologo;
import java.util.List;

public interface OdontologoDAO {
    void guardarOdontologo(Odontologo odontologo);
    List<Odontologo> listarOdontologos();
}
