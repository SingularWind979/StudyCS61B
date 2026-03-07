public interface MyComparable<T> {
    /**
     * Compares this object with the specified object for order.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     */
    int compareTo(T other);
}
