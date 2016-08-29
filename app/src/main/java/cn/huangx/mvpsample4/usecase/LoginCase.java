package cn.huangx.mvpsample4.usecase;

import android.support.annotation.NonNull;

import cn.huangx.mvpsample4.base.BaseUseCase;
import cn.huangx.mvpsample4.model.Callback;
import cn.huangx.mvpsample4.model.IUserModel;

/**
 * 功能说明：登录用例
 * 作者：huangx on 2016/8/29 10:01
 * 邮箱：549631030@qq.com
 */
public class LoginCase extends BaseUseCase<LoginCase.RequestValues, LoginCase.ResponseValue> {

    private final IUserModel userModel;

    public LoginCase(IUserModel userModel) {
        this.userModel = userModel;
    }

    /**
     * 执行该用例
     *
     * @param requestValues 用例输入
     */
    @Override
    public void executeUseCase(RequestValues requestValues) {
        String username = requestValues.getUsername();
        String password = requestValues.getPassword();
        userModel.login(username, password, new Callback() {
            @Override
            public void onSuccess() {
                getUseCaseCallback().onSuccess(new ResponseValue());
            }

            @Override
            public void onFailure(String errorMsg) {
                getUseCaseCallback().onError("1001", errorMsg);
            }
        });
    }

    public static final class RequestValues implements BaseUseCase.RequestValues {
        private final String username;
        private final String password;

        public RequestValues(@NonNull String username, @NonNull String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static final class ResponseValue implements BaseUseCase.ResponseValue {
    }
}
