package seungdols.rename.file;

import java.io.File;
import java.util.Scanner;

/**
 * @PROJECT effectiveJava
 * @PACKAGE com.tistory.seungdols.File.rename
 * @WRITTER Administrator
 * @DATE 2015-09-21
 * @HISTORY
 * @DISCRIPT
 */

public class FileRename {

    /**
     * data field
     */
    String fileNewName;
    String fileOriginName;
    String path;
    String extOrigin;
    String extNew;

    File originFile;
    File newFile;

    /**
     * Contructor
     */
    public FileRename() {

    }


    /**
     * extract fileName and ext
     *
     * @param originalName
     */
    public void extractName(String originalName) {

        extOrigin = originalName.substring(originalName.lastIndexOf("."));
        System.out.println(extOrigin);
    }

    /**
     * call a extractName method
     * set a new name of File
     */
    public void newFileName() {
        extractName(fileOriginName);
        fileNewName = fileNewName + extNew;
        System.out.println("newFileName : " + fileNewName);
    }

    /**
     * Rename method
     * call inputDataForRename()
     * call newFileName()
     * execute rename
     */
    public void renameFileOne() {
        inputDataForRename(1);
        newFileName();
        originFile = new File(path + fileOriginName);
        newFile = new File(path + fileNewName);
        System.out.println("renameFileOne : " + path + fileOriginName);
        System.out.println("renameFileOne : " + path + fileNewName);
        if (originFile == null) {
            System.out.println("originfile is null");
        }
        if (newFile == null) {
            System.out.println("newFile is null");
        }
        if (originFile.renameTo(newFile)) {
            System.out.println("Rename Successful");
        } else {
            System.out.println("Rename Failed");
        }

    }

    /**
     * (Only file) Rename All in Directory
     */
    public void renameAllFileInDirectory() {
        inputDataForRename(2);
        int number = 0;
        File fPath = new File(path);//해당 경로의 파일
        File[] list = fPath.listFiles();//get file list
        for (File file : list) {
            if (file.isFile())//Is file? true
            {
                //get file name
                fileOriginName = file.getName();
//                System.out.println("file : " + file.getName());
                //set new name of file
                StringBuilder sb = new StringBuilder(path);
                sb.append(fileNewName).append(number).append(extNew);
                File origin = new File(path + fileOriginName);
                File newFileName = new File(sb.toString());
                if (origin.renameTo(newFileName)) {
                    System.out.println("change name of file");
                    number++;
                }

            }

        }

    }

    public void inputDataForRename(int FLAG) {
        Scanner scan = new Scanner(System.in);
        switch (FLAG) {
            case 1:
                System.out.println("path of file  : ");
                path = scan.nextLine();
                System.out.println("Origin Name of file  : ");
                fileOriginName = scan.nextLine();
                System.out.println("New name of file  : ");
                fileNewName = scan.nextLine();
                System.out.println("newExt of file  : ");
                extNew = scan.nextLine();
                break;
            case 2:

                System.out.println("path of directory  : ");
                path = scan.nextLine();
                System.out.println("New name of file  : ");
                fileNewName = scan.nextLine();
                System.out.println("newExt of file  : ");
                extNew = scan.nextLine();
                break;
        }

    }
}
