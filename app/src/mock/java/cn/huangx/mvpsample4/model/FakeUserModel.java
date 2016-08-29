package cn.huangx.mvpsample4.model;

import android.os.Handler;

/**
 * Created by huangx on 2016/8/24.
 */
public class FakeUserModel implements IUserModel {

    Handler handler = new Handler();

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param callback 回调
     */
    @Override
    public void login(final String username, final String password, final Callback callback) {
        handler.postDelayed(new Runnable() {//延时200ms回调，模拟网络请求
            @Override
            public void run() {
                if ("huangx".equals(username) && "123456".equals(password)) {
                    callback.onSuccess();
                } else {
                    callback.onFailure("用户名或密码错误(mock)");
                }
            }
        }, 2000);
    }
}
