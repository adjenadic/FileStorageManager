package sk_projekat1;

import java.util.List;

public interface Storage {
    /**
     * Checks if the storage exists.
     *
     * @param absolutePath  Storage absolute path
     * @return              true or false
    */
    boolean setPath(String absolutePath);

    /**
     * Creates an empty root folder called Storage.
     *
     * @param storageName                   Storage name
     * @param storageSize                   Storage size in bytes
     * @param storagePath                   Storage absolute path
     * @param storageRestrictedExtensions   Storage restricted file extensions. If you have multiple extensions, split them with the ',' character
     * @param maxFilesInFolder              Max number of files in one folder
     * @return                              true or false
     */
    boolean createStorage(String storageName, String storagePath, int storageSize, String storageRestrictedExtensions, int maxFilesInFolder);

    /**
     * Creates an empty root folder called 'Default Storage' with default credentials.
     * Default credentials are some constants that are predetermined.
     *
     * @return                  true or false
     */
    boolean createDefaultStorage();

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Creates an empty folder.
     *
     * @param folderName        Folder name
     * @param folderPath        Folder path (Relative path from storage)
     * @return                  true or false
     */
    boolean createFolder(String folderName, String folderPath);

    /**
     * Creates an empty file.
     *
     * @param fileName          File name
     * @param filePath          File path (Relative path from storage)
     * @return                  true or false
     */
    boolean createFile(String fileName, String filePath);

    /**
     * Moves a file to a given new folder.
     *
     * @param oldFilePath       Old File path (Relative path from storage)
     * @param newFilePath       New File path (Relative path from storage)
     * @return                  true or false
     */
    boolean moveFile(String oldFilePath, String newFilePath);

    /**
     * Renames an existing file object.
     *
     * @param foNewName         Folder or File new name
     * @param foPath            Folder or File path (Relative path from storage)
     * @return                  true or false
     */
    boolean renameFileObject(String foNewName, String foPath);

    /**
     * Deletes an existing file object.
     *
     * @param foPath            File object path (relative path from storage)
     * @return                  true or false
     */
    boolean deleteFileObject(String foPath);

    /**
     * Imports one, or more, file object(s) into the storage.
     *
     * @param importLocalPath   Local disk file path
     * @param importStoragePath Storage file path (Relative path from storage)
     * @return                  true or false
     */
    boolean importFileObject(String[] importLocalPath, String importStoragePath);

    /**
     * Exports a file object onto the local disk.
     *
     * @param exportStoragePath Storage file path (Relative path from storage)
     * @param exportLocalPath   Local disk file path
     * @return                  true or false
     */
    boolean exportFileObject(String exportStoragePath, String exportLocalPath);

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Lists the metadata of all files in a folder.
     *
     * @param folderPath    Folder path (relative path from storage)
     * @param typeSort      Sort type for the search function
     * @param typeFilter    Filter type for the search function
     * @param fileExtension File extension for the search function
     * @param startDate     Start date
     * @param endDate       End date
     */
    List<String> searchFilesInFolder(String folderPath, String typeSort, String typeFilter, String fileExtension, String startDate, String endDate);

    /**
     * Lists the metadata of all files in a folder, including subfolders.
     *
     * @param folderPath    Folder path (relative path from storage)
     * @param typeSort      Sort type for the search function
     * @param typeFilter    Filter type for the search function
     * @param fileExtension File extension for the search function
     * @param startDate     Start date
     * @param endDate       End date
     */
    List<String> searchFilesInFolders(String folderPath, String typeSort, String typeFilter, String fileExtension, String startDate, String endDate);

    /**
     * Lists the metadata of all files with a specific extension in a folder.
     *
     * @param folderPath    Folder path (relative path from storage)
     * @param typeSort      Sort type for the search function
     * @param typeFilter    Filter type for the search function
     * @param fileExtension File extension
     * @param startDate     Start date
     * @param endDate       End date
     */
    List<String> searchFilesWithExtensionInFolder(String folderPath, String typeSort, String typeFilter, String fileExtension, String startDate, String endDate);

    /**
     * Lists the metadata of all files with a specific substring in a folder.
     *
     * @param folderPath    Folder path (relative path from storage)
     * @param typeSort      Sort type for the search function
     * @param typeFilter    Filter type for the search function
     * @param fileSubstring File substring
     * @param fileExtension File extension for the search function
     * @param startDate     Start date
     * @param endDate       End date
     */
    List<String> searchFilesWithSubstringInFolder(String folderPath, String typeSort, String typeFilter, String fileSubstring, String fileExtension, String startDate, String endDate);

    /**
     * Checks if file(s) with the specified name(s) is(/are) in a folder.
     *
     * @param folderPath    Folder path (relative path from storage)
     * @param fileName      Requested name/names files
     * @return              true or false
     */
    boolean existsInFolder(String folderPath, String[] fileName);

    /**
     * Lists a folder which includes a file with the specified name.
     *
     * @param fileName      File path (Relative path from storage)
     */
    String findFileFolder(String fileName);

    /**
     * Lists the metadata of all files created or modified within a specific date range in a folder.
     *
     * @param folderPath    Folder path (relative path from storage)
     * @param typeSort      Sort type for the search function
     * @param typeFilter    Filter type for the search function
     * @param startDate     Start date for the search function
     * @param endDate       End date for the search function
     * @param fileExtension File extension
     */
    List<String> searchModifiedFilesInFolder(String folderPath, String typeSort, String typeFilter, String fileExtension, String startDate, String endDate);
}
