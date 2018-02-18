package uottawahack.overlevel9000;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


/**
 * Created by Ben on 2018-02-17.
 */

public class InstanceIdService extends FirebaseInstanceIdService {

private static final String TAG = "MyFirebaseInsIdService";


    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);


    }
}
