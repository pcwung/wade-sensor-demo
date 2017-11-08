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
	
	//��������Andorid�豸�Ͽ��õĴ�����
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
		//���Ĳ���ע�ᴫ�����¼������¼�
		sensorManager.registerListener(mySensorListener, orientSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(mySensorListener1, teampSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(mySensorListener2, psSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(mySensorListener3, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);


	}

	@Override
	protected void onPause() {
		super.onPause();
    	//���岽��ע���������¼��ļ���
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
    	//��һ�������SensorManager����
    	sensorManager = (SensorManager)getSystemService(SERVICE_NAME);
    	//�ڶ���������ض��Ĵ�����
    	orientSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
		teampSensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
		psSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    	
    	if(orientSensor==null) {
    		//��֧�ִ˴�����
    	}
    	
    }
    
	//������ ����������

    SensorEventListener mySensorListener = new SensorEventListener() {

    	//��������ֵ�ı���ô˷���
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

		//��������ֵ�ı���ô˷���
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

		//��������ֵ�ı���ô˷���
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

		//��������ֵ�ı���ô˷���
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