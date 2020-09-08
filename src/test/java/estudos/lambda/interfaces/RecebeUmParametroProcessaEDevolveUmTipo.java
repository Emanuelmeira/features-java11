package estudos.lambda.interfaces;

@FunctionalInterface
public interface RecebeUmParametroProcessaEDevolveUmTipo<T, R> {

    R recebeUmParametroProcessaEDevolveUmTipo(T t);
}
