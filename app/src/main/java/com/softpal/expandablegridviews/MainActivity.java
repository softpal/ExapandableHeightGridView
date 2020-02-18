package com.softpal.expandablegridviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.softpal.expandableheightgridview.ExpandableHeightGridView;

public class MainActivity extends AppCompatActivity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ExpandableHeightGridView gridView =findViewById(R.id.simpleGridView);
		gridView.setExpanded(true);
		
	}
}
