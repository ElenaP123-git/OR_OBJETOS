package Colecciones.Apuntes_IA.RESUMEN_TOTAL;

public class Resumen {
            /*

    RESUMEN: QUÉ COLECCIÓN USAR SEGÚN LO QUE PIDA EL EJERCICIO

    ----------------
    1) LISTAS (List)
    ----------------
    ✔ Permiten duplicados
    ✔ Mantienen orden

    - ArrayList:
    "Lista para acceder por índice"
        → Acceso rápido por índice
        → Muchas lecturas, pocas inserciones en medio
        → Ejemplo: lista de alumnos, lista de tareas

    - LinkedList:
    "Lista con muchas inserciones/eliminaciones"
        → Muchas inserciones/eliminaciones en medio o al principio
        → Ejemplo: cola de clientes, historial de navegación


    ------------------
    2) CONJUNTOS (Set)
    ------------------
    ✔ NO permiten duplicados

    - HashSet:
    "Conjunto sin duplicados, sin orden, muy rápido"
        → Sin orden
        → Muy rápido en búsquedas, inserción y eliminación
        → Ejemplo: conjunto de DNI, emails únicos

    - LinkedHashSet:
    "Conjunto sin duplicados, pero con orden de inserción"
        → Mantiene orden de inserción
        → Rápido
        → Ejemplo: historial de elementos sin duplicados

    - TreeSet:
    "Conjunto ordenado automáticamente"
        → Ordenado automáticamente
        → Más lento
        → Ejemplo: ranking ordenado, lista de palabras ordenadas


    ----------------
    3) MAPAS (Map)
    --------------
    ✔ Clave → Valor
    ✔ NO permite claves duplicadas

    - HashMap:
    "Diccionario sin duplicados, sin orden, rápido en búsquedas"
        → Sin orden
        → Muy rápido en búsquedas, inserción y eliminación
        → Ejemplo: lista de la compra (producto → kg)
                   diccionario de alumnos (dni → alumno)

    - LinkedHashMap:
    "Diccionario rápido que conserve el orden"
        → Mantiene orden de inserción
        → Ejemplo: historial de accesos, cache simple

    - TreeMap:
    "Diccionario ordenado por clave"
        → Ordenado por clave
        → Ejemplo: agenda ordenada por nombre, ranking por clave



    ============================================================
    RESUMEN: ORDENACIÓN
    ============================================================

    1) Comparable (orden natural)
    -----------------------------
    - La clase implementa Comparable<T>
    - Sobrescribe compareTo()
    - Se usa cuando la clase tiene un orden "por defecto"

    Ejemplo:
    public int compareTo(Persona p) {
        return this.nombre.compareTo(p.nombre);
    }

    2) Comparator (orden externo)
    -----------------------------
    - Clase aparte que implementa Comparator<T>
    - Se usa cuando quieres varios criterios de ordenación

    Ejemplo:
    public int compare(Persona a, Persona b) {
        return a.getEdad() - b.getEdad();
    }


    ============================================================
    RESUMEN: ITERADORES
    ============================================================

    1) Iterator
    -----------
    ✔ Recorrer
    ✔ Eliminar mientras recorres
    ❌ No permite ir hacia atrás

    Métodos:
    - hasNext()
    - next()
    - remove()

    2) ListIterator
    ---------------
    ✔ Recorrer
    ✔ Eliminar
    ✔ Añadir
    ✔ Modificar
    ✔ Ir hacia atrás
    ❗ Solo para List

    Métodos extra:
    - hasPrevious()
    - previous()
    - add()
    - set()


    ============================================================
    RESUMEN: EXCEPCIONES
    ============================================================

    Tipos:
    - Checked (obligan a try/catch): IOException, SQLException
    - Unchecked (Runtime): NullPointerException, IndexOutOfBounds

    Estructura:
    try {
        // código
    } catch (TipoException e) {
        // manejo
    } finally {
        // siempre se ejecuta
    }

    throw:
    - Lanza una excepción manualmente

    throws:
    - Indica que un método puede lanzar una excepción


    ============================================================
    RESUMEN: CLONE()
    ============================================================

    1) Para usar clone():
    ---------------------
    - implements Cloneable
    - Sobrescribir clone()
    - Llamar a super.clone()

    2) Copia superficial (shallow)
    ------------------------------
    ✔ Copia primitivos
    ✔ Copia referencias (objetos compartidos)
    ❌ NO copia objetos internos

    return (PersonaShallow) super.clone();

    3) Copia profunda (deep)
    ------------------------
    ✔ Copia primitivos
    ✔ Copia objetos internos (clonándolos)
    ✔ Cada objeto es independiente

    Ejemplo deep:
    Persona copia = (Persona) super.clone();
    copia.direccion = direccion.clone();

    */
}
