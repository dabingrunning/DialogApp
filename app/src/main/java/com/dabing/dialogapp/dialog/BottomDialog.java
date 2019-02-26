package com.dabing.dialogapp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.dabing.dialogapp.R;

/**
 *
 * Dialog 居底部显示：
 * //关键代码
 * getWindow.setGravity(Gravity.BOTTOM);
 * 充满屏幕宽度且居底部显示的代码：
 * 设置style: R.style.MyBottomDialog, 继承Theme.AppCompat.Dialog；
 *      属性 <item name="android:windowBackground">@null</item>
 *
 *<p>
 *     <style name="MyBottomDialog" parent="Theme.AppCompat.Dialog">
 *          <item name="android:windowNoTitle">true</item>
 *          <item name="android:windowBackground">@null</item>
 *          <!--<item name="android:backgroundDimEnabled">false</item>-->
 *          <!--<item name="android:windowIsTranslucent">false</item>-->
 *          <!--<item name="android:backgroundDimAmount">0.5</item>-->
 *      </style>
 *
     * <style name="MyBackgroundDialog" parent="Theme.AppCompat.Dialog">
     *     <!-- 边框 -->
     *     <item name="android:windowFrame">@null</item>
     *     <!-- 是否浮现在activity之上 -->
     *     <item name="android:windowIsFloating">true</item>
     *     <!-- 半透明 -->
     *     <item name="android:windowIsTranslucent">true</item>
     *     <!-- 无标题 -->
     *     <item name="android:windowNoTitle">true</item>
     *     <item name="android:background">@android:color/transparent</item>
     *     <!-- 背景透明 -->
     *     <item name="android:windowBackground">@android:color/transparent</item>
     *     <!-- 模糊 -->
     *     <item name="android:backgroundDimEnabled">true</item>
     *     <!-- 遮罩层 -->
     *     <item name="android:backgroundDimAmount">0.5</item>
     * </style>
 *</p>
 *
 *
 */
public class BottomDialog extends AlertDialog{
    private Context mContext;
    private View mView;
    public BottomDialog(@NonNull Context context, View view) {
//        super(context, R.style.MyBackgroundDialog);
        super(context, R.style.MyBottomDialog);
        this.mContext = context;
        this.mView = view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom, null);
        LinearLayout rootLinearLayout = rootView.findViewById(R.id.root_linear);
        if(mView != null){
            rootLinearLayout.addView(mView);
        }
        setContentView(rootView);
//        setCancelable(true);//点击外部不可dismiss
//        setCanceledOnTouchOutside(true);
        Window window = this.getWindow();
        window.setGravity(Gravity.BOTTOM);
//        window.setWindowAnimations(R.style.main_menu_animStyle);//设置弹出动画
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
    }

}
