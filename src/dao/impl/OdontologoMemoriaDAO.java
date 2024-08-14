package dao.impl;

import dao.OdontologoDAO;
import model.Odontologo;
import java.util.ArrayList;
import java.util.List;

// Implementacion de log4j
import org.apache.log4j.Logger;
private static Logger logger = Logger.getLogger(OdontologoMemoriaDAO.class);

public class OdontologoMemoriaDAO implements OdontologoDAO {
    private List<Odontologo> listaOdontologos = new ArrayList<>();

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        listaOdontologos.add(odontologo);
        logger.info("Odontólogo guardado en memoria con éxito.");
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        logger.info("Lista de odontólogos obtenida de memoria con éxito.");
        return listaOdontologos;
    }
}