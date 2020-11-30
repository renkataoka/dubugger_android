package com.renkataoka.dubugger.module.main.presenter;

import com.renkataoka.dubugger.module.main.contract.MainContract;
import com.renkataoka.util.MethodCallCounter;

/**
 * MainPresenterのMockクラス。
 */
public class MockMainPresenter implements MainContract.Presenter {
    private MethodCallCounter counter = new MethodCallCounter();

    @Override
    public void onCreate() {
        counter.increment("onCreate");
    }

    public int getCountOnCreate() {
        return counter.getCount("onCreate");
    }

    @Override
    public void disassembleModules() {
        counter.increment("disassembleModules");
    }

    public int getCountDisassembleModules() {
        return counter.getCount("disassembleModules");
    }

    @Override
    public void onClickAddButton(String inputItem) {
        counter.increment("onAddButtonClicked");
    }

    public int getCountOnClickAddButton() {
        return counter.getCount("onAddButtonClicked");
    }

    @Override
    public void onClickDeleteAllMenu() {
        counter.increment("onClickDeleteAllMenu");
    }

    @Override
    public void onClickToDebugItem(int position) {
        
    }

    public int getCountOnClickDeleteAllMenu() {
        return counter.getCount("onClickDeleteAllMenu");
    }
}
