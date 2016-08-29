package cn.huangx.mvpsample4.base;

/**
 * Created by huangx on 2016/8/24.
 */
public interface Presenter<V extends MvpView> {
    /**
     * Presenter与View建立连接
     *
     * @param mvpView 与此Presenter相对应的View
     */
    void attachView(V mvpView);

    /**
     * Presenter与View连接断开
     */
    void detachView();
}
