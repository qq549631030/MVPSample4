package cn.huangx.mvpsample4.view;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.huangx.mvpsample4.R;
import cn.huangx.mvpsample4.usecase.UseCaseManager;
import cn.huangx.mvpsample4.base.BaseActivity;
import cn.huangx.mvpsample4.presenter.LoginPresenter;
import cn.huangx.mvpsample4.presenter.PresenterFactory;
import cn.huangx.mvpsample4.presenter.PresenterLoader;

public class LoginActivity extends BaseActivity<LoginPresenter, ILoginView> implements ILoginView, View.OnClickListener {
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(this);
    }


    @Override
    public Loader<LoginPresenter> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader(this, new PresenterFactory<LoginPresenter>() {
            @Override
            public LoginPresenter create() {
                return new LoginPresenter(UseCaseManager.provideLoginCase());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                presenter.login();
                break;
        }
    }

    /**
     * 从UI中获取用户输入的用户名
     *
     * @return
     */
    @Override
    public String getUsername() {
        return username.getText().toString().trim();
    }

    /**
     * 从UI中获取用户输入的密码
     *
     * @return
     */
    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    /**
     * 显示结果
     *
     * @param result
     */
    @Override
    public void showResult(String result) {
        Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}
