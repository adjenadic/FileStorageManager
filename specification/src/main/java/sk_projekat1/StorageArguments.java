package sk_projekat1;

import java.util.List;

public class StorageArguments {
    // Storage name
    public static String name;

    // Storage absolute path
    public static String path;

    // Storage total space
    public static int totalSpace; //Storage space

    // Storage used space
    public static int usedSpace;  //Storage used space

    // Restricted extensions in a storage
    public static List<String> restrictedExtensions;

    // Maximum number of files allowed in a storage
    public static int maxFilesInStorage; // Max number of files in Storage

    // Current number of files in a storage
    public static int fileNumberInStorage; // Number of files in Storage

    // Default storage name counter
    public static int counter = 1;

    // Storage ID on Google Drive
    public static String driveStorage_Id;
}
