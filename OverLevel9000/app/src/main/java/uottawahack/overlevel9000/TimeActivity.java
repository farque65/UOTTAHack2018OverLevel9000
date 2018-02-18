package uottawahack.overlevel9000;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import junit.framework.TestCase;

/**
 * Created by Ben on 2018-02-18.
 */

public class TimeActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
/*
        TextView timeMessage = (TextView) findViewById(R.id.timeMessage);
        timeMessage.setText(getIntent().getExtras().getString("value"));*/
    }

}
