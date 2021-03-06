package com.zhidian.app.sdk.http;


import java.io.IOException;

/**
 * Created by Alan on 2015/5/19.
 */
public interface RequestCallback {

    public abstract void onResponse(String data) throws IOException;

    public abstract void onFailure(Throwable cause);
}
