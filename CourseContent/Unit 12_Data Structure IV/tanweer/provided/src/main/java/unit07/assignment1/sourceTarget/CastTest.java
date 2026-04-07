package unit07.assignment1.sourceTarget;

@SuppressWarnings("unchecked")
public class CastTest<E> {
    private E value;

    public CastTest() {
        this.value = (E)new Object();
    }

    public E getValue() {
        return this.value;
    }
}
