package cn.huangx.mvpsample4.model;

/**
 * Created by huangx on 2016/8/24.
 */
public interface IUserModel {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param callback 回调
     */
    void login(String username, String password, Callback callback);
}
