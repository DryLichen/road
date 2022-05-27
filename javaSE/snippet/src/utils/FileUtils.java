package utils;

import java.io.File;

/**
 * 批量处理文件
 */
public class FileUtils {

    /**
     * 批量修改某类文件后缀名
     * @param path 需要传入文件的全路径
     */
    public static void renameZip(String path){
        File file = new File(path);

        // 1.路径读取到文件夹
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                renameZip(f.getAbsolutePath());
            }
        } else {
            // 2.路径读取到文件
            String fileName = file.getAbsolutePath();
            if(fileName.endsWith("ziw")){
                String suffix = fileName.substring(0, file.getAbsolutePath().lastIndexOf("."));
                file.renameTo(new File(suffix + ".zip"));
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    /**
     *
     */
    public static void unZipFile(){

    }
}
