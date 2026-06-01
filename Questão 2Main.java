Gabriel Vieira Gama  12421bcc035

// Interface do veículo
interface IVehicle {
    void start();
    void drive();
    void stop();
}

// Interface da fábrica de veículos
interface IVehicleMaker {
    IVehicle makeVehicle(String modelo);
}

// Modelos da Toyota
class Corolla implements IVehicle {
    public void start() {
        System.out.println("Corolla ligando...");
    }

    public void drive() {
        System.out.println("Corolla rodando...");
    }

    public void stop() {
        System.out.println("Corolla parando...");
    }
}

class Hilux implements IVehicle {
    public void start() {
        System.out.println("Hilux ligando...");
    }

    public void drive() {
        System.out.println("Hilux rodando...");
    }

    public void stop() {
        System.out.println("Hilux parando...");
    }
}

class Etios implements IVehicle {
    public void start() {
        System.out.println("Etios ligando...");
    }

    public void drive() {
        System.out.println("Etios rodando...");
    }

    public void stop() {
        System.out.println("Etios parando...");
    }
}

// Modelos da Honda
class City implements IVehicle {
    public void start() {
        System.out.println("City ligando...");
    }

    public void drive() {
        System.out.println("City rodando...");
    }

    public void stop() {
        System.out.println("City parando...");
    }
}

class Civic implements IVehicle {
    public void start() {
        System.out.println("Civic ligando...");
    }

    public void drive() {
        System.out.println("Civic rodando...");
    }

    public void stop() {
        System.out.println("Civic parando...");
    }
}

class Fit implements IVehicle {
    public void start() {
        System.out.println("Fit ligando...");
    }

    public void drive() {
        System.out.println("Fit rodando...");
    }

    public void stop() {
        System.out.println("Fit parando...");
    }
}

// Singleton + Factory da Toyota
class Toyota implements IVehicleMaker {
    private static Toyota fabricaToyota;

    private Toyota() {
    }

    public static Toyota getInstance() {
        if (fabricaToyota == null) {
            fabricaToyota = new Toyota();
        }
        return fabricaToyota;
    }

    // Factory: cria o veículo de acordo com o modelo pedido
    public IVehicle makeVehicle(String modelo) {
        if (modelo.equalsIgnoreCase("Corolla")) {
            return new Corolla();
        } else if (modelo.equalsIgnoreCase("Hilux")) {
            return new Hilux();
        } else if (modelo.equalsIgnoreCase("Etios")) {
            return new Etios();
        }

        return null;
    }
}

// Singleton + Factory da Honda
class Honda implements IVehicleMaker {
    private static Honda fabricaHonda;

    private Honda() {
    }

    public static Honda getInstance() {
        if (fabricaHonda == null) {
            fabricaHonda = new Honda();
        }
        return fabricaHonda;
    }

    // Factory: cria o veículo de acordo com o modelo pedido
    public IVehicle makeVehicle(String modelo) {
        if (modelo.equalsIgnoreCase("City")) {
            return new City();
        } else if (modelo.equalsIgnoreCase("Civic")) {
            return new Civic();
        } else if (modelo.equalsIgnoreCase("Fit")) {
            return new Fit();
        }

        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Singleton: uso getInstance para garantir apenas uma fábrica Toyota e uma Honda
        IVehicleMaker toyota = Toyota.getInstance();
        IVehicleMaker honda = Honda.getInstance();

        IVehicle carro1 = toyota.makeVehicle("Corolla");
        IVehicle carro2 = honda.makeVehicle("Civic");

        carro1.start();
        carro1.drive();
        carro1.stop();

        System.out.println();

        carro2.start();
        carro2.drive();
        carro2.stop();
    }
}