package com.example.administrator.dspm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *�����༭�ռ�
 *��Ҫ����һ��������isSave()������������;
 */
public class SecondAtivity extends Activity {

	EditText ed1,ed2;
	Button bt2;
	Button bt1;
	MyDataBase myDatabase;
	Cuns cun;
	int ids;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		ed1=(EditText) findViewById(R.id.editText1);
		ed2=(EditText) findViewById(R.id.editText2);
		bt1=(Button) findViewById(R.id.button1);
		bt2 = (Button) findViewById(R.id.button2);
		myDatabase=new MyDataBase(this);
		/*bt2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(SecondAtivity.this,"删除功能还没有添加哦",Toast.LENGTH_SHORT).show();
			}
		});*/
		Intent intent=this.getIntent();
		ids=intent.getIntExtra("ids", 0);
		if(ids!=0){
			cun=myDatabase.getTiandCon(ids);
			ed1.setText(cun.getTitle());
			ed2.setText(cun.getContent());
		}
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isSave();
			}
		});

	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub		
		//super.onBackPressed();
		SimpleDateFormat formatter   =   new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
		Date curDate   =   new Date(System.currentTimeMillis());//��ȡ��ǰʱ��
		String times   =   formatter.format(curDate);
		String title=ed1.getText().toString();
		String content=ed2.getText().toString();
		//��Ҫ�޸�����
		if(ids!=0){
			cun=new Cuns(title,ids, content, times);
			myDatabase.toUpdate(cun);
			Intent intent=new Intent(SecondAtivity.this,Tabhost.class);
			startActivity(intent);
			SecondAtivity.this.finish();
		}
		//�½��ռ�
		else{
			if(title.equals("")&&content.equals("")){
				Toast.makeText(SecondAtivity.this,"添加失败",Toast.LENGTH_SHORT).show();
				Intent intent=new Intent(SecondAtivity.this,Tabhost.class);
				startActivity(intent);
				SecondAtivity.this.finish();
			}
			else{
				cun=new Cuns(title,content,times);
				myDatabase.toInsert(cun);
				Intent intent=new Intent(SecondAtivity.this,Tabhost.class);
				startActivity(intent);
				SecondAtivity.this.finish();
			}
			
		}
	}
	private void isSave(){
				SimpleDateFormat formatter   =   new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
				Date curDate   =   new Date(System.currentTimeMillis());//��ȡ��ǰʱ��
				String times   =   formatter.format(curDate);
				String title=ed1.getText().toString();
				String content=ed2.getText().toString();
				//��Ҫ�޸�����
				if(ids!=0){
					cun=new Cuns(title,ids, content, times);
					myDatabase.toUpdate(cun);
					Intent intent=new Intent(SecondAtivity.this,Tabhost.class);
					startActivity(intent);
					SecondAtivity.this.finish();
				}
				//�½��ռ�
				else{
					cun=new Cuns(title,content,times);
					myDatabase.toInsert(cun);
					Intent intent=new Intent(SecondAtivity.this,Tabhost.class);
					startActivity(intent);
					SecondAtivity.this.finish();
				}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_ativity, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent intent=new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, "���⣺"+ed1.getText().toString()+"    ���ݣ�"+ed2.getText().toString());
			startActivity(intent);
			break;

		default:
			break;
		}
		return false;
	}
	

}
