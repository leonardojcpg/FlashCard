package App.FlashCardStudy.Screens;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.R;

public class FrmMain extends FlashCardStudyActivity implements View.OnClickListener, MenuItemCompat.OnActionExpandListener, BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener
{
    //Variaveis da classe

    //Controles da classe

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
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        return false;
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
