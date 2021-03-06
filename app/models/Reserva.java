package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 16/08/2015.
 */
@Entity
public class Reserva extends Model {

    public static Finder finder = new com.avaje.ebean.Model.Finder(Reserva.class);

    public final static String CREADA="CREADA";
    public final static String CONFIRMADA="CONFIRMADA";
    public final static String CANCELADA="CANCELADA";

    //------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id_reserva;

    private Date hora_reserva;
    private Date hora_creacion;
    private double costo;
    private String estado;

    //@ManyToOne
    private MoviBus movibusReservado;

    //@ManyToOne
    private User cliente;

    public Reserva(Date hora_reserva, double costo, User cliente) {
        this.hora_reserva = hora_reserva;
        this.costo = costo;
        this.movibusReservado = null;
        this.cliente = cliente;
        hora_creacion=new Date();
        estado=CREADA;
    }

    public Date getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(Date hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public MoviBus getMovibusReservado() {
        return movibusReservado;
    }

    public void setMovibusReservado(MoviBus movibusReservado) {
        this.movibusReservado = movibusReservado;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public Date getHora_creacion() {
        return hora_creacion;
    }

    public User getCliente() {
        return cliente;
    }

    //DataBinder-------------------------------------------------------
    public static Reserva bind(JsonNode json)
    {
        return Json.fromJson(json, Reserva.class);
    }
}
