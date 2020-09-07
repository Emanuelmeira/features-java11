package estudos.lambda2.interfaces;

import estudos.lambda2.Carro;

/**
 * Uma interface funcionau é uma interface com um unico metodo
 *   (interface podem conter mais metodos apenas se forem default com implementação)
 */
@FunctionalInterface
public interface CarroPredicate {

    boolean test(Carro carro);

    //Não é obrigatoria implementação de um metodo default em uma interface
    default void metodoComCorpo(){

    }


}
