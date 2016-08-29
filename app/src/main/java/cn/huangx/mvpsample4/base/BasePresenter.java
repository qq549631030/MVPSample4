package cn.huangx.mvpsample4.base;

/**
 * Created by huangx on 2016/8/24.
 */
public class BasePresenter<V extends MvpView> implements Presenter<V> {
    /**
     * 当前连接的View
     */
    private V mvpView;

    /**
     * Presenter与View建立连接
     *
     * @param mvpView 与此Presenter相对应的View
     */
    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    /**
     * Presenter与View连接断开
     */
    @Override
    public void detachView() {
        this.mvpView = null;
    }

    /**
     * 是否与View建立连接
     *
     * @return
     */
    public boolean isViewAttached() {
        return mvpView != null;
    }

    /**
     * 获取当前连接的View
     *
     * @return
     */
    public V getMvpView() {
        return mvpView;
    }

    /**
     * 每次调用业务请求的时候都要先调用方法检查是否与View建立连接，没有则抛出异常
     */
    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("请求数据前请先调用 attachView(MvpView) 方法与View建立连接");
        }
    }
}
