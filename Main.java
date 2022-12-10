public class Main {
    static HashedDictionary<String,Word> database = new HashedDictionary<String, Word>(2477);
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        FileOperations fileOp = new FileOperations();
        long indexingTime = System.currentTimeMillis() - time;
        SearchOperations so = new SearchOperations();
        long searcingTime = System.currentTimeMillis() - time;
        System.out.println(indexingTime);
        System.out.println(searcingTime);
        System.out.println(HashedDictionary.collision);
    }
}
