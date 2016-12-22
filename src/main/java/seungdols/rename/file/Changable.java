package seungdols.rename.file;

/**
 * Created by seungdols on 16. 12. 22.
 */
public interface Changable {

    int renameFile();
    String filePath(String directory);
    int renameFiles();
    int renameFileOfDir();
    int changeExt();

}
