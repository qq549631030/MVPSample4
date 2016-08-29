package cn.huangx.mvpsample4.presenter;


import cn.huangx.mvpsample4.base.Presenter;

/**
 * Created by huangxiang on 16/8/19.
 */
public interface PresenterFactory<T extends Presenter> {
    T create();
}
