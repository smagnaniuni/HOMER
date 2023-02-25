package homer;

public final class App {
    public static void main(String[] args) {

        final ControllerImpl control = new ControllerImpl();

        final var lock = new Lock();
        control.connectDevice(lock);
        System.out.println(lock);
        lock.getState().lock();
        System.out.println(lock);
        System.out.println();

        control.connectDevice(new Lock());
        control.connectDevice(new Lock());
        control.connectDevice(new Thermometer());
        control.getDevices().forEach(d -> {
            System.out.println(d + " | " + d.getState() + " | " + d.getState().getClass());
        });
        System.out.println();
        control.getDevices().forEach(d -> {
            if (d instanceof Lock) {
                final var casted = (Lock) d;
                casted.getState().lock();
            }
        });
        System.out.println();
        control.getDevices().forEach(d -> {
            System.out.println(d + " | " + d.getState() + " | " + d.getState().getClass());
        });
        System.out.println();
    }

    public static String getGreeting() {
        return "Hello, World!";
    }
}
