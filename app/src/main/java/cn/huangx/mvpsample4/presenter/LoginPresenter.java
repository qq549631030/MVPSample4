package cn.huangx.mvpsample4.presenter;


import cn.huangx.mvpsample4.base.BasePresenter;
import cn.huangx.mvpsample4.base.BaseUseCase;
import cn.huangx.mvpsample4.usecase.LoginCase;
import cn.huangx.mvpsample4.view.ILoginView;

/**
 * Created by huangx on 2016/8/24.
 */
public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {

    private final LoginCase loginCase;

    public LoginPresenter(LoginCase loginCase) {
        this.loginCase = loginCase;
    }


    /**
     * 登录
     */
    @Override
    public void login() {
        checkViewAttached();
        getMvpView().showLoading("登录中...");
        LoginCase.RequestValues requestValues = new LoginCase.RequestValues(getMvpView().getUsername(), getMvpView().getPassword());
        loginCase.setRequestValues(requestValues);
        loginCase.setUseCaseCallback(new BaseUseCase.UseCaseCallback<LoginCase.ResponseValue>() {
            @Override
            public void onSuccess(LoginCase.ResponseValue response) {
                if (isViewAttached()) {
                    getMvpView().hideLoading();
                    getMvpView().showResult("登录成功");
                }
            }

            @Override
            public void onError(String errorCode, Object... errorMsg) {
                if (isViewAttached()) {
                    getMvpView().hideLoading();
                    getMvpView().showError(errorMsg.toString());
                }
            }
        });
        loginCase.run();
    }
}
