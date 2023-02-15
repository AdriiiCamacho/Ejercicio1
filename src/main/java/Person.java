import java.util.List;

/**
 * Clase que representa a una persona con edad,nombre y genero
 *
 * @author Adrian Camacho Ferrezuelo
 */

public class Person {

    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Crea una nueva instancia de la clase Person con un nombre, edad y género.
     *
     * @param n El nombre de la persona
     * @param a La edad de la persona
     * @param g El género de la persona (MALE o FEMALE)
     */
    public Person (String n, int a, String g){
        if (n==""){
            throw new RuntimeException("El nombre no puede ser una cadena vacia");
        }
        if (a<=0){
            throw  new RuntimeException("La edad debe ser mayor que 0");
        }
        if (g.compareToIgnoreCase("MALE")!=0 && g.compareToIgnoreCase("FEMALE")!=0) {
            throw  new RuntimeException("El genero tiene que ser MAlE o FEMALE");
        }
        name = n;
        age = a;
        gender = g;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    /**
     * Este método calcula el promedio de edad por género en una lista de personas.
     *
     * @param lista Lista de personas a procesar
     * @return Array con dos elementos, el promedio de edad de hombres y mujeres en la lista. Si no hay hombres o mujeres en la lista, el promedio será 0.
     */
    public static double [] averageAgePerGender(List<Person> lista){
        double nHombres = 0,nMujeres = 0,sumaHombre = 0,sumaMujer = 0, mediaH, mediaM;

        if(lista== null){
            throw  new RuntimeException("Lista no valida");
        }

        for (Person pActual : lista) {
            if(pActual.gender.equalsIgnoreCase("MALE")){
                nHombres++;
                sumaHombre += pActual.getAge();
            } else{
                nMujeres++;
                sumaMujer += pActual.getAge();
            }
        }

        if (nHombres == 0){
            mediaH = 0;
        } else {
            mediaH = sumaHombre/nHombres;
        }
        if (nMujeres == 0){
            mediaM = 0;
        } else {
            mediaM = sumaMujer/nMujeres;
        }

        double resultado[] = {mediaH, mediaM};
        return resultado;
    }

}
