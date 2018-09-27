
/**
 *  Класс программы домашнего задания четвертого урока
 */
public class Program {
    private static final int MAX_ITERATION = 5;
    private static final Resource resource = new Resource();

    /**
     * Точка входа в приложение
     *
     * @param args параметры командной строки
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < MAX_ITERATION; i++) {
                        synchronized (resource) {
                            resource.waitState(ResourceState.A);
                            resource.PrintState();
                            resource.setState(ResourceState.B);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < MAX_ITERATION; i++) {
                        synchronized (resource) {
                            resource.waitState(ResourceState.B);
                            resource.PrintState();
                            resource.setState(ResourceState.C);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < MAX_ITERATION; i++) {
                        synchronized (resource) {
                            resource.waitState(ResourceState.C);
                            resource.PrintState();
                            resource.setState(ResourceState.A);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
