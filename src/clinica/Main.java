package clinica;

import dao.OdontologoDAO;
import dao.impl.OdontologoH2DAO;
import dao.impl.OdontologoMemoriaDAO;
import model.Odontologo;

public class Main {
    public static void main(String[] args) {
        OdontologoDAO odontologoH2DAO = new OdontologoH2DAO();
        OdontologoDAO odontologoMemoriaDAO = new OdontologoMemoriaDAO();

        Odontologo odontologo1 = new Odontologo(1, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2, "Maria", "Gomez");

        odontologoH2DAO.guardarOdontologo(odontologo1);
        odontologoMemoriaDAO.guardarOdontologo(odontologo2);

        System.out.println("Odontólogos en H2:");
        for (Odontologo o : odontologoH2DAO.listarOdontologos()) {
            System.out.println("Matrícula: " + o.getNumeroMatricula() + ", Nombre: " + o.getNombre() + ", Apellido: " + o.getApellido());
        }

        System.out.println("Odontólogos en memoria:");
        for (Odontologo o : odontologoMemoriaDAO.listarOdontologos()) {
            System.out.println("Matrícula: " + o.getNumeroMatricula() + ", Nombre: " + o.getNombre() + ", Apellido: " + o.getApellido());
        }
    }
}
