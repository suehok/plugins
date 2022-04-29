// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.util.Log;

public class ObservableWebView extends WebView {
  private OnScrollChangedCallback mOnScrollChangedCallback;

  public ObservableWebView(final Context context)
  {
    super(context);
  }

  public ObservableWebView(final Context context, final AttributeSet attrs)
  {
    super(context, attrs);
  }

  public ObservableWebView(final Context context, final AttributeSet attrs, final int defStyle)
  {
    super(context, attrs, defStyle);
  }

  @Override
  protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt)
  {
    Log.d("ObservableWebView", "onScrollChanged " + t);
    super.onScrollChanged(l, t, oldl, oldt);
    if(mOnScrollChangedCallback != null) mOnScrollChangedCallback.onScroll(l, t, oldl, oldt);
  }

  public OnScrollChangedCallback getOnScrollChangedCallback()
  {
    return mOnScrollChangedCallback;
  }

  public void setOnScrollChangedCallback(final OnScrollChangedCallback onScrollChangedCallback)
  {
    mOnScrollChangedCallback = onScrollChangedCallback;
  }

  /**
   * Impliment in the activity/fragment/view that you want to listen to the webview
   */
  public static interface OnScrollChangedCallback
  {
    public void onScroll(int l, int t, int oldl, int oldt);
  }
}
