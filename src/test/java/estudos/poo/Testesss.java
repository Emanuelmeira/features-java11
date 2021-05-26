package estudos.poo;

import java.io.File;

public class Testesss {

    public static void main(String[] args)  {

        String path = "solid.o.calculaimposto".replace('.', '/');
        File directory = new File(path);
        if(directory.isDirectory())
            System.out.println("é");
    }
}
