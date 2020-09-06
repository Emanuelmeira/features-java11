package estudos.lambda2.interfaces;

@FunctionalInterface
public interface RecebeUmParametroProcessaEDevolveUmTipo<T, R> {

    R recebeUmParametroProcessaEDevolveUmTipo(T t);
}
