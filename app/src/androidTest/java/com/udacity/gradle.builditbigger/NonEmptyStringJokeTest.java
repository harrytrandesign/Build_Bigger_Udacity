package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.free.EndpointAsyncTask;

/**
 * Created by HTDWPS on 10/18/18.
 */
public class NonEmptyStringJokeTest extends AndroidTestCase {

    private static final String LOG_TAG = NonEmptyStringJokeTest.class.getSimpleName();

    @SuppressWarnings("unchecked")
    public void test() {

        // Test AsyncTask successfully retrieves a string
        String result = null;
        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(getContext());
        endpointAsyncTask.execute();

        try {
            result = endpointAsyncTask.get();

        } catch (Exception e) {
            e.printStackTrace();

        }
        assertNotNull(result);
    }

}
