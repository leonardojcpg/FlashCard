package App.FlashCardStudy.Screens;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Base.FlashCardStudyClick;
import App.FlashCardStudy.R;

public class FrmMain extends FlashCardStudyActivity implements View.OnClickListener, MenuItemCompat.OnActionExpandListener, BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener
{
    //Controles da classe
    private View layoutHome = null;
    private View layoutHistory = null;
    private View layoutProfile = null;
    private View layoutImages = null;
    private Toolbar toolbar = null;
    private BottomNavigationView bnvNavigationMain = null;
    private FlashCardStudyClick flashCardClick = null;

    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Carrega o formulario
        setContentView(R.layout.frm_main);

        //O super vem depois, pois como estamos implementando de uma classe base da pekus, se não ficar na sequencia não carrega os controles
        super.onCreate(bundleSavedInstanceState);
    }

    /*
    Metodo que carrega os dados da tela
     */
    public void loadData() throws Exception
    {
        // Inicializa controles
        startControls();
    }

    public void startControls() throws Exception
    {
        //Inicia os controles na tela
        toolbar = findViewById(R.id.toolbar);
        layoutHome = findViewById(R.id.frm_home);
        layoutHistory = findViewById(R.id.frm_history);
        layoutProfile = findViewById(R.id.frm_profile);
        layoutImages = findViewById(R.id.frm_images);
        bnvNavigationMain = findViewById(R.id.bnvNavigationMain);

        //Definimos o clique padrao
        flashCardClick = new FlashCardStudyClick(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_main);

        //Seta o listener e seleciona a como clique inicial a tela home
        bnvNavigationMain.setOnItemSelectedListener(this);
        bnvNavigationMain.setSelectedItemId(R.id.item_home);
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        int itemId = item.getItemId();

        if (itemId == R.id.item_home)
        {
            exibeLayout(layoutHome);
            getSupportActionBar().setTitle(R.string.item_home_icon);
            return true;
        }
        else if (itemId == R.id.item_historico)
        {
            exibeLayout(layoutHistory);
            getSupportActionBar().setTitle(R.string.item_history);
            return true;
        }
        else if (itemId == R.id.item_profile)
        {
            exibeLayout(layoutProfile);
            getSupportActionBar().setTitle(R.string.profile_icon);
            return true;
        }
        else if (itemId == R.id.item_card)
        {
            exibeLayout(layoutImages);
            getSupportActionBar().setTitle(R.string.card_icon);
            return true;
        }

        // Caso nenhum item corresponda
        return false;
    }


    private void exibeLayout(View layoutSelecionado)
    {
        // Esconde todos os layouts
        layoutHome.setVisibility(View.GONE);
        layoutHistory.setVisibility(View.GONE);
        layoutProfile.setVisibility(View.GONE);
        layoutImages.setVisibility(View.GONE);

        // Mostra o layout selecionado
        layoutSelecionado.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v)
    {
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item)
    {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item)
    {
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {
    }

    @Override
    public void onPageSelected(int position)
    {
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab)
    {
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab)
    {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab)
    {
    }
}

