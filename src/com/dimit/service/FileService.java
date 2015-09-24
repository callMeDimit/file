package com.dimit.service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.content.Context;

public class FileService {
	private Context ctx ;
	/**
	 * 保存文件
	 * @param fileName 文件名称
	 * @param content 文件内容
	 * @throws IOException 
	 */
	public void save(String fileName, String content) throws IOException {
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
