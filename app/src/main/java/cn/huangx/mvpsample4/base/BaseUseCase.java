package cn.huangx.mvpsample4.base;

/**
 * 功能说明：cn.huangx.mvpsample4.base
 * 作者：huangx on 2016/8/29 10:01
 * 邮箱：huangx@pycredit.cn
 */
public abstract class BaseUseCase<Q extends BaseUseCase.RequestValues, P extends BaseUseCase.ResponseValue> {

    private Q mRequestValues;

    private UseCaseCallback<P> mUseCaseCallback;

    public void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    public Q getRequestValues() {
        return mRequestValues;
    }

    public UseCaseCallback<P> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<P> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    public void run() {
        executeUseCase(mRequestValues);
    }

    /**
     * 执行该用例
     *
     * @param requestValues 用例输入
     */
    public abstract void executeUseCase(Q requestValues);

    /**
     * 用例的输入(请求参数)
     */
    public interface RequestValues {
    }

    /**
     * 用例的输出(返回结果)
     */
    public interface ResponseValue {
    }

    /**
     * 用例回调
     *
     * @param <R>
     */
    public interface UseCaseCallback<R> {
        void onSuccess(R response);

        void onError(String errorCode, Object... errorMsg);
    }
}
