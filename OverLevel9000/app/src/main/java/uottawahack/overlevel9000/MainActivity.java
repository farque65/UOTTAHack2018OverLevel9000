package uottawahack.overlevel9000;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String LOCATION_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Hospital";
    private static final String FIREBASE_DATABASE_URL = "https://overlevel9000-3f4a5.firebaseio.com/";

    private Write write;
    private Read read;
    private String uuid;
    private TextView mTextMessage;


    public static void sendNotificationToUser(String user, String firstName, String lastName, String email) {
        Firebase ref = new Firebase(FIREBASE_DATABASE_URL);
        final Firebase notifications = ref.child("firebaseId");

        Map notification = new HashMap<>();
        notification.put("token", user);
        notification.put("firstName", firstName);
        notification.put("lastName", lastName);
        notification.put("email", email);

        notifications.push().setValue(notification);
    }
private EditText firstName, lastName, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // read = new Read(LOCATION_DIR);
/*
        File dir = new File(LOCATION_DIR);
        dir.mkdir();

        File file = new File(LOCATION_DIR + "uuid.txt");
        final File fileTime = new File(LOCATION_DIR + "time.txt");

        String[] saveText = {""};

        Save(fileTime, saveText);
        Save(file, saveText);.

        String[] loadText = Load(file);

        if (loadText[0].equals("")) {
            uuid = String.valueOf(UUID.randomUUID());
            String[] text = {uuid};
            Save(file, text);
        } else {
            uuid = loadText[0];
        }
*/


        uuid = String.valueOf(UUID.randomUUID());

        Firebase.setAndroidContext(this);
        firstName = (EditText) findViewById(R.id.edit_text_first_name);
        lastName = (EditText) findViewById(R.id.edit_text_last_name);
        email = (EditText) findViewById(R.id.edit_text_email);
        Button submit_click = (Button) findViewById(R.id.submit_text);
        FirebaseMessaging.getInstance().subscribeToTopic(uuid);

        mTextMessage = (TextView) findViewById(R.id.message);
/*
        FileObserver fileObserver = new FileObserver(fileTime.getPath()) {
            @Override
            public void onEvent(int i, @Nullable String s) {
                mTextMessage.setText(Load(fileTime)[0]);
            }
        };*/

        submit_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotificationToUser(uuid, String.valueOf(firstName.getText()), String.valueOf(lastName.getText()), String.valueOf(email.getText()));
//                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.content), "Sending pairing key ...", 5000);
 //               mySnackbar.show();

            }
        });

    }



/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu); //your file name
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                sendNotificationToUser(uuid, firstName, lastName, email);
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.content), "Sending pairing key ...", 5000);
                mySnackbar.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
*/
}
