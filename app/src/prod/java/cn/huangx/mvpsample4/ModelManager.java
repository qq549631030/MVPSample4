package cn.huangx.mvpsample4;

import cn.huangx.mvpsample4.model.IUserModel;
import cn.huangx.mvpsample4.model.UserModel;

/**
 * Created by huangx on 2016/8/24.
 */
public class ModelManager {
    public static IUserModel provideUserModel() {
        return new UserModel();
    }
}
