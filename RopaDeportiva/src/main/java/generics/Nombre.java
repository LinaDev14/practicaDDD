package generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class Nombre implements ValueObject<Nombre.Properties> {

    // declaracion de variables
    private final String nombre;
    private final String apellido;

    // constructor
    public Nombre(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // interface
    public interface Properties{
        String nombre();
        String apellido();
    }

    // constructor del properties
    @Override
    public Properties value() {
        return new Properties(){

            @Override
            public String nombre(){
                return nombre;
            }

            @Override
            public String apellido(){
                return apellido;
            }
        };
    }

    // implementación de equals y el hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nombre)) return false;
        Nombre nombre1 = (Nombre) o;
        return nombre.equals(nombre1.nombre) && apellido.equals(nombre1.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
