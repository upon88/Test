package com.example.upon.test.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.upon.test.R;

/**
 * 个人中心主界面
 */
public class MineActivity extends Fragment  {


   /* private static final String TAG = "MineActivity";

    private String[] userItemNames = {"stonekity"};
    private String[] userItemContents = {""};
    private String[] orderItemNames = {"当前订单", "历史订单"};
    private String[] orderItemContents = {"*", ""};
    private String[] aboutItemNames = {"通知中心", "软件相关", "推荐给朋友", "退出账号"};
    private String[] aboutItemContents = {"", "", "", ""};

    private int[] userImgIds = {R.drawable.ic_menu_myplaces};
    private int[] orderImgIds = {R.drawable.ic_menu_find_holo_light, R.drawable.ic_menu_copy_holo_light};
    private int[] aboutImgIds = {R.drawable.ic_menu_notifications, R.drawable.ic_menu_info_details, R.drawable.ic_menu_share, R.drawable.ic_star_yes};
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine, null);
        return view;
    }


}
