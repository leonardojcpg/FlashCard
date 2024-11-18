package App.FlashCardStudy.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Base.FlashCardStudyClick;
import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.StandardAlert;
import App.FlashCardStudy.Utils.Support;

public class FrmMain extends FlashCardStudyActivity implements View.OnClickListener, MenuItemCompat.OnActionExpandListener, BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener
{
    //Variaveis da classe
    private FlashCardStudyClick flashCardClick = null;

    //Controles da classe
    private AppBarLayout appBarLayout = null;
    private Toolbar toolbar = null;
    private CoordinatorLayout coordinatorArea = null;
    private LinearLayout lnlMain = null;
    private BottomNavigationView bnvNavigationMain = null;

    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Carrega o formulario
        setContentView(R.layout.frm_main);

        //O super vem depois, pois como estamos implementando de uma classe base da pekus, se não ficar na sequencia não carrega os controles
        super.onCreate(bundleSavedInstanceState);
    }

    @Override
    public void startControls()
    {
        //Inicia controles da tela
        appBarLayout = findViewById(R.id.appBarLayout);
        toolbar = findViewById(R.id.toolbar);
        coordinatorArea = findViewById(R.id.coordinatorArea);
        lnlMain = findViewById(R.id.lnlMain);
        bnvNavigationMain = findViewById(R.id.bnvNavigationMain);

        //Definimos o clique padrao
        flashCardClick = new FlashCardStudyClick(this);

        //Definimos o listener no botao de navegacao inferior
        bnvNavigationMain.setOnClickListener(flashCardClick);
    }

    @Override
    public void onClick(View view)
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
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int iIdMenu = 0;
        try
        {
            //Habilita o clique nos itens da bottom navigation
            enableBottomNavClick(false);

            //Pega o id do item do menu clicado
            iIdMenu = menuItem.getItemId();

            //Se o clique for no inicio
            if (iIdMenu == R.id.item_home)
            {
                //Volta pra tela de inicio
                goToMainScreen();
            }
            //Se o clique for do historico de jogos
            else if (iIdMenu == R.id.item_historico)
            {
                //Chama a tela de historico de jogos
                goToHistory();
            }
            //Se o clique for no item de perfil
            else if (iIdMenu == R.id.item_profile)
            {
                //Chama a tela de perfil de usuario
                goToProfileScreen();
            }
//            //Se o clique for no item de imagens
//            else if (iIdMenu == R.id.item_images)
//            {
//                //Chama a tela de adicionar imagens
//                goToCardScreen();
//            }

        }
        catch (Exception err)
        {
            new StandardAlert(this, null).standardDialog(Support.getMsgErr(this, err), getString(R.string.atention));
        }
        return false;
    }

    /**
     * Método responsável por controlar a habilitação do clique nos itens da bottom navigation
     */
    private void enableBottomNavClick(boolean bEnableClick)
    {
        //Percorre os itens da bottom navigation e habilita/desabilita de acordo com o parâmetro passado
        for (int iPosicao = 0; iPosicao < bnvNavigationMain.getMenu().size(); iPosicao++)
        {
            bnvNavigationMain.getMenu().getItem(iPosicao).setEnabled(bEnableClick);
        }
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

    /**
     * Metodo que chama a tela home
     */
    private void goToMainScreen()
    {
        Intent intent = null;

        //Chama a tela principal
        intent = new Intent(this, FrmMain.class);
        startActivity(intent);
    }

    /**
     * Metodo que chama a tela de historico de jogos
     */
    private void goToHistory()
    {
        Intent intent = null;

        //Chama a tela principal
        intent = new Intent(this, FrmHistory.class);
        startActivity(intent);
    }

    /**
     * Metodo que chama a tela de perfil
     */
    private void goToProfileScreen()
    {
        Intent intent = null;

        //Chama a tela principal
        intent = new Intent(this, FrmProfile.class);
        startActivity(intent);
    }

    /**
     * Método que chama a tela de imagem
     */
    private void goToCardScreen()
    {
        Intent intent = null;

        //Chama a tela de imagem
        intent = new Intent(this, FrmCard.class);
        startActivity(intent);
    }
}
