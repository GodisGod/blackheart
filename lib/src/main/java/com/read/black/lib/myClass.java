package com.read.black.lib;

import java.io.File;
import java.io.IOException;

public class myClass {
    public static void main(String[] args) {
        System.out.print("hahaha");
        getFileList("D:\\360");

        File file=new File("d:\\movie");
        boolean isDirectory=file.isDirectory();
        if(isDirectory){
            String[]files=file.list();
            for(String path:files){
                String afterPointLetter=path.substring(path.lastIndexOf(".")+1,path.length());
                if(forbidFormat(afterPointLetter)){
                    System.out.println("d:\\movie\\"+path);
                    File deleteFile=new File("d:\\movie\\"+path);
                    if(deleteFile.exists()){
                        deleteFile.delete();
                    }
                }
            }
        }else{
            if(file.isFile()){
                file.delete();
            }
        }

    }

    public static void getFileList(String strPath) {
        File f = new File(strPath);
        if (f.isDirectory()) {
            File[] fs = f.listFiles();
            for (int i = 0; i < fs.length; i++) {
                String fsPath = fs[i].getAbsolutePath();
                System.out.println(fsPath);
                getFileList(fsPath);
            }
        } else if (f.isFile()) {
            String fname = f.getAbsolutePath();
            System.out.println(fname);
        } else {
            System.out.println("路径不正确!");
        }
    }





}
