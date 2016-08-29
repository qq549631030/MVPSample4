package cn.huangx.mvpsample4.model;

/**
 * Created by huangx on 2016/8/24.
 */
public interface Callback {
    /**
     * 成功
     */
    void onSuccess();

    /**
     * 失败
     *
     * @param errorMsg 失败信息
     */
    void onFailure(String errorMsg);
}
