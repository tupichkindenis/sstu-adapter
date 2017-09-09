package com.thewhite.sstuapp.importing;

/**
 * Data loader interface
 */
public interface Loader<T> {

    /**
     * Returns collection of loadable items.
     * @return
     */
    Iterable<T> loadableItems();

    /**
     *
     * @param loadable
     */
    void loadItem(T loadable);

    /**
     * Returns counter name.
     * @return
     */
    String counterName();

    /**
     * Return readable identifier.
     * @param loadable
     * @return
     */
    String getId(T loadable);
}
