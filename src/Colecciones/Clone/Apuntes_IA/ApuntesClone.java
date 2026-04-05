package Colecciones.Clone.Apuntes_IA;

public class ApuntesClone {
    public static void main(String[] args) {

        // 1. COPIA SUPERFICIAL (SHALLOW COPY)

        System.out.println("\n--- COPIA SUPERFICIAL ---");

        Direccion d1 = new Direccion("Sevilla");
        PersonaShallow p1 = new PersonaShallow("Ana", d1);

        PersonaShallow p2 = p1.clone(); // copia superficial

        System.out.println("Original: " + p1);
        System.out.println("Copia:    " + p2);

        // Cambiamos la dirección en la copia
        p2.getDireccion().setCiudad("Madrid");

        System.out.println("\nTras modificar la dirección en la copia:");
        System.out.println("Original: " + p1); // ❗ También cambia
        System.out.println("Copia:    " + p2);


        // 2. COPIA PROFUNDA (DEEP COPY)

        System.out.println("\n--- COPIA PROFUNDA ---");

        Direccion d3 = new Direccion("Valencia");
        PersonaDeep p3 = new PersonaDeep("Luis", d3);

        PersonaDeep p4 = p3.clone(); // copia profunda

        System.out.println("Original: " + p3);
        System.out.println("Copia:    " + p4);

        // Cambiamos la dirección en la copia
        p4.getDireccion().setCiudad("Bilbao");

        System.out.println("\nTras modificar la dirección en la copia:");
        System.out.println("Original: " + p3); // ✔ NO cambia
        System.out.println("Copia:    " + p4);
    }
}

