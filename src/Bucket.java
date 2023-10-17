public class Bucket {
    Integer key;
    Node data;
    Bucket nextKey;
    public Bucket (Integer key, Node data, Bucket nextKey) {
        this.key = key;
        this.data = data;
        this.nextKey = nextKey;
    }
    public Bucket (Integer key, Node data) {
        this.key = key;
        this.data = data;
    }
}
