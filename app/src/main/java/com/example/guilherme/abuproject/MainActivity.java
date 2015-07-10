package com.example.guilherme.abuproject;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;

import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

////
public class MainActivity extends FragmentActivity
        implements AdapterViewCompat.OnItemClickListener,
       SlidingPaneLayout.PanelSlideListener, AdapterView.OnItemClickListener {
    private Toast toast;
    private long lastBackPressTime = 0;
    private SlidingPaneLayout mSlidingLayout;
    private ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Colocando a Activity em tela cheia (opcional)
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


        mSlidingLayout = (SlidingPaneLayout)
                findViewById(R.id.sliding_pane_layout);
        mSlidingLayout.setPanelSlideListener(this);

        String[] opcoes = new String[] {
                "Home", "Onde?", "Quem Somos?",
                "Redes Sociais"};

        mList = (ListView) findViewById(R.id.left_pane);
        mList.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                opcoes));
        mList.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }

    // Evento de clique do botão
    public void abrirMenu(View v){
        // Se estive aberto, feche. Senão abra.
        if (mSlidingLayout.isOpen()){
            mSlidingLayout.closePane();
        } else {
            mSlidingLayout.openPane();
        }
    }


    @Override
    public void onItemClick(AdapterViewCompat<?> adapterViewCompat, View view, int i, long l) {

    }

    @Override
    public void onPanelSlide(View view, float v) {

    }

    @Override
    public void onPanelOpened(View view) {

    }

    @Override
    public void onPanelClosed(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView,
                            View view, int position, long id) {

        String opcao = (String)
                mList.getAdapter().getItem(position);

        switch (opcao) {

            case "Home"://HOME
                Intent intent0 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent0);
                finish();
                break;
            case "Onde?"://ONDE
                Intent intent1 = new Intent(MainActivity.this, Onde.class);
                startActivity(intent1);
                finish();
                break;
            case "Quem Somos?"://QUEM SOMOS
                Intent intent2 = new Intent(MainActivity.this, QuemSomos.class);

                startActivity(intent2);
                finish();
                break;
            case "Redes Sociais"://REDES SOCIAIS
                Intent intent3 = new Intent(MainActivity.this, RedesSociais.class);

                startActivity(intent3);
                finish();
                break;
        }

    }
    @Override
    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            toast = Toast.makeText(this, "Pressione voltar novamente para fechar o App :D.", Toast.LENGTH_LONG);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            super.onBackPressed();
        }
    }
}
