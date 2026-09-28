package ej2.Repository;

import java.time.LocalDate;

import ej2.Exceptions.ConversacionException;
import ej2.Model.Conversacion;
import ej2.Model.TipoAgente;

public interface IRepoConversaciones{
void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta);
    
    Conversacion getConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException;
    
    boolean contieneConversacion(Conversacion conversacion);
    
    void eliminaConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException;
    
    void incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta, double valoracion) throws ConversacionException;}
