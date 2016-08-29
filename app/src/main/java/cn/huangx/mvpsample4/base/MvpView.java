package cn.huangx.mvpsample4.base;

/**
 * Created by huangx on 2016/8/24.
 */
public interface MvpView {
    /**
     * 显示loading对话框
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * 隐藏loading对话框
     */
    void hideLoading();

    /**
     * 显示错误信息
     *
     * @param errorMsg
     */
    void showError(String errorMsg);
}
