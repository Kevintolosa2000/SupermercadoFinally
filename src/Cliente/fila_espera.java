package Cliente;

import java.util.*;
import java.util.function.UnaryOperator;

public class fila_espera <T> extends LinkedList<T>{
    private Queue<T> filaGenerica;
    public fila_espera() {
        filaGenerica = new LinkedList<>();
    }
    public fila_espera(Queue<T> filaGenerica) {
        this.filaGenerica = filaGenerica;
    }

    public Queue<T> getFilaGenerica() {
        return filaGenerica;
    }

    public void setFilaGenerica(Queue<T> filaGenerica) {
        this.filaGenerica = filaGenerica;
    }

    @Override
    public String toString() {
        return "fila_espera{" +
                "filaGenerica=" + filaGenerica +
                '}';
    }

    @Override
    public boolean add(T t) {
        return super.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public T poll() {
        return super.poll();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

}
