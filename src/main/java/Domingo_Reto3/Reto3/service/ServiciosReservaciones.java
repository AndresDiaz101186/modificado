package Domingo_Reto3.Reto3.service;

import Domingo_Reto3.Reto3.repository.RepositorioReservaciones;
import Domingo_Reto3.Reto3.model.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase servicio reservaciones
 * trabaja las llamadas, entradas, actualizaciones y borrado en conjunto con los metodos crud
 * @author Andres Diaz
 */
@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;
    /**
     * lista todos los elementos contenidos en la tabla reservaciones
     * @return 
     */
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * encuentra una fila espesifica de la tabla reservaciones
     * @param reservationId
     * @return 
     */
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    /**
     * verifica el id y le otorga una a la entrada para ser almacenada en la tabla 
     * @param reservation
     * @return 
     */
    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    /**
     * este metodo ubica una fila en la tabla para ser modificada
     * @param reservation
     * @return 
     */
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    /**
     * este metodo recibe un id para ubicar la fila de la tabla y eliminarla
     * @param reservationId
     * @return 
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }    
}
