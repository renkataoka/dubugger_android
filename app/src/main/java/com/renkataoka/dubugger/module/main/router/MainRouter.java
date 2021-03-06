package com.renkataoka.dubugger.module.main.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.renkataoka.dubugger.module.main.contract.MainContract;
import com.renkataoka.dubugger.module.rubberduck.view.RubberDuckActivity;

/**
 * メイン画面のRouterクラス。
 */
public class MainRouter implements MainContract.Router {
    private Context context;

    /**
     * コンストラクタ
     *
     * @param context
     */
    public MainRouter(Context context) {
        this.context = context;
    }

    @Override
    public void onDisassemble() {
        //Router側でContextを破棄することで、繋ぐViewとの結合を解除する。
        context = null;
    }
    
    @Override
    public void startRubberDuckActivity(int id, String title) {
        Intent intent = new Intent();
        intent.setClass(context, RubberDuckActivity.class);
        intent.putExtra(MainContract.PARENT_TABLE_ID, id);
        intent.putExtra(MainContract.PARENT_TABLE_CONTENT, title);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, MainContract.REQUEST_CODE);
        }
    }
}
