package cn.huangx.mvpsample4.usecase;

import cn.huangx.mvpsample4.ModelManager;
import cn.huangx.mvpsample4.usecase.LoginCase;

/**
 * 功能说明：cn.huangx.mvpsample4
 * 作者：huangx on 2016/8/29 10:25
 * 邮箱：549631030@qq.com
 */
public class UseCaseManager {
    public static LoginCase provideLoginCase() {
        return new LoginCase(ModelManager.provideUserModel());
    }
}
