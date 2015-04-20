package com.example.applehunt;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DemoActivity extends ActionBarActivity {

	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
		
		final int img=getIntent().getExtras().getInt("image");
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		
		switch(img)
			{
			case 1:
				iv.setImageResource(R.drawable.i1);
				break;
			case 2:
				iv.setImageResource(R.drawable.i2);
				break;
			case 3:
				iv.setImageResource(R.drawable.i3);
				break;
			case 4:
				iv.setImageResource(R.drawable.i4);
				break;
			case 5:
				iv.setImageResource(R.drawable.i5);
				break;
			case 6:
				iv.setImageResource(R.drawable.i6);
				break;
			case 7:
				iv.setImageResource(R.drawable.i7);
				break;
			case 8:
				iv.setImageResource(R.drawable.i8);
				break;
			case 9:
				iv.setImageResource(R.drawable.i9);
				break;
			case 10:
				iv.setImageResource(R.drawable.i10);
				break;
			case 11:
				iv.setImageResource(R.drawable.i11);
				break;
			case 12:
				iv.setImageResource(R.drawable.i12);
				break;
			case 13:
				iv.setImageResource(R.drawable.i13);
				break;
			case 14:
				iv.setImageResource(R.drawable.i14);
				break;
			case 15:
				iv.setImageResource(R.drawable.i15);
				break;
			case 16:
				iv.setImageResource(R.drawable.i16);
				break;
			case 17:
				iv.setImageResource(R.drawable.i17);
				break;
			case 18:
				iv.setImageResource(R.drawable.i18);
				break;
			case 19:
				iv.setImageResource(R.drawable.i19);
				break;
			case 20:
				iv.setImageResource(R.drawable.i20);
				break;
			case 21:
				iv.setImageResource(R.drawable.i21);
				break;
			case 22:
				iv.setImageResource(R.drawable.i22);
				break;
			case 23:
				iv.setImageResource(R.drawable.i23);
				break;
			case 24:
				iv.setImageResource(R.drawable.i24);
				break;
			case 25:
				iv.setImageResource(R.drawable.i25);
				break;
			case 26:
				iv.setImageResource(R.drawable.i26);
				break;
			case 27:
				iv.setImageResource(R.drawable.i27);
				break;
			case 28:
				iv.setImageResource(R.drawable.i28);
				break;
			case 29:
				iv.setImageResource(R.drawable.i29);
				break;
			case 30:
				iv.setImageResource(R.drawable.i30);
				break;
			case 31:
				iv.setImageResource(R.drawable.i31);
				break;
			case 32:
				iv.setImageResource(R.drawable.i32);
				break;
			case 33:
				iv.setImageResource(R.drawable.i33);
				break;
			case 34:
				iv.setImageResource(R.drawable.i34);
				break;
			}
		
		Button bkwd=(Button)findViewById(R.id.button1);
		if(img==1)
			bkwd.setEnabled(false);
		bkwd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(DemoActivity.this,DemoActivity.class);
				intent.putExtra("image", img-1);
				startActivity(intent);
			}
		});
		
		Button frwd=(Button)findViewById(R.id.button3);
		if(img==34)
			frwd.setEnabled(false);
		frwd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(DemoActivity.this,DemoActivity.class);
				intent.putExtra("image", img+1);
				startActivity(intent);
			}
		});
		
		Button skp=(Button)findViewById(R.id.button2);
		skp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(DemoActivity.this,HunterActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
