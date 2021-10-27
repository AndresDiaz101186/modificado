package Domingo_Reto3.Reto3.repository;

import Domingo_Reto3.Reto3.interfaces.InterfaceReservaciones;
import Domingo_Reto3.Reto3.model.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase repositorio reservaciones
 * @author Andres Diaz
 */
@Repository
public class RepositorioReservaciones {
       @Autowired
    private InterfaceReservaciones crud4;
    /**
     * devuelve todo lo contenido en la tabla reservaciones
     * @return 
     */   
    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    /**
     * encuentra un elemento espesifico de reservaciones por el id
     * @param id
     * @return 
     */
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    /**
     * guarda datos en la tabla reservaciones
     * @param reservation
     * @return 
     */
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
    /**
     * borra elementos de la tabla reservaciones
     * @param reservation 
     */
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }
}
