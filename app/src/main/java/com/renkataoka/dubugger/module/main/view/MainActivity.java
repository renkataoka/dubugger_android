package com.renkataoka.dubugger.module.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.renkataoka.dubugger.R;
import com.renkataoka.dubugger.entity.ToDebugItems;
import com.renkataoka.dubugger.module.main.assembler.MainAssembler;
import com.renkataoka.dubugger.module.main.contract.MainContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    /**
     * Presenterクラスのオブジェクト。
     */
    private MainContract.Presenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = beginAssembleModules(this);
        initRecyclerView();
        if (presenter != null) {
            presenter.onCreate();
        }
    }

    /**
     * recyclerViewにLayoutManagerとRecyclerView.Adapterを紐づける。
     */
    @Override
    public void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewToDebugList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ToDebugListAdapter();
        recyclerView.setAdapter(adapter);
    }

    /**
     * recyclerViewのアダプターにアイテムをセットする。
     *
     * @param toDebugItems dbから取得したアイテム
     */
    @Override
    public void setToDebugItems(List<ToDebugItems> toDebugItems) {
        if (adapter instanceof ToDebugListAdapter) {
            ((ToDebugListAdapter) adapter).setToDebugItems(toDebugItems);
        }
    }

    @Override
    protected void onDestroy() {
        beginDisassembleModules();
        super.onDestroy();
    }

    @Override
    public void onDisassemble() {
        presenter = null;
    }

    @Override
    public MainContract.Presenter beginAssembleModules(Context context) {
        MainAssembler assembler = new MainAssembler();
        return assembler.assembleModules(context);
    }

    @Override
    public void beginDisassembleModules() {
        if (presenter != null) {
            presenter.disassembleModules();
        }
    }

    /**
     * Addボタンをクリックされたら、EditText内の文言をpresenterに伝える。
     *
     * @param view Addボタン
     */
    public void onAddButtonClicked(View view) {
        EditText editText = findViewById(R.id.editTextToDebugItem);
        String inputContent = editText.getText().toString();
        if (inputContent.length() != 0) {
            if (presenter != null) {
                presenter.onAddButtonClicked(inputContent);
            }
        }
    }
}
