package com.example.loadertest;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class MyLoader extends AsyncTaskLoader<MyData> {

	private static final String TAG = "내로더";

	private MyData mData;

	public MyLoader(Context context) {
		super(context);

	}

	@Override
	public MyData loadInBackground() {
		Log.d(TAG, "로더백그라운드");
		mData = new MyData();
		return mData;
	}

	@Override
	public void deliverResult(MyData data) {
		Log.d(TAG, "로더배달");
		
		// 캐시 데이터를 최신으로 교체
		MyData oldData = mData;
		mData = data;

		if (isStarted()) {
			super.deliverResult(data);
		}
		
		// 과거 데이터는 필요없으니 해제
		if(oldData != mData){
			oldData = null;
		}
	}

	@Override
	protected void onStartLoading() {
		Log.d(TAG, "로더시작");
		// 캐시가 있으면 그걸 배달
		if (mData != null) {
			deliverResult(mData);
		}

		// 없으면 back 작동, 혹은 컨텐츠가 변동시(?) 작동
		if (takeContentChanged() || mData == null) {
			forceLoad();
		}
	}

}
