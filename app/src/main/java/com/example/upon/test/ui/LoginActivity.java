package com.example.upon.test.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.upon.test.R;
import com.example.upon.test.Util.Util;
import com.example.upon.test.bean.User;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.update.BmobUpdateAgent;


/**
 * 作者：Created by UPON
 * 邮箱：upon_88@163.com
 * 时间： 2016/10/12
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    @SuppressWarnings("unused")
    private static final String TAG = "LoginActicity";

    private Button btnLogin;
    private Button btnReg;
    private Button btnResetPsd;
    private EditText etUsername;
    private EditText etPassword;

    private String username;
    private String password;

//    @SuppressWarnings("unused")
//    private static final String APP_ID = "101080318";
    @SuppressWarnings("unused")
    private TextView backInfo;
    @SuppressWarnings("unused")
    //private UserInfo mInfo;


    private TextView mUserInfo;
    private ImageView mUserLogo;
    private ImageView mNewLoginButton;



  /*  Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mUserInfo.setVisibility(android.view.View.VISIBLE);
                mUserInfo.setText(msg.getData().getString("nickname"));
            } else if (msg.what == 1) {
                Bitmap bitmap = (Bitmap) msg.obj;
                mUserLogo.setImageBitmap(bitmap);
                mUserLogo.setVisibility(android.view.View.VISIBLE);
            }
        }
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bmob自动更新组件
        BmobUpdateAgent.setUpdateOnlyWifi(true);
        BmobUpdateAgent.update(this);

        //QQ登陆, 获取实例
//		mQQAuth = QQAuth.createInstance(APP_ID, this.getApplicationContext());
//		mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReg = (Button) findViewById(R.id.btn_register);
        btnResetPsd = (Button) findViewById(R.id.btn_reset_psd);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin.setOnClickListener(this);
        btnReg.setOnClickListener(this);
        btnResetPsd.setOnClickListener(this);
/*
*
*                           新发现
*
* */
        mUserInfo = (TextView) findViewById(R.id.user_nickname);
        mUserLogo = (ImageView) findViewById(R.id.user_logo);
        mNewLoginButton = (ImageView) findViewById(R.id.new_login_btn);
        mNewLoginButton.setOnClickListener(this);
        backInfo = (TextView) findViewById(R.id.user_callback);

        getUserInfo();

    }


    private void getUserInfo() {
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        etUsername.setText(sp.getString("username", null));
        etPassword.setText(sp.getString("password", null));
    }

    //保存用户的登陆记录
    private void saveUserInfo(String username, String password) {
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 登陆
            case R.id.btn_login:
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if( !Util.isNetworkConnected(this) ){
                    toast("亲, 木有网络 ( ⊙ o ⊙ ) ");
                } else if (username.equals("") || password.equals("")) {
                    toast("亲, 请输入小菜账号和密码");
                    break;
                } else {
                    User bu2 = new User();
                    bu2.setUsername(username);
                    bu2.setPassword(password);
                    bu2.login(new SaveListener() {
                        @Override
                        public void done(Object o, BmobException e) {
                            if(e==null){
                                toast("亲, 小菜来罗~");
                                //保存用户信息
                                saveUserInfo(username, password);
                                // 跳转到主页
                                Intent toHome = new Intent(LoginActivity.this,BaseActivity.class);
                                startActivity(toHome);
                                finish();
                            }else{
                                toast("亲, 用户名或密码错误");
                            }
                        }
                    });
                }
                break;

            case R.id.btn_reset_psd:
               /* Intent toResetPsdActivity = new Intent(LoginActivity.this, ResetPsdActivity.class);
                startActivity(toResetPsdActivity);*/
                break;

            case R.id.btn_register:
                Intent toReg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(toReg);
                break;
//		case R.id.new_login_btn:
//			onClickLogin();
//			break;
            default:
                break;

        }
    }

    public void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

}
