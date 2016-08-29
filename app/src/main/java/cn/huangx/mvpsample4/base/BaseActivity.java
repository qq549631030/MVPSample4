package cn.huangx.mvpsample4.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by huangx on 2016/8/24.
 */
public class BaseActivity<P extends Presenter<V>, V extends MvpView> extends AppCompatActivity implements MvpView, LoaderManager.LoaderCallbacks<P> {

    public final static int BASE_ACTIVITY_LOADER_ID = 100;

    protected ProgressDialog progressDialog;

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        getSupportLoaderManager().initLoader(BASE_ACTIVITY_LOADER_ID, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 显示loading对话框
     *
     * @param msg
     */
    @Override
    public void showLoading(String msg) {
        progressDialog.setMessage(msg);
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    /**
     * 隐藏loading对话框
     */
    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    /**
     * 显示错误信息
     *
     * @param errorMsg
     */
    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {
        // TODO: 子类要实现此方法创建Loader 
        return null;
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {
        presenter = null;
    }
}
