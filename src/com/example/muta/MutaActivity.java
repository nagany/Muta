package com.example.muta;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.*;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MutaActivity extends Activity implements SensorEventListener{
	private float x = 0;
	private float y = 0;
	private float z = 0;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_muta);
	}
	
	@Override
	public void onResume(){
		super.onResume();
		SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sensorManager.unregisterListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.muta, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
			x = event.values[0];
			y = event.values[1];
			z = event.values[2];
			
			TextView xv =(TextView) findViewById(R.id.textView1);
			TextView yv =(TextView) findViewById(R.id.textView2);
			TextView zv =(TextView) findViewById(R.id.textView3);
			
			xv.setText("X:"+x);
			yv.setText("Y:"+y);
			zv.setText("Z:"+z);
			

			ProgressBar pb1 = (ProgressBar) findViewById(R.id.progressBar1);
			pb1.setMax(2000);
			pb1.setProgress((int)((x+10)*100));
			
			ProgressBar pb2 = (ProgressBar) findViewById(R.id.progressBar2);
			pb2.setMax(2000);
			pb2.setProgress((int)((y+10)*100));
			
			ProgressBar pb3 = (ProgressBar) findViewById(R.id.progressBar3);
			pb3.setMax(2000);
			pb3.setProgress((int)((z+10)*100));
			
		}
	}

}
