package com.dimit.service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.content.Context;

public class FileService {
	private Context ctx;

	/**
	 * 保存文件
	 * 
	 * @param fileName
	 *            文件名称
	 * @param content
	 *            文件内容
	 * @throws IOException
	 */
	public void save(String fileName, String content) throws IOException {
		/*
		 * 四种模式： 
		 * 1、Context.MODE_PRIVATE 
		 * 		私有模式只能被本应用使用 
		 * 2、Context.MODE_APPEND
		 * 		追加模式只能被本应用使用，新写入的内容追加到文件末尾
		 * 3、Context.MODE_WORLD_READABLE
		 * 		该模式创建的文件其他应用有读取权限
		 * 4、Context.MODE_WORLD_WRITEABLE
		 * 		其他应用可以写不能读
		 */
		
		FileOutputStream fos = ctx.openFileOutput(fileName, Context.MODE_PRIVATE);
		BufferedWriter wb = new BufferedWriter(new OutputStreamWriter(fos));
		try {
			wb.write(content);
			wb.flush();
		} catch (IOException e) {
			throw e;
		} finally {
			wb.close();
		}
	}

	public static FileService valueOf(Context ctx) {
		FileService result = new FileService();
		result.ctx = ctx;
		return result;
	}
}
