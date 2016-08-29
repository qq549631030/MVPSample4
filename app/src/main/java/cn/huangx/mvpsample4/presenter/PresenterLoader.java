package cn.huangx.mvpsample4.presenter;

import android.content.Context;
import android.support.v4.content.Loader;

import cn.huangx.mvpsample4.base.Presenter;

/**
 * Created by huangx on 2016/8/19.
 */
public class PresenterLoader<T extends Presenter> extends Loader<T> {

    private final PresenterFactory<T> factory;

    private T presenter;

    public PresenterLoader(Context context, PresenterFactory factory) {
        super(context);
        this.factory = factory;
    }

    @Override
    protected void onStartLoading() {
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        presenter = factory.create();
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        presenter = null;
    }
}
