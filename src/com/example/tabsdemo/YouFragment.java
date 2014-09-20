package com.example.tabsdemo;

import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class YouFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_you, container, false);
		TextView text = (TextView) rootView.findViewById(R.id.text);
		text.setText("You"+new Random().nextInt(100));
		return rootView;
	}
}
