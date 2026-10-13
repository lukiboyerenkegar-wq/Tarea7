package Tarea7;

public class ListaEnlazada {
    private static class Nodo{
        int dato;
        Nodo siguiente;
        Nodo(int dato){
            this.dato = dato;
            this.siguiente = null;
        }
    }
    private Nodo cabeza;
    public ListaEnlazada(){
        this.cabeza = null;
    }
    public boolean estaVacia(){
        return cabeza == null;
    }
    public void insertarAlInicio(int dato){
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    public void insertarAlFinal(int dato){
        Nodo nuevo = new Nodo(dato);
        if(cabeza == null){
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while(actual.siguiente != null){
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }
    public boolean buscar(int dato){
        Nodo actual = cabeza;
        while(actual != null){
            if(actual.dato == dato)return true;
            actual = actual.siguiente;
        }
        return false;
    }
    public boolean eliminar(int dato){
        if(cabeza == null) return false;
        if(cabeza.dato == dato){
            cabeza = cabeza.siguiente;
            return true;
        }
        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        while (actual != null) {
            if(actual.dato == dato){
                anterior.siguiente = actual.siguiente;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return  false;
    }
    public int contar(){
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null){
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
    public int obtener(int indice){
        if(indice < 0)throw new
        IndexOutOfBoundsException("Indice negativo");
        Nodo actual = cabeza;
        int posicion = 0;
        while (actual != null){
            if(posicion == indice)return actual.dato;
            actual = actual.siguiente;
            posicion++;
        }
        throw new
        IndexOutOfBoundsException("Indice feura de rango: " + indice);
    }
    public void imprimir(){
        if (cabeza == null){
            System.out.println("La lista esta vacia");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null){
            System.out.println(actual.dato);
            if(actual.siguiente != null)
                System.out.println("----->");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}