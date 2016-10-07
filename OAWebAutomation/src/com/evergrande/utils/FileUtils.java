package com.evergrande.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 文件处理类
 * @author 周浩
 * @author 黄志辉
 * 去除了Printer相关
 * @date  2016年10月4日
 */
public class FileUtils{
	
	/**
	 * 创建一个新文件，如果文件存在，则不做操作，如果不存在，则创建
	 * @param fileName 创建的文件名
	 */
	public static void CreateFolder(String fileName){
		File file = new File(fileName);
		if(file.exists()){
			return;
		}else{
			file.mkdirs();
		}
	}
	
	/**
	 * 写文件(里面的模式是添加写入的模式,使用","区分)
	 * @param filename 操作文件名
	 * @param str 传入内容
	 */
	public static void writeFileWithComma(String filename,String str){
		File file = new File(filename);
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file,true);
			if(readFile(filename)==null){
				fileWriter.write(str);
			}
			else{
				fileWriter.write(","+str);
			}
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("写文件内容(comma)失败");
			
		}
	}
	
	/**
	 * 写文件(里面的模式是添加写入的模式,使用换行区分)
	 * @param filename 操作文件名
	 * @param str 传入字符串
	 */
	public static void writeFileWithNewLine(String filename,String str){
		File file = new File(filename);
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file,true);
			if(readFile(filename)==null){
				fileWriter.write(str);
			}
			else{
				fileWriter.write("\n"+str);
			}
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("写文件内容(newline)失败");
		}
	}
	
	/**
	 * 读文件内容
	 * @param filename 操作文件名
	 * @return 返回文本内容
	 */
	public static String readFile(String filename){
		File file = new File(filename);
		String str = null;
		try {
			FileReader fileReader = new FileReader(file);
			int strLen = 0;
			char[] content = new char[256];
			while((strLen=fileReader.read(content))>0){
				str = new String(content, 0, strLen);
			}
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读文件失败");
		}
		return str;
	}
	
	/**
	 * 删除文件
	 * @param filename 操作文件名
	 */
	public static void deleteFile(String filename){
		File file = new File(filename);
		file.delete();
	}
	
	/**
	 * 替换匹配行文件内容
	 * @param filename 操作文件名
	 * @param matches 需要替换的内容
	 * @param pattern 替换后的内容
	 */
	public static void replaceStr(String filename,String matches,String pattern){
		File file = new File(filename);
		ArrayList<String> contentList = new ArrayList<String>();
		ArrayList<String> newContentList = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String content = null;
			while((content = bufferedReader.readLine())!=null){
				contentList.add(content);
			}
			Iterator<String> iterator = contentList.iterator();
			while(iterator.hasNext()){
				String each = iterator.next().toString();
				if(each.matches(matches)){
					newContentList.add(pattern);
				}
				else{
					newContentList.add(each);
				}
			}
			fileReader.close();
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			file.delete();
			File newFile = new File(filename);
			newFile.createNewFile();
			FileWriter fileWriter = new FileWriter(newFile,true);
			for(int i=0;i<newContentList.size();i++){
				fileWriter.write(newContentList.get(i)+"\n");
			}
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 重命名文件
	 * @param filename 操作文件名
	 * @param newName 重命名后文件名
	 */
	public static void renameFile(String filename,String newName){
		File file = new File(filename);
		File newFile = new File(newName);
		file.renameTo(newFile);
	}
	
	/**
	 * 拷贝文件
	 * @param srcFileName 源文件
	 * @param destFileName 目标文件
	 * @param overlay 是否覆盖
	 * @return 是否成功
	 */
	public static boolean copyFile(String srcFileName, String destFileName,  
            boolean overlay) {  
        File srcFile = new File(srcFileName);  
        if (!srcFile.exists()) {  
            System.out.println("源文件：" + srcFileName + "不存在！");  
            return false;  
        } else if (!srcFile.isFile()) {  
        	System.out.println("复制文件失败，源文件：" + srcFileName + "不是一个文件！");  
            return false;  
        }  
  
        // 判断目标文件是否存在  
        File destFile = new File(destFileName);  
        if (destFile.exists()) {  
            // 如果目标文件存在并允许覆盖  
            if (overlay) {  
                new File(destFileName).delete();  
            }	else {  
            	System.out.println("复制目录文件失败， 目标文件：" + destFileName + "不允许覆盖！");  
                return false;  
            }    
        } else {  
            // 如果目标文件所在目录不存在，则创建目录  
            if (!destFile.getParentFile().exists()) {  
                // 目标文件所在目录不存在  
                if (!destFile.getParentFile().mkdirs()) {  
                    // 复制文件失败：创建目标文件所在目录失败  
                    return false;  
                }  
            }  
        }  
  
        // 复制文件  
        int byteread = 0; // 读取的字节数  
        InputStream in = null;  
        OutputStream out = null;  
  
        try {  
            in = new FileInputStream(srcFile);  
            out = new FileOutputStream(destFile);  
            byte[] buffer = new byte[1024];  
  
            while ((byteread = in.read(buffer)) != -1) {  
                out.write(buffer, 0, byteread);  
            }  
            return true;  
        } catch (FileNotFoundException e) {  
            return false;  
        } catch (IOException e) {  
            return false;  
        } finally {  
            try {  
                if (out != null)  
                    out.close();  
                if (in != null)  
                    in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	
	
	/**
	 * 复制整个目录
	 * @param srcDirName 源文件目录
	 * @param destDirName 目标文件目录
	 * @param overlay 是否覆盖
	 * @return 是否成功
	 */
    public static boolean copyDirectory(String srcDirName, String destDirName,  
            boolean overlay) {  
        File srcDir = new File(srcDirName);  
        if (!srcDir.exists()) {  
        	System.out.println("复制目录失败：源目录" + srcDirName + "不存在！");  
            return false;  
        } else if (!srcDir.isDirectory()) {  
        	System.out.println("复制目录失败：" + srcDirName + "不是目录！");  
            return false;  
        }  
  
        // 如果目标目录名不是以文件分隔符结尾，则加上文件分隔符  
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }  
        File destDir = new File(destDirName);  
        // 如果目标文件夹存在  
        if (destDir.exists()) {  
            // 如果允许覆盖则删除已存在的目标目录  
            if (overlay) {  
                new File(destDirName).delete();  
            } else {  
            	System.out.println("复制目录失败：目的目录" + destDirName + "已存在！");  
                return false;  
            }  
        } else {  
            // 创建目的目录  
        	System.out.println("目的目录不存在，准备创建。。。");  
        	System.out.println(destDir.getName());
            if (!destDir.mkdirs()) {  
                System.out.println("复制目录失败：创建目的目录失败！");  
                return false;  
            }  
        }  
  
        boolean flag = true;  
        File[] files = srcDir.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            // 复制文件  
            if (files[i].isFile()) {  
                flag = copyFile(files[i].getAbsolutePath(),  
                        destDirName + files[i].getName(), overlay);  
                if (!flag)  
                    break;  
            } else if (files[i].isDirectory()) {  
                flag = copyDirectory(files[i].getAbsolutePath(),  
                        destDirName + files[i].getName(), overlay);  
                if (!flag)  
                    break;  
            }  
        }  
        if (!flag) {  
            return false;  
        } else {  
            return true;  
        }  
    }  
   
}