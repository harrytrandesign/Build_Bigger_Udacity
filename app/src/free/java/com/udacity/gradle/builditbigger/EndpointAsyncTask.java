package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.htdwps.jokescreatorlibrary.DisplayJokes;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by HTDWPS on 10/14/18.
 */
public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi myApi = null;
    private Context mContext;
    private String jokeString;

    public EndpointAsyncTask(Context context) {
        this.mContext = context;
    }

    @Override
    protected String doInBackground(Context... params) {

        if (myApi == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)

                    // 10.0.2.2 is localhost
                    // Per suggestion from reviewer - Just in case, when testing, you can make use of the following URLs to connect the backend
            .setRootUrl("http://10.0.2.2:8080/_ah/api/");

            myApi = builder.build();

        }

        try {
            return myApi.getJoke().execute().getData();
        } catch (IOException error) {
            // Change made per review
            return null;
        }

    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);

        // Create a toast for now
//        Toast.makeText(context, s, Toast.LENGTH_LONG).show();

        jokeString = string;
        startJokeActivityIntent(jokeString);

    }

    private void startJokeActivityIntent(String joke) {
        Intent intent = new Intent(mContext, DisplayJokes.class);
        intent.putExtra(mContext.getString(R.string.jokes_private_key), joke);
        mContext.startActivity(intent);
    }

}
