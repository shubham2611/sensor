package seth.sensor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mPressure,mtemp,mhum, mlumin  ;
    private Sensor accelerometer;
    private TextView X, Y, Z, U , A ,B, C ;
    private Button btnStart, btnStop ;
    private float a = 0;
    private float b = 0;
    private float c = 0;
    private float x = 0;
    private float y = 0;
    private float z = 0;
    private float u = 0;



    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mtemp = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mhum = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        mlumin = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mtemp, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mhum, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mlumin, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        X = (TextView) findViewById(R.id.textx);
        Y = (TextView) findViewById(R.id.texty);
        Z = (TextView) findViewById(R.id.textz);
        U = (TextView) findViewById(R.id.textu);
        A = (TextView) findViewById(R.id.texta);
        B = (TextView) findViewById(R.id.textb);
        C = (TextView) findViewById(R.id.textc);


    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1] ;
        z = event.values[2] ;
        u = event.values[3] ;
        a = event.values[4] ;
        b = event.values[5] ;
        c = event.values[6] ;
        X.setText("pres: " + x);
        Y.setText("temp: " + y);
        Z.setText("hum: " + z);
        U.setText("lum: " + u);
        A.setText("a: " + a);
        B.setText("b: " + b);
        C.setText("c: " + c);


        // Do something with this sensor data.
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();



    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}

