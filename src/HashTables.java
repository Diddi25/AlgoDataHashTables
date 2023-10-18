public abstract class HashTables {
    abstract Integer hashFunction(Integer key);
    abstract void collisionControl(Integer index, Integer key, Node data);
    abstract boolean lookup(Integer zip);
}
