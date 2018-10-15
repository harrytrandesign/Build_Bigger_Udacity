package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by HTDWPS on 10/14/18.
 */
public class EndpointAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {

    private static MyApi myApi = null;
    private MainActivityFragment mainActivityFragment;
    private Context context;

    @Override
    protected String doInBackground(MainActivityFragment... mainActivityFragments) {

        mainActivityFragment = mainActivityFragments[0];
        context = mainActivityFragment.getActivity();

        if (myApi == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)

                    // 10.0.2.2 is localhost
            .setRootUrl("http://google.com");

            myApi = builder.build();

        }

        try {
            return myApi.getJoke().execute().getData();
        } catch (IOException error) {
            return error.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);

        // Create a toast for now
//        Toast.makeText(context, s, Toast.LENGTH_LONG).show();

        mainActivityFragment.loadedJoke = string;
        mainActivityFragment.launchDisplayJokeActivity();

    }
}
