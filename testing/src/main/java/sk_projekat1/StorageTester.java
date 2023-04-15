package sk_projekat1;

import java.util.List;
import java.util.Scanner;

public class StorageTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        args = new String[1];
        args[0] = in.next();

        if (args[0] == null) {
            System.out.println("You have to insert the absolute path.");
            System.exit(0);
        }

        try {
            Class.forName("sk_projekat1.ImplementationLocal");
           // Class.forName("sk_projekat1.ImplementationDrive");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Storage st = StorageManager.getStorage();

        String menu1 = "Choose an option:" +
                "\n\t1. Create folder" +
                "\n\t2. Create file" +
                "\n\t3. Move file" +
                "\n\t4. Rename file object" +
                "\n\t5. Delete file object" +
                "\n\t6. Import file object" +
                "\n\t7. Export file object" +
                "\n\t8. Search files..." +
                "\n\t9. Exit";
        String menu2 = "Choose an option:" +
                "\n\t1. Create storage" +
                "\n\t2. Create default storage";
        String menu3 = "Choose an option:" +
                "\n\t1. Search files in a folder" +
                "\n\t2. Search files in a folder including subfolders" +
                "\n\t3. Search files with a file extension in a folder" +
                "\n\t4. Search files with a substring in a folder" +
                "\n\t5. Check if a file exists in a folder" +
                "\n\t6. Find the folder for a given file" +
                "\n\t7. Search modified files in a folder for a given date" +
                "\n\tNOTE: YYYY-MM-DD is the actual date format";

        String path = args[0];
        if (StorageManager.existsStorage(path)) {
            System.out.println("Your storage exists.\n");
            while (true) {
                try {
                    String inLine = in.nextLine();
                    switch (inLine) {
                        case "1":
                            while (true) {
                                System.out.println("If you want to create a folder in the root directory, type Root relative path as '.'");
                                System.out.println("If you want to create a folder in the subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The Folder Name' and 'The Folder Relative Path' separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.createFolder(inLineSplit[0], inLineSplit[1])) {
                                    System.out.println("Folder created successfully.");
                                }

                                break;
                            }
                            break;
                        case "2":
                            while (true) {
                                System.out.println("If you want to create a file in the root directory, type Root relative path as '.'");
                                System.out.println("If you want to create a file in the subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The File Name' and 'The File Relative Path' separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.createFile(inLineSplit[0], inLineSplit[1])) {
                                    System.out.println("File created successfully.");
                                }

                                break;
                            }
                            break;
                        case "3":
                            while (true) {
                                System.out.println("If you want to move a file , type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The OLD File Relative Path' and 'The New File Relative Path' separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.moveFile(inLineSplit[0], inLineSplit[1]))
                                    System.out.println("File moved successfully.");

                                break;
                            }
                            break;
                        case "4":
                            while (true) {
                                System.out.println("If you want to rename the root, type Root relative path as '.'");
                                System.out.println("If you want to rename a file object located in the subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The New Name' and 'The Relative Path' separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.renameFileObject(inLineSplit[0], inLineSplit[1]))
                                    System.out.println("File Object renamed successfully.");

                                break;
                            }
                            break;
                        case "5":
                            while (true) {
                                System.out.println("If you want to delete a file object, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The File Object Relative Path' ");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 1) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.deleteFileObject(inLineSplit[0]))
                                    System.out.println("File Object deleted successfully.");

                                break;
                            }
                            break;
                        case "6":
                            while (true) {
                                System.out.println("If you want to import a files, type File absolute path. If you want multiple files to import separate with ','");
                                System.out.println("If you want to import a files in the root, type Root relative path as '.'");
                                System.out.println("If you want to import a file in root located somewhere in the subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The File/s Absolute Path' and 'Relative Path in Storage'");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.importFileObject(inLineSplit[0].split(","), inLineSplit[1]))
                                    System.out.println("File/s imported successfully.");

                                break;
                            }
                            break;
                        case "7":
                            while (true) {
                                System.out.println("If you want to export a file, type absolute path where you want to export your file");
                                System.out.println("Type Root relative path as '.' or  Type relative path as '/' At The BEGINNING and BETWEEN directories for Files. ");
                                System.out.println("Enter 'The File Relative Path' and 'Export Location Absolute Path'");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.exportFileObject(inLineSplit[0], inLineSplit[1]))
                                    System.out.println("File exported successfully.");

                                break;
                            }
                            break;
                        case "8":
                            while (true) {
                                System.out.println(menu3);
                                inLine = in.nextLine();
                                switch (inLine) {
                                    case "1":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 1) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolder(inLineSplit[0], sortType, filterType, null, null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolder(inLineSplit[0], sortType, filterType, null, inLineSplit[1], inLineSplit[2]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "2":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 1) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolders(inLineSplit[0], sortType, filterType, null, null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolders(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolders(inLineSplit[0], sortType, filterType, null, inLineSplit[1], inLineSplit[2]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "3":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithExtensionInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 4) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithExtensionInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], inLineSplit[2], inLineSplit[3]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "4":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath fileSubstring");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithSubstringInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileSubstring fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithSubstringInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], inLineSplit[2], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath fileSubstring startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 4) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithSubstringInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, inLineSplit[2], inLineSplit[3]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "5":
                                        while (true) {
                                            System.out.println("INPUT ORDER: folderPath, fileName[]");
                                            inLine = in.nextLine();

                                            String[] inLineSplit = inLine.split("[ \\t]");
                                            if (inLineSplit.length < 2) {
                                                System.out.println("Invalid argument, try again.");
                                                break;
                                            }

                                            String inLineFolderPath = inLineSplit[0];
                                            System.arraycopy(inLineSplit, 1, inLineSplit, 0, inLineSplit.length - 1);

                                            System.out.println("\nSEARCH RESULT:");
                                            if (st.existsInFolder(inLineFolderPath, inLineSplit)) {
                                                System.out.println("All specified files do exist in " + inLineFolderPath + ".\n");
                                            } else {
                                                System.out.println("One or more specified files do not exist in " + inLineFolderPath + ".\n");
                                            }

                                            break;
                                        }
                                        break;
                                    case "6":
                                        while (true) {
                                            System.out.println("INPUT ORDER: fileName");
                                            inLine = in.nextLine();

                                            String[] inLineSplit = inLine.split("[ \\t]");
                                            if (inLineSplit.length != 1) {
                                                System.out.println("Invalid argument, try again.");
                                                break;
                                            }

                                            System.out.println("\nSEARCH RESULT:\n" +
                                                    st.findFileFolder(inLineSplit[0]));

                                            break;
                                        }
                                        break;
                                    case "7":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchModifiedFilesInFolder(inLineSplit[0], sortType, filterType, null, inLineSplit[1], inLineSplit[2]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension startDate endDate");
                                                    inLine = in.nextLine();
                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 4) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchModifiedFilesInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], inLineSplit[2], inLineSplit[3]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                }
                                break;
                            }
                            break;
                        case "9":
                            System.out.println("Program successfully finished.");
                            System.exit(0);
                            break;
                    }

                    System.out.println(menu1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println(menu1);
                }
            }
        } else {
            System.out.println("Your storage does not exist.\n");
            boolean created = false;

            while (!created) {
                String inLine = in.nextLine();
                switch (inLine) {
                    case "1":
                        while (true) {
                            System.out.println("Enter 'The Storage Name' and 'The Storage Absolute Path' and 'Storage Byte Size' and 'Storage Restricted Extensions'" +
                                    " and 'Max Files in Storage' separated by a space.");
                            System.out.println("If you want restrict multiple extensions separate with ','");
                            inLine = in.nextLine();
                            String[] inLineSplit = inLine.split(" ");

                            if (inLineSplit.length != 5) {
                                System.out.println("Invalid argument, try again.");
                                break;
                            }

                            if (st.createStorage(inLineSplit[0], inLineSplit[1], Integer.parseInt(inLineSplit[2]), inLineSplit[3], Integer.parseInt(inLineSplit[4]))) {
                                created = true;
                                System.out.println("Storage created successfully.");
                            }
                            break;
                        }
                        break;
                    case "2":
                        if (st.createDefaultStorage()) {
                            created = true;
                            System.out.println("Default Storage created successfully.");
                        }
                        break;

                }
                if (!created) {
                    System.out.println(menu2);
                }
            }

            System.out.println(menu1);

            while (true) {
                try {
                    String inLine = in.nextLine();
                    switch (inLine) {
                        case "1":
                            while (true) {
                                System.out.println("If you want to create a folder in the root directory, type Root relative path as '.'");
                                System.out.println("If you want to create a folder in the subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The Folder Name' and 'The Folder Relative Path'  separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.createFolder(inLineSplit[0], inLineSplit[1])) {
                                    System.out.println("Folder created successfully.");
                                }

                                break;
                            }
                            break;
                        case "2":
                            while (true) {
                                System.out.println("If you want to create a file in the root directory, type Root relative path as '.'");
                                System.out.println("If you want to create a file in the  subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The File Name' and 'The File Relative Path' separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.createFile(inLineSplit[0], inLineSplit[1])) {
                                    System.out.println("File created successfully.");
                                }

                                break;
                            }
                            break;
                        case "3":
                            while (true) {
                                System.out.println("If you want to move a file , type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The OLD File Relative Path' and 'The New File Relative Path' separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.moveFile(inLineSplit[0], inLineSplit[1]))
                                    System.out.println("File moved successfully.");

                                break;
                            }
                            break;
                        case "4":
                            while (true) {
                                System.out.println("If you want to rename the root, type Root relative path as '.'");
                                System.out.println("If you want to rename a file object located in the subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The New Name' and 'The Relative Path' separated by a space.");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.renameFileObject(inLineSplit[0], inLineSplit[1]))
                                    System.out.println("File Object renamed successfully.");

                                break;
                            }
                            break;
                        case "5":
                            while (true) {
                                System.out.println("If you want to delete a file object, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The File Object Relative Path' ");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 1) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.deleteFileObject(inLineSplit[0]))
                                    System.out.println("File Object deleted successfully.");

                                break;
                            }
                            break;
                        case "6":
                            while (true) {
                                System.out.println("If you want to import a files, type File absolute path. If you want multiple files to import separate with ','");
                                System.out.println("If you want to import a files in the root, type Root relative path as '.'");
                                System.out.println("If you want to import a file in root located somewhere in the subfolders, type relative path as '/' At The BEGINNING and BETWEEN directories.");
                                System.out.println("Enter 'The File/s Absolute Path' and 'Relative Path in Storage'");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.importFileObject(inLineSplit[0].split(","), inLineSplit[1]))
                                    System.out.println("File/s imported successfully.");

                                break;
                            }
                            break;
                        case "7":
                            while (true) {
                                System.out.println("If you want to export a file, type absolute path where you want to export your file");
                                System.out.println("Type Root relative path as '.' or  Type relative path as '/' At The BEGINNING and BETWEEN directories for Files. ");
                                System.out.println("Enter 'The File Relative Path' and 'Export Location Absolute Path'");
                                inLine = in.nextLine();
                                String[] inLineSplit = inLine.split("[ \\t]");

                                if (inLineSplit.length != 2) {
                                    System.out.println("Invalid argument, try again.");
                                    break;
                                }

                                if (st.exportFileObject(inLineSplit[0], inLineSplit[1]))
                                    System.out.println("File exported successfully.");

                                break;
                            }
                            break;
                        case "8":
                            while (true) {
                                System.out.println(menu3);
                                inLine = in.nextLine();
                                switch (inLine) {
                                    case "1":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 1) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolder(inLineSplit[0], sortType, filterType, null, null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolder(inLineSplit[0], sortType, filterType, null, inLineSplit[1], inLineSplit[2]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "2":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 1) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolders(inLineSplit[0], sortType, filterType, null, null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolders(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesInFolders(inLineSplit[0], sortType, filterType, null, inLineSplit[1], inLineSplit[2]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "3":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithExtensionInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 4) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithExtensionInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], inLineSplit[2], inLineSplit[3]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "4":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION, MODIFIED_DATE, CREATED_DATE)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath fileSubstring");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 2) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithSubstringInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileSubstring fileExtension");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithSubstringInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], inLineSplit[2], null, null);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "MODIFIED_DATE":
                                                case "CREATED_DATE": {
                                                    System.out.println("INPUT ORDER: folderPath fileSubstring startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 4) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchFilesWithSubstringInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], null, inLineSplit[2], inLineSplit[3]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    case "5":
                                        while (true) {
                                            System.out.println("INPUT ORDER: folderPath, fileName[]");
                                            inLine = in.nextLine();

                                            String[] inLineSplit = inLine.split("[ \\t]");
                                            if (inLineSplit.length < 2) {
                                                System.out.println("Invalid argument, try again.");
                                                break;
                                            }

                                            String inLineFolderPath = inLineSplit[0];
                                            System.arraycopy(inLineSplit, 1, inLineSplit, 0, inLineSplit.length - 1);

                                            System.out.println("\nSEARCH RESULT:");
                                            if (st.existsInFolder(inLineFolderPath, inLineSplit)) {
                                                System.out.println("All specified files do exist in " + inLineFolderPath + ".\n");
                                            } else {
                                                System.out.println("One or more specified files do not exist in " + inLineFolderPath + ".\n");
                                            }

                                            break;
                                        }
                                        break;
                                    case "6":
                                        while (true) {
                                            System.out.println("INPUT ORDER: fileName");
                                            inLine = in.nextLine();

                                            String[] inLineSplit = inLine.split("[ \\t]");
                                            if (inLineSplit.length != 1) {
                                                System.out.println("Invalid argument, try again.");
                                                break;
                                            }

                                            System.out.println("\nSEARCH RESULT:\n" +
                                                    st.findFileFolder(inLineSplit[0]));

                                            break;
                                        }
                                        break;
                                    case "7":
                                        while (true) {
                                            System.out.println("Sort type:" +
                                                    "\n\t(null, ALPHABETICAL_ASC, ALPHABETICAL_DESC, CREATED_DATE_ASC, CREATED_DATE_DESC, MODIFIED_DATE_ASC, MODIFIED_DATE_DESC)");
                                            String sortType = in.nextLine();

                                            System.out.println("Filter type:" +
                                                    "\n\t(null, FILE_EXTENSION)");
                                            String filterType = in.nextLine();

                                            switch (filterType) {
                                                case "null": {
                                                    System.out.println("INPUT ORDER: folderPath startDate endDate");
                                                    inLine = in.nextLine();

                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 3) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchModifiedFilesInFolder(inLineSplit[0], sortType, filterType, null, inLineSplit[1], inLineSplit[2]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                case "FILE_EXTENSION": {
                                                    System.out.println("INPUT ORDER: folderPath fileExtension startDate endDate");
                                                    inLine = in.nextLine();
                                                    String[] inLineSplit = inLine.split("[ \\t]");
                                                    if (inLineSplit.length != 4) {
                                                        System.out.println("Invalid argument, try again.");
                                                        break;
                                                    }

                                                    List<String> files = st.searchModifiedFilesInFolder(inLineSplit[0], sortType, filterType, inLineSplit[1], inLineSplit[2], inLineSplit[3]);

                                                    System.out.println("\nSEARCH RESULT:");
                                                    if (files != null) {
                                                        for (String file : files) {
                                                            System.out.println(file + "\n");
                                                        }
                                                    } else {
                                                        System.out.println("No such files were found.");
                                                    }

                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Function not supported.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                }
                                break;
                            }
                            break;
                        case "9":
                            System.out.println("Program successfully finished.");
                            System.exit(0);
                            break;
                    }

                    System.out.println(menu1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println(menu1);
                }
            }
        }
    }
}