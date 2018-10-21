package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment {

    ProgressBar progressBar = null;
    public String loadedJoke = null;
    Button button;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        button = root.findViewById(R.id.btn_tell_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                tellJoke();

            }
        });

        progressBar = root.findViewById(R.id.progress_bar_jokes);
        progressBar.setVisibility(View.GONE);

        return root;
    }

    public void tellJoke() {
        new EndpointAsyncTask(getContext()).execute();
    }

}