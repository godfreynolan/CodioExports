package todolist.riis.riistodolist;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import todolist.riis.riistodolist.R;
    
public class Splash extends Activity {
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.splash);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openStartingPoint = new Intent("todolist.riis.riistodolist.TodoActivity");
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }
}