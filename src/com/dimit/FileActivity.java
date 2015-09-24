package com.dimit;

import java.io.IOException;

import com.dimit.service.FileService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileActivity extends Activity {
	/** Called when the activity is first created. */
	private EditText fileNameText;
	private EditText contentText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		fileNameText = (EditText) findViewById(R.id.fileName);
		contentText = (EditText) findViewById(R.id.content);
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String fileName = fileNameText.getText().toString();
				String content = contentText.getText().toString();
				FileService service = FileService.valueOf(FileActivity.this);
				try {
					service.save(fileName, content);
					Toast.makeText(FileActivity.this, R.string.success, Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					Toast.makeText(FileActivity.this, R.string.fail, Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				}
			}
		});
	}
}