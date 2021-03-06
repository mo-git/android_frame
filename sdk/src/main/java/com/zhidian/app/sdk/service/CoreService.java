package com.zhidian.app.sdk.service;

import android.content.Context;
import com.zhidian.app.sdk.http.HttpClient;
import com.zhidian.app.sdk.manager.LoginManager;
import com.zhidian.app.sdk.manager.iml.LoginManagerIml;
import com.zhidian.app.sdk.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mocf on 2017/7/14.
 */
public class CoreService {
    private final static Logger logger = LoggerFactory.getLogger(CoreService.class);
    private Context mContext;
    private static CoreService instance;
    private CoreService(){};
    public static CoreService getInstance(){
        if(instance == null){
            instance = new CoreService();
        }
        return instance;
    }

    private HttpClient httpClient = HttpClient.getInstance();
    private LoginManager loginManager = LoginManagerIml.getInstance();

    public void start(Context context, String version) {
        LogUtils.configure();
        this.mContext= context;
        initComponents();
    }

    public void initHost(Context context, String version, String host, int port) {
        this.mContext = context;
        httpClient.init(this.mContext, version);
        httpClient.setHostAddress(host, port);
    }

    //初始化manager
    public void initComponents(){
        loginManager.init(mContext);
    }

    public LoginManager getLoginManager(String className){
        loginManager.setClassName(className);
        return loginManager;
    }



}
