package android.project.codelab_app_navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.project.codelab_app_navigation.databinding.ActivityMainBinding;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppBarConfiguration mAppBarConfiguration;
    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected Toolbar toolbar;
    private void getAllViews(){
        drawerLayout = binding.drawerLayout;
        navigationView = binding.navigationView;
        toolbar = binding.appbar.toolbar;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getAllViews();
        setSupportActionBar(toolbar);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment != null ? navHostFragment.getNavController() : null;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.fragmentGallery, R.id.fragmentHome, R.id.fragmentSlideshow)
                .setOpenableLayout(drawerLayout)
                .build();
        if(navController != null){
            NavigationUI.setupActionBarWithNavController(this,navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment != null ? navHostFragment.getNavController() : null;
        return NavigationUI.navigateUp(Objects.requireNonNull(navController),mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}