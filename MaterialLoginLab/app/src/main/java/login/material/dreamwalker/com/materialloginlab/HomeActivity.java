package login.material.dreamwalker.com.materialloginlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import ru.semper_viventem.backdrop.BackdropBehavior;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    BackdropBehavior backdropBehavior;
    FrameLayout foregroundContainer ;
    CoordinatorLayout coordinatorLayout;
    CoordinatorLayout.LayoutParams layoutParams;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.backDrop);
        foregroundContainer = (FrameLayout) findViewById(R.id.foregroundContainer);
        layoutParams = (CoordinatorLayout.LayoutParams) foregroundContainer.getLayoutParams();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);

        backdropBehavior = (BackdropBehavior) layoutParams.getBehavior();

        backdropBehavior.attachBackContainer(R.id.backContainer);
        backdropBehavior.attachToolbar(R.id.toolbar);
        toolbar.setTitle("Test Backdrop");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                checkMenuPosition(menuItem.getItemId());
                checkMenuPosition(menuItem.getItemId());
                backdropBehavior.close(true);
                return true;
            }
        });
    }

    private void checkMenuPosition(int menuid){
        switch (menuid){

            case R.id.menuGallery:
                Log.e(TAG, "checkMenuPosition: menuGallery");
//                showPage();
                break;
            case R.id.menuText:
                Log.e(TAG, "checkMenuPosition: menuText");
                break;
            case R.id.menuList:
                Log.e(TAG, "checkMenuPosition: menuText");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (!backdropBehavior.close(true)) {
            finish();
        }
        super.onBackPressed();
    }

    private void showPage(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(foregroundContainer.getId(), fragment)
                .commit();
    }
}
