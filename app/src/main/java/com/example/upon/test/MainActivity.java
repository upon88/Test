package com.example.upon.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.upon.test.bean.User;

import java.util.List;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*

    public void add(View view) {
        User p2 = new User();
        p2.setName("upon");
        p2.setAddress("dongyuan C");
        p2.setPhonenum("1524528544");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "添加数据成功，返回objectId为：" + objectId, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void query(View view) {
        BmobQuery<User> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("name", "upon");
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> users, BmobException e) {
                if (e == null) {
                    if (users.size() == 0) {
                        Toast.makeText(MainActivity.this, "账户不存在！", Toast.LENGTH_LONG).show();
                        return;
                    }

                    for (User a : users) {
                        if (a.getAddress().equals("dongyuan C")) {
                            Toast.makeText(MainActivity.this, "查询数据成功" + a.getAddress(), Toast.LENGTH_LONG).show();
                            return;
                        } else {
                            */
/*Intent intent =new Intent();
                            intent.setClass(LoginActivity.this,MainActivity.class);
                            intent.putExtra("account",account);
                            intent.putExtra("realName",a.getRealName());
                            startActivity(intent);intent*//*

                        }
                    }

                } else {
                    Toast.makeText(MainActivity.this, "查询数据失败" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void update(View view) {
        User p1 = new User();
        p1.setAddress("北京朝阳");
        p1.update("b79ab60187", new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "更新成功:", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(MainActivity.this, "更新失败：" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public void delete(View view) {
        User p2 = new User();
        p2.setObjectId("b79ab60187");
        p2.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "删除成功:", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "删除失败：" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }
*/


}
