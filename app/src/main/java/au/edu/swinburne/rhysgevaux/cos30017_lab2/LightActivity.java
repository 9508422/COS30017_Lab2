package au.edu.swinburne.rhysgevaux.cos30017_lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class LightActivity extends AppCompatActivity {

    private boolean lightOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        initialiseUI();
    }

    private void initialiseUI() {
        initialiseBulbImageView();
    }

    private void initialiseBulbImageView() {
        ImageView bulbImageView = (ImageView) findViewById(R.id.bulbImageView);
        bulbImageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
        lightOn = false;
        bulbImageView.setOnTouchListener(bulbTouchListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_light, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private View.OnTouchListener bulbTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ImageView bulbImageView = (ImageView) findViewById(R.id.bulbImageView);

            if (!lightOn) {
                bulbImageView.setImageDrawable(getResources().getDrawable(R.drawable.on));
                lightOn = true;
                Toast.makeText(getApplicationContext(),"Light on.",Toast.LENGTH_LONG).show();
            } else {
                bulbImageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
                lightOn = false;
                Toast.makeText(getApplicationContext(),"Light off.",Toast.LENGTH_LONG).show();
            }

            return false;
        }
    };
}
