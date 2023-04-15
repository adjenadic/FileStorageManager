package sk_projekat1;

public class StorageManager {
    private static Storage storage;

    public static void registerStorage(Storage st){
        storage = st;
    }

    public static Storage getStorage(){
        return storage;
    }

    public static boolean existsStorage(String path){
        return storage.setPath(path);
    }
}
