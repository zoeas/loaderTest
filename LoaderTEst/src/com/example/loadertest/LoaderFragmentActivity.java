package com.example.loadertest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class LoaderFragmentActivity extends FragmentActivity{

	private SubFragment subFragment;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_sub);
		subFragment = new SubFragment();
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.container, subFragment ,"tag");
		ft.commit();
	}
	
	public void re(View view){
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		if(subFragment.isDetached())
			ft.attach(subFragment);
		else
			ft.detach(subFragment);
		ft.commit();
//		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//		if(subFragment.isHidden())
//			ft.show(subFragment);
//		else
//			ft.hide(subFragment);
//		ft.commit();
	}
	

}
