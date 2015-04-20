package com.example.applehunt;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HunterActivity extends ActionBarActivity {
	
	
	int[] occupied=new int[]{0,0,0,0,0,0,0,1,1,1,0,2,2,2,1,1,1,0,2,2,2,1,1,1,0,2,2,2,0,0,0,0,0,0};
	int[][] edges=new int[][]
		{
		{0,0,0,0,0,0,0,0,0,0},
		{2,4,5,0,0,0,0,0,0,0},
		{1,3,4,5,6,0,0,0,0,0},
		{2,5,6,0,0,0,0,0,0,0},
		{1,2,5,9,10,0,0,0,0,0},
		{1,2,3,4,6,9,10,11,0,0},
		{2,3,5,10,11,0,0,0,0,0},
		{8,14,15,0,0,0,0,0,0,0},
		{7,9,14,15,16,0,0,0,0,0},
		{4,5,8,10,15,16,17,0,0,0},
		{4,5,6,9,11,16,17,18,0,0},					//10
		{5,6,10,12,17,18,19,0,0,0},
		{11,13,18,19,20,0,0,0,0,0},
		{12,19,20,0,0,0,0,0,0,0},
		{7,8,15,21,22,0,0,0,0,0},
		{7,8,9,14,16,21,22,23,0,0},
		{8,9,10,15,17,22,23,24,0,0},
		{9,10,11,16,18,23,24,25,0,0},
		{10,11,12,17,19,24,25,26,0,0},
		{11,12,13,18,20,25,26,27,0,0},
		{12,13,19,26,27,0,0,0,0,0},					//20
		{14,15,22,0,0,0,0,0,0,0},
		{14,15,16,21,23,0,0,0,0,0},
		{15,16,17,22,24,28,29,0,0,0},
		{16,17,18,23,25,28,29,30,0,0},
		{17,18,19,24,26,29,30,0,0,0},
		{18,19,20,25,27,0,0,0,0,0},
		{19,20,26,0,0,0,0,0,0,0},
		{23,24,29,31,32,0,0,0,0,0},
		{23,24,25,28,30,31,32,33,0,0},
		{24,25,29,32,33,0,0,0,0,0},
		{28,29,32,0,0,0,0,0,0,0},
		{28,29,30,31,33,0,0,0,0,0},
		{29,30,32,0,0,0,0,0,0,0}
		};
	int[][] crossable=new int[][]
			{
			{1,2,3,0,0},
			{4,5,6,0,0},
			{7,8,9,10,11,12,13,0,0},
			{14,15,16,17,18,19,20,0,0},
			{21,22,23,24,25,26,27,0,0},
			{28,29,30,0,0},
			{31,32,33,0,0},
			{7,14,21,0,0},
			{8,15,22,0,0},
			{1,4,9,16,23,28,31,0,0},
			{2,5,10,17,24,29,32,0,0},
			{3,6,11,18,25,30,33,0,0},
			{12,19,26,0,0},
			{13,20,27,0,0},
			{21,15,9,5,3,0,0},
			{22,16,10,6,0,0},
			{23,17,11,0,0},
			{28,24,18,12,0,0},
			{31,29,25,19,13,0,0},
			{1,5,11,19,27,0,0},
			{4,10,18,26,0,0},
			{9,17,25,0,0},
			{8,16,24,30,0,0},
			{7,15,23,29,33,0,0}
			};
	int turn=1;
	int selected=0;
	int item=0;
	int crossed=0;
	short crossed_apple=0;
	short crossed_orange=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hunter);
		
		final AlertDialog.Builder adb=new AlertDialog.Builder(this);
		
		final ImageView i1=(ImageView)findViewById(R.id.iv1);
		final ImageView i2=(ImageView)findViewById(R.id.iv2);
		final ImageView i3=(ImageView)findViewById(R.id.iv3);
		final ImageView i4=(ImageView)findViewById(R.id.iv4);
		final ImageView i5=(ImageView)findViewById(R.id.iv5);
		final ImageView i6=(ImageView)findViewById(R.id.iv6);
		final ImageView i7=(ImageView)findViewById(R.id.iv7);
		final ImageView i8=(ImageView)findViewById(R.id.iv8);
		final ImageView i9=(ImageView)findViewById(R.id.iv9);
		final ImageView i10=(ImageView)findViewById(R.id.iv10);
		final ImageView i11=(ImageView)findViewById(R.id.iv11);
		final ImageView i12=(ImageView)findViewById(R.id.iv12);
		final ImageView i13=(ImageView)findViewById(R.id.iv13);
		final ImageView i14=(ImageView)findViewById(R.id.iv14);
		final ImageView i15=(ImageView)findViewById(R.id.iv15);
		final ImageView i16=(ImageView)findViewById(R.id.iv16);
		final ImageView i17=(ImageView)findViewById(R.id.iv17);
		final ImageView i18=(ImageView)findViewById(R.id.iv18);
		final ImageView i19=(ImageView)findViewById(R.id.iv19);
		final ImageView i20=(ImageView)findViewById(R.id.iv20);
		final ImageView i21=(ImageView)findViewById(R.id.iv21);
		final ImageView i22=(ImageView)findViewById(R.id.iv22);
		final ImageView i23=(ImageView)findViewById(R.id.iv23);
		final ImageView i24=(ImageView)findViewById(R.id.iv24);
		final ImageView i25=(ImageView)findViewById(R.id.iv25);
		final ImageView i26=(ImageView)findViewById(R.id.iv26);
		final ImageView i27=(ImageView)findViewById(R.id.iv27);
		final ImageView i28=(ImageView)findViewById(R.id.iv28);
		final ImageView i29=(ImageView)findViewById(R.id.iv29);
		final ImageView i30=(ImageView)findViewById(R.id.iv30);
		final ImageView i31=(ImageView)findViewById(R.id.iv31);
		final ImageView i32=(ImageView)findViewById(R.id.iv32);
		final ImageView i33=(ImageView)findViewById(R.id.iv33);
		final ImageView as=(ImageView)findViewById(R.id.sa);
		final ImageView os=(ImageView)findViewById(R.id.so);
		final TextView appsc=(TextView)findViewById(R.id.app_score);
		final TextView orsc=(TextView)findViewById(R.id.or_score);
		final ImageView tn=(ImageView)findViewById(R.id.imageView1);
		final ImageView wa=(ImageView)findViewById(R.id.winner_app);
		final ImageView wo=(ImageView)findViewById(R.id.winner_or);
		final ImageView w=(ImageView)findViewById(R.id.win);
		final Button fb=(Button)findViewById(R.id.button2);
		
		
		final Drawable apple=i7.getDrawable();
		final Drawable orange=i11.getDrawable();
		final Drawable empty=i1.getDrawable();
		final Drawable sel_apple=as.getDrawable();
		final Drawable sel_orange=os.getDrawable();
		final Drawable winner=w.getDrawable();
		as.setImageDrawable(null);
		os.setImageDrawable(null);
		w.setImageDrawable(null);
		
		
		fb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(HunterActivity.this,FeedbackActivity.class);
				startActivity(intent);
								
			}
		});
		
		
		Button rstrt=(Button)findViewById(R.id.button1);
		rstrt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				adb.setMessage("                       Restart ?");
				adb.setPositiveButton("Yes",new DialogInterface.OnClickListener() 
					{
					@Override
					public void onClick(DialogInterface dialog, int which) 
						{
						Intent intent=new Intent(HunterActivity.this,HunterActivity.class);
						startActivity(intent);
						}
					});
				adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
	
					}
				});
				final AlertDialog ad=adb.create();
				ad.show();		
			}
		});
		
		Button bt3=(Button)findViewById(R.id.button3);
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				adb.setMessage("This feature will be available in the next version.");
				adb.setPositiveButton("OK",new DialogInterface.OnClickListener() 
					{
					@Override
					public void onClick(DialogInterface dialog, int which) 
						{
						}
					});
				final AlertDialog ad=adb.create();
				ad.show();				
			}
		});	

		
		i1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				clicked(1,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
				}
			});
		
		i2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				clicked(2,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
				}
			});
		
		
		i3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				clicked(3,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
				}
			});
		
		i4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				clicked(4,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
				}
			});
		
		
		i5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				clicked(5,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				clicked(6,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i7.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) 
				{
			
				clicked(7,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
				}
			});	
		
		
		i8.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				clicked(8,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
				}
			});
		
		i9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				clicked(9,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i10.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				clicked(10,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(11,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i12.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				clicked(12,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i13.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				clicked(13,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i14.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(14,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i15.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(15,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i16.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(16,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i17.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(17,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i18.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(18,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i19.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(19,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i20.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(20,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i21.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				clicked(21,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
				}
			});
		
		i22.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(22,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i23.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(23,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i24.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(24,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i25.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(25,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i26.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(26,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i27.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(27,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i28.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(28,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i29.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(29,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i30.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(30,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i31.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(31,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i32.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(32,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
		i33.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clicked(33,apple,orange,sel_apple,sel_orange,empty,appsc,orsc,tn,wa,wo,winner);
			}
		});
		
	}
	
	
	public void deselect(Drawable apple,Drawable orange,Drawable sel_apple,Drawable sel_orange)
		{
		if(selected==0)
			return;
		ImageView iv =findView(selected);
		if(iv.getDrawable()==sel_apple)
			iv.setImageDrawable(apple);
		else if(iv.getDrawable()==sel_orange)
			iv.setImageDrawable(orange);
		}
	
	
	public void interchange(int no,Drawable empty)
		{
		ImageView tiv=findView(no);
		ImageView siv =findView(selected);
		tiv.setImageDrawable(siv.getDrawable());
		siv.setImageDrawable(empty);
		occupied[no]=occupied[selected];
		occupied[selected]=0;
		selected=no;
		}
	
	
	public ImageView findView(int no)
		{
		switch(no)
		{
		case 1:
			return (ImageView)findViewById(R.id.iv1);
		case 2:
			return (ImageView)findViewById(R.id.iv2);
		case 3:
			return (ImageView)findViewById(R.id.iv3);
		case 4:
			return (ImageView)findViewById(R.id.iv4);
		case 5:
			return (ImageView)findViewById(R.id.iv5);
		case 6:
			return (ImageView)findViewById(R.id.iv6);
		case 7:
			return (ImageView)findViewById(R.id.iv7);
		case 8:
			return (ImageView)findViewById(R.id.iv8);
		case 9:
			return (ImageView)findViewById(R.id.iv9);
		case 10:
			return (ImageView)findViewById(R.id.iv10);
		case 11:
			return (ImageView)findViewById(R.id.iv11);
		case 12:
			return (ImageView)findViewById(R.id.iv12);
		case 13:
			return (ImageView)findViewById(R.id.iv13);
		case 14:
			return (ImageView)findViewById(R.id.iv14);
		case 15:
			return (ImageView)findViewById(R.id.iv15);
		case 16:
			return (ImageView)findViewById(R.id.iv16);
		case 17:
			return (ImageView)findViewById(R.id.iv17);
		case 18:
			return (ImageView)findViewById(R.id.iv18);
		case 19:
			return (ImageView)findViewById(R.id.iv19);
		case 20:
			return (ImageView)findViewById(R.id.iv20);
		case 21:
			return (ImageView)findViewById(R.id.iv21);
		case 22:
			return (ImageView)findViewById(R.id.iv22);
		case 23:
			return (ImageView)findViewById(R.id.iv23);
		case 24:
			return (ImageView)findViewById(R.id.iv24);
		case 25:
			return (ImageView)findViewById(R.id.iv25);
		case 26:
			return (ImageView)findViewById(R.id.iv26);
		case 27:
			return (ImageView)findViewById(R.id.iv27);
		case 28:
			return (ImageView)findViewById(R.id.iv28);
		case 29:
			return (ImageView)findViewById(R.id.iv29);
		case 30:
			return (ImageView)findViewById(R.id.iv30);
		case 31:
			return (ImageView)findViewById(R.id.iv31);
		case 32:
			return (ImageView)findViewById(R.id.iv32);
		case 33:
			return (ImageView)findViewById(R.id.iv33);
		default:
			return null;
		}
	}
	
	
public int isCrossable(int selected,int no)
	{
	int i,j;
	for(i=0;i<24;i++)
		{
		for(j=0;crossable[i][j]!=0;j++)
			{
			if((crossable[i][j]==selected&&crossable[i][j+2]==no)||(crossable[i][j]==no&&crossable[i][j+2]==selected))
				{
				if(occupied[crossable[i][j+1]]!=0&&occupied[crossable[i][j+1]]!=turn)
					{
					crossed=1;
					if(turn==1)
						crossed_orange++;
					if(turn==2)
						crossed_apple++;
					return crossable[i][j+1];
					}
				}
			}
		}
	return 0;
	}
	

public void setScore(TextView appsc,TextView orsc)
	{
	appsc.setText("Score: "+String.valueOf(crossed_orange*10));
	orsc.setText("Score: "+String.valueOf(crossed_apple*10));
	}

public int isLocked()
	{
	int l=(turn==1)?2:1;
	for(int i=1;i<34;i++)
		{
		if(occupied[i]==l)
			{
			for(int j=0;edges[i][j]!=0;j++)
				{
				if(occupied[edges[i][j]]==0)
					{
					return 0;
					}
				}
			}
		}
	return 1;
	}


public void isEnded(Drawable app,ImageView wa,ImageView wo,Drawable winner)
	{
	int l=isLocked();
	if(crossed_apple==9||(turn==2&&l==1)||crossed_orange==9||(turn==1&&l==1))
		{
		if(crossed_apple==9||(turn==2&&l==1))
			wo.setImageDrawable(winner);
		else
			wa.setImageDrawable(winner);
		
		MediaPlayer mp=MediaPlayer.create(getApplicationContext(), R.raw.appraisal);
		mp.start();
		
		final AlertDialog.Builder adb=new AlertDialog.Builder(this);
		adb.setMessage("                         GAME OVER !!!");
		adb.setPositiveButton("OK",new DialogInterface.OnClickListener() 
			{
			@Override
			public void onClick(DialogInterface dialog, int which) 
				{
				
				}
			});
		adb.setIcon(app);
		final AlertDialog ad=adb.create();
		ad.show();	
		}
	}

public void clicked(int no,Drawable apple,Drawable orange,Drawable sel_apple,Drawable sel_orange,Drawable empty,TextView appsc,TextView orsc,ImageView tn,ImageView wa,ImageView wo,Drawable winner)
	{	
	isEnded(apple,wa,wo,winner);
	if(crossed==1&&selected==no)
		{
		if(turn==1)
			{
			tn.setImageDrawable(orange);
			turn=2;
			}
		else
			{
			tn.setImageDrawable(apple);
			turn=1;
			}
		deselect(apple,orange,sel_apple,sel_orange);
		selected=0;
		crossed=0;
		return;
		}
	if(occupied[no]==0&&selected!=0)
		{
		for(int i=0;i<10;i++)
			{
			if(edges[no][i]==selected)
				{
				interchange(no,empty);
				if(turn==1)
					{
					tn.setImageDrawable(orange);
					turn=2;
					}
				else
					{
					tn.setImageDrawable(apple);
					turn=1;
					}
				deselect(apple,orange,sel_apple,sel_orange);
				selected=0;
				crossed=0;
				return;
				}
			}
		
		int c=isCrossable(selected,no);
		setScore(appsc,orsc);
		if(c!=0)
			{
			ImageView iv=findView(c);
			iv.setImageDrawable(empty);
			occupied[c]=0;
			interchange(no,empty);
			}
		}
	
	if(turn==occupied[no]&&selected!=no&&crossed==0)
		{
		ImageView v=findView(no);
		if(occupied[no]==1)
			v.setImageDrawable(sel_apple);
		else if(occupied[no]==2)
			v.setImageDrawable(sel_orange);
		deselect(apple,orange,sel_apple,sel_orange);
		selected=no;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hunter, menu);
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
