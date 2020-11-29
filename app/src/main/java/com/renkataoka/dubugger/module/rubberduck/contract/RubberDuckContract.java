package com.renkataoka.dubugger.module.rubberduck.contract;

import com.renkataoka.dubugger.entity.ChatItems;

import java.util.List;

/**
 * ラバーダックデバッグ画面のContractクラス。
 */
public class RubberDuckContract {
    private RubberDuckContract() {
    }

    public interface View extends com.renkataoka.viper.View {
        void initRecyclerView();
        void setChatItems(List<ChatItems> chatItems);
    }

    public interface Interactor extends com.renkataoka.viper.Interactor {
    }

    public interface InteractorCallback extends com.renkataoka.viper.InteractorCallback {
    }

    public interface Presenter extends com.renkataoka.viper.Presenter {
    }

    public interface Router extends com.renkataoka.viper.Router {
    }
}
