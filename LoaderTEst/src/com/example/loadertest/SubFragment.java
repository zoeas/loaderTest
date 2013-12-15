package com.example.loadertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SubFragment extends Fragment implements LoaderCallbacks<MyData>{
	
	private static final String TAG = "프래그먼트";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG,"온크리에이트뷰");
		getLoaderManager().initLoader(0, null, this);
		return inflater.inflate(R.layout.subfragment, null);
	}

	@Override
	public Loader<MyData> onCreateLoader(int arg0, Bundle arg1) {
		Log.d(TAG,"로더생성 호출");
		
		MyLoader m = new MyLoader(getActivity());
		return m;
	}

	@Override
	public void onLoadFinished(Loader<MyData> arg0, MyData arg1) {
		Log.d(TAG,"로더피니쉬 호출");
	}

	@Override
	public void onLoaderReset(Loader<MyData> arg0) {
		Log.d(TAG,"로더리셋 호출");
	}
//	
//	@Override
//	public void onPause() {
//		Log.d(TAG,"멈춤");
//		super.onPause();
//	}
//	
//	@Override
//	public void onStop() {
//		Log.d(TAG,"스탑");
//		super.onStop();
//	}
//	
//	@Override
//	public void onDestroyView() {
//		Log.d(TAG,"뷰 파괴됨");
//		super.onDestroyView();
//	}
//	
//	@Override
//	public void onDestroy() {
//		Log.d(TAG,"파괴됨");
//		super.onDestroy();
//	}
//	
//	@Override
//	public void onDetach() {
//		Log.d(TAG,"떼짐");
//		super.onDetach();
//	}
}
