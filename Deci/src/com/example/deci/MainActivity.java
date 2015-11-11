package com.example.deci;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

	private AudioReader audioReader;
    private int sampleRate = 8000;
    private int inputBlockSize = 256;
    private int sampleDecimate = 1;
     
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        audioReader = new AudioReader();
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }
     
    public void doStart(View v)
    {
        audioReader.startReader(sampleRate, inputBlockSize * sampleDecimate, new AudioReader.Listener()
        {
            @Override
            public final void onReadComplete(int dB)
            {
                receiveDecibel(dB);
            }
             
            @Override
            public void onReadError(int error)
            {
                 
            }
        });
    }
     
    private void receiveDecibel(final int dB)
    {
        Log.e("###", dB+" dB");
    }
     
    public void doStop(View v)
    {
        audioReader.stopReader();
    }
	

 
}
