Gabriel Vieira Gama 12421bcc035


interface Celular {
    void fazLigacao();
    void tiraFoto();
}


interface FabricanteCelular {
    Celular constroiCelular(String modelo);
}


class IPhoneX implements Celular {
    public void fazLigacao() {
        System.out.println("iPhone X fazendo ligação...");
    }

    public void tiraFoto() {
        System.out.println("iPhone X tirando foto...");
    }
}

class IPhoneS implements Celular {
    public void fazLigacao() {
        System.out.println("iPhone S fazendo ligação...");
    }

    public void tiraFoto() {
        System.out.println("iPhone S tirando foto...");
    }
}


class Galaxy8 implements Celular {
    public void fazLigacao() {
        System.out.println("Galaxy 8 fazendo ligação...");
    }

    public void tiraFoto() {
        System.out.println("Galaxy 8 tirando foto...");
    }
}

class Galaxy20 implements Celular {
    public void fazLigacao() {
        System.out.println("Galaxy 20 fazendo ligação...");
    }

    public void tiraFoto() {
        System.out.println("Galaxy 20 tirando foto...");
    }
}


class Apple implements FabricanteCelular {
    private static Apple fabricaApple;

    private Apple() {
    }

    public static Apple getInstance() {
        if (fabricaApple == null) {
            fabricaApple = new Apple();
        }
        return fabricaApple;
    }

    public Celular constroiCelular(String modelo) {
        if (modelo.equalsIgnoreCase("IPhoneX")) {
            return new IPhoneX();
        } else if (modelo.equalsIgnoreCase("IPhoneS")) {
            return new IPhoneS();
        }

        return null;
    }
}


class Samsung implements FabricanteCelular {
    private static Samsung fabricaSamsung;

    private Samsung() {
    }

    public static Samsung getInstance() {
        if (fabricaSamsung == null) {
            fabricaSamsung = new Samsung();
        }
        return fabricaSamsung;
    }

    public Celular constroiCelular(String modelo) {
        if (modelo.equalsIgnoreCase("Galaxy8")) {
            return new Galaxy8();
        } else if (modelo.equalsIgnoreCase("Galaxy20")) {
            return new Galaxy20();
        }

        return null;
    }
}


public class Main {
    public static void main(String[] args) {
        FabricanteCelular apple = Apple.getInstance();
        FabricanteCelular samsung = Samsung.getInstance();

        Celular celular1 = apple.constroiCelular("IPhoneX");
        Celular celular2 = samsung.constroiCelular("Galaxy20");

        celular1.fazLigacao();
        celular1.tiraFoto();

        celular2.fazLigacao();
        celular2.tiraFoto();
    }
}