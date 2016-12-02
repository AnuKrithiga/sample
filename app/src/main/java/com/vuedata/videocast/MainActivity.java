package com.vuedata.videocast;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.cast.framework.CastButtonFactory;

public class MainActivity extends AppCompatActivity {

    Button btn;
    VideoView videov;
    MediaController mediac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        videov = (VideoView) findViewById(R.id.videoView);
        mediac = new MediaController(this);
    }

    public void play(View v){
        String link= "http://content.jwplatform.com/manifests/vLplH6dJ.m3u8?exp=1793033206&sig=5dd3eba7fddf39e0fbd9caf003e13b3b";
        Uri uri= Uri.parse(link);
        videov.setVideoURI(uri);
        videov.setMediaController(mediac);
        mediac.setAnchorView(videov);
        videov.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        CastButtonFactory.setUpMediaRouteButton(getApplicationContext(),
                menu,
                R.id.media_route_menu_item);
        return true;
    }
}
