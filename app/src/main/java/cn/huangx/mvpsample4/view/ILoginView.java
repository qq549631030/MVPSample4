package cn.huangx.mvpsample4.view;


import cn.huangx.mvpsample4.base.MvpView;

/**
 * Created by huangx on 2016/8/24.
 */
public interface ILoginView extends MvpView {
    /**
     * 从UI中获取用户输入的用户名
     *
     * @return
     */
    String getUsername();

    /**
     * 从UI中获取用户输入的密码
     *
     * @return
     */
    String getPassword();

    /**
     * 显示结果
     *
     * @param result
     */
    void showResult(String result);
}
