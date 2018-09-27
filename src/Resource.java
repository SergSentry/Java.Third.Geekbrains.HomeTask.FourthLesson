/**
 * Класс ресурса
 */
public class Resource {

    private ResourceState state;

    public Resource() {
        state = ResourceState.A;
    }

    /**
     * Метод получения состояния ресурса
     *
     * @return состояние ресурса
     */
    public ResourceState getState() {
        return state;
    }

    /**
     * Метод ожидания состояния ресурса
     *
     * @param state ожидаемое состояние
     * @throws InterruptedException
     */
    public void waitState(ResourceState state) throws InterruptedException {
        while (this.state != state)
            this.wait();
    }

    /**
     * Метод установки состояния ресурса
     *
     * @param state устанавливаемое состояние
     */
    public synchronized void setState(ResourceState state) {
        this.state = state;
        this.notifyAll();
    }

    /**
     * Метод печати состояния ресурса
     */
    public void PrintState() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
