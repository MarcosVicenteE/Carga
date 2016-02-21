package tabbar.example.com.probacarga;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    CircularFillableLoaders circularFillableLoaders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
        Temporizador time = new Temporizador();
        time.execute();
    }
    /**
     * Created by Marcos Vicente on 29/11/2015.
     */
    public class Temporizador extends AsyncTask<Void, Integer, Boolean> {
        private final int TEMPO_FINAL = 60;


        @Override
        protected Boolean doInBackground(Void... params) {
            for (int i = 1; i <= TEMPO_FINAL; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                publishProgress(i);

                if (isCancelled())
                    break;
            }
            return true;
        }

        int progreso = 100;
        @Override
        protected void onProgressUpdate(Integer... values) {
            circularFillableLoaders.setProgress(--progreso);
        }

        @Override
        protected void onPostExecute(Boolean result) {


        }
    }
    // the end of temporizador
}
