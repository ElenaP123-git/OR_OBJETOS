package Colecciones.Clase.Simulacion_Coches;

import java.util.*;

public class Repositorio_Vehiculo {

    //atributos
    private Map<String, List<Vehiculo>> mapa;

    //constructor
    public Repositorio_Vehiculo() {
        this.mapa = new HashMap<>();
    }

    //métodos
    public void registrarVehiculo(Vehiculo v) {
        if (!mapa.containsKey(v.getVIN())) {
            mapa.put(v.getVIN(), new ArrayList<>()); // "ABC123" → [] tengo que crear la lista donde voy a meter el vehículo si no existe
        }
        mapa.get(v.getVIN()).add(v); // cuando ya se ha creado la lista, entonces podemos registrar el vehículo
    }

    public List<Vehiculo> buscarPorVin(String vin) {
        if (!mapa.containsKey(vin)) {
            System.out.println("No existe un vehículo con ese VIN");
            return null;
        }
        return mapa.get(vin); // devuelve la lista completa de los vehíuclos con ese VIN
    }

    /*

    SI ME PIDIESE SÓL0 LA INFO DE UN VEHÍCULO:

    public Vehiculo buscarVehiculoActual(String vin) {

    if (!mapa.containsKey(vin)) {
        System.out.println("No existe un vehículo con ese VIN");
        return null;
    }

    List<Vehiculo> lista = mapa.get(vin);
    return lista.get(lista.size() - 1); // el más reciente
}

     */

    public List<Vehiculo> mostrar_por_matricula(String propietario){
        List<Vehiculo> resultado = new ArrayList<>(); // creo una nueva lista para unir coches específicos distintos de la List<Vehiculos>

        for (List<Vehiculo> lista : mapa.values()) { // Recorre todas las listas de vehículos del mapa.
            for (Vehiculo v : lista) { // Recorre cada vehículo.
                if (v.getPropietario().equals(propietario)) { // Si se encuentra al propietario de un vehículo específico
                    resultado.add(v); // se añade el vehículo
                }
            }
        }
        Collections.sort(resultado);
        return resultado;
    }

    public List<Vehiculo> mostrarRematriculaciones(String vin){
        List<Vehiculo> historial= null; // declaramos variable para poder returnearla
        if(mapa.containsKey(vin)){
            historial = mapa.get(vin);

            Comparador_Fecha compF = new Comparador_Fecha();
            Collections.sort(historial, compF);
        }
        return historial;
    }

    /*
    PARA EVITAR MODIFICAR EL MAPA ORIGINAL:
    public List<Vehiculo> mostrarRematriculaciones(String vin){
         if(!mapa.containsKey(vin)){
        return null;
    }
    List<Vehiculo> historial = new ArrayList<>(mapa.get(vin));
    Collections.sort(historial, new Comparador_Fecha());
    return historial;
    }
     */

    public void imprimirRematriculaciones(String vin) {

        if (!mapa.containsKey(vin)) {
            System.out.println("No existe un vehículo con ese VIN");
            return;
        }

        // Copia del historial para no modificar la lista original
        List<Vehiculo> historial = new ArrayList<>(mapa.get(vin));

        // Ordenar por fecha de matriculación
        Collections.sort(historial, new Comparador_Fecha());

        System.out.println("Rematriculaciones del vehículo con VIN " + vin + ":");

        for (Vehiculo v : historial) {
            System.out.println(v.getAño_fab() + " → " + v.getMatricula());
        }
    }



}
