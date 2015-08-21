package au.edu.swinburne.rhysgevaux.cos30017_lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LightActivity extends AppCompatActivity {

    private boolean lightOn;
    private final View.OnTouchListener bulbTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            setLightBulb();

            return false;
        }
    };
    private final View.OnLongClickListener bulbLongTouchListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            setLightBulb();

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        initUI(savedInstanceState);
    }

    private void initUI(Bundle savedInstanceState) {
        setLightBulb();

        ImageView bulbImageView = (ImageView) findViewById(R.id.bulbImageView);
        bulbImageView.setOnLongClickListener(bulbLongTouchListener);
        //bulbImageView.setOnTouchListener(bulbTouchListener);

        restoreState(savedInstanceState);
    }

    private void restoreState(Bundle state) {
        if (state != null) {
            lightOn = state.getBoolean("lightOn");
        }
    }

    private void setLightBulb() {
        ImageView bulbImageView = (ImageView) findViewById(R.id.bulbImageView);

        String lightText;

        if (!lightOn) {
            bulbImageView.setImageDrawable(getResources().getDrawable(R.drawable.on));
            lightText = "BULB is ON";
            lightOn = true;
        } else {
            bulbImageView.setImageDrawable(getResources().getDrawable(R.drawable.off));
            lightText = "BULB is OFF";
            lightOn = false;
        }

        TextView bulbStatusTextView = (TextView) findViewById(R.id.bulbStatusTextView);
        if (bulbStatusTextView != null) {
            bulbStatusTextView.setText(lightText);
        }
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("lightOn", lightOn);
        super.onSaveInstanceState(outState);
    }
}
