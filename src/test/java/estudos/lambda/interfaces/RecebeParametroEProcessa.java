package estudos.lambda.interfaces;

@FunctionalInterface
public interface RecebeParametroEProcessa<T> {

    void recebeUmParametroEProcessa(T t);
}

