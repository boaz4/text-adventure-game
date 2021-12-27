package objectAdventure.pattern;

public interface Observable<T> {

    void addObserver(Observer<T> o);

    void removeObserver(Observer<T> o);

    void notifyObservers();

    // Optionally notify with an "event" parameter of a polymorphic type.
    default void notifyObservers(T notificationEvent) {
        throw new UnsupportedOperationException("Not Overridden By Observable Implementor");
    }
}
