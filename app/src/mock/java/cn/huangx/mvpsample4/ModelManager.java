package cn.huangx.mvpsample4;


import cn.huangx.mvpsample4.model.FakeUserModel;
import cn.huangx.mvpsample4.model.IUserModel;

/**
 * Created by huangx on 2016/8/24.
 */
public class ModelManager {
    public static IUserModel provideUserModel() {
        return new FakeUserModel();
    }
}
