package Colecciones.Boletin2;

import java.time.LocalDate;
import java.util.Objects;

    public class Animal {
        // ATRIBUTOS

        private int id;
        private String nombre;
        private String especie;
        private int edad;
        private TipoComida clasificacionComida;
        private LocalDate fechaNacimiento;
        private double peso;
        private TipoMedio medio;
        private TipoGestación clasificacionGestacion;


        // CONSTRUCTOR

        public Animal(int id, String nombre, String especie, int edad, TipoComida clasificacionComida,
                      LocalDate fechaNacimiento, double peso, TipoMedio medio, TipoGestación clasificacionGestacion) {

            this.id = id;
            this.nombre = nombre;
            this.especie = especie;
            this.edad = edad;
            this.clasificacionComida = clasificacionComida;
            this.fechaNacimiento = fechaNacimiento;
            this.peso = peso;
            this.medio = medio;
            this.clasificacionGestacion = clasificacionGestacion;
        }

        // GETTERS

        public int getId() {
            return id; }

        public String getNombre() {
            return nombre; }

        public String getEspecie() {
            return especie; }

        public int getEdad() {
            return edad; }

        public TipoComida getClasificacionComida() {
            return clasificacionComida;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento; }

        public double getPeso() {
            return peso; }

        public TipoMedio getMedio() {
            return medio;
        }

        public TipoGestación getClasificacionGestacion() {
            return clasificacionGestacion;
        }

        // EQUALS & HASHCODE (por ID)

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Animal a)) return false;
            return this.id == a.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        // TOSTRING

        @Override
        public String toString() {
            return nombre + " (" + especie + ") - " + medio + " - " + clasificacionComida;
        }
    }


