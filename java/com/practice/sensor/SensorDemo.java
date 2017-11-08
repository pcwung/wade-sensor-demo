package com.practice.sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SensorDemo extends Activity {
	
	private String SERVICE_NAME = Context.SENSOR_SERVICE;
	
	//用来管理Andorid设备上可用的传感器
	private SensorManager sensorManager; 
	
	private Sensor orientSensor;
	private Sensor teampSensor;
	private Sensor psSensor;
	private Sensor lightSensor;




    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        config();
    }
    
    @Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		//第四步：注册传感器事件监听事件
		sensorManager.registerListener(mySensorListener, orientSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(mySensorListener1, teampSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(mySensorListener2, psSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(mySensorListener3, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);


	}

	@Override
	protected void onPause() {
		super.onPause();
    	//第五步：注销传感器事件的监听
    	sensorManager.unregisterListener(mySensorListener);
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	private void config() {
    	//第一步：获得SensorManager对象
    	sensorManager = (SensorManager)getSystemService(SERVICE_NAME);
    	//第二步：获得特定的传感器
    	orientSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
		teampSensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
		psSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    	
    	if(orientSensor==null) {
    		//不支持此传感器
    	}
    	
    }
    
	//第三步 创建监听类

    SensorEventListener mySensorListener = new SensorEventListener() {

    	//传感器的值改变调用此方法
		@Override
		public void onSensorChanged(SensorEvent event) {
			float x = event.values[0];
			System.out.println("pm2.5 is :" + x);
			final TextView tx2 = (TextView)findViewById(R.id.textView);

			tx2.setText("Now PM2.5 is " + x);
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}
    };
	SensorEventListener mySensorListener1 = new SensorEventListener() {

		//传感器的值改变调用此方法
		@Override
		public void onSensorChanged(SensorEvent event) {
			float x = event.values[0];
			System.out.println("Temperature is :" + x);
			final TextView tx3 = (TextView)findViewById(R.id.textView1);

			tx3.setText("Now Temperature is " + x);
		}
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}
	};
	SensorEventListener mySensorListener2 = new SensorEventListener() {

		//传感器的值改变调用此方法
		@Override
		public void onSensorChanged(SensorEvent event) {
			float x = event.values[0];
			System.out.println("PROXIMITY is :" + x);
			final TextView tx4 = (TextView)findViewById(R.id.textView2);

			tx4.setText("Now PROXIMITY is " + x);
		}
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}
	};
	SensorEventListener mySensorListener3 = new SensorEventListener() {

		//传感器的值改变调用此方法
		@Override
		public void onSensorChanged(SensorEvent event) {
			float x = event.values[0];
			System.out.println("light is :" + x);
			final TextView tx5 = (TextView)findViewById(R.id.textView3);

			tx5.setText("Now light is " + x);
		}
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}
	};
}