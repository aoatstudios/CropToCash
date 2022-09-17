package com.example.croptocash;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends AppCompatActivity {
    @Ignore
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void jsonRespose_code() {

        String url = "https://my-json-server.typicode.com/Reyst/exhibit_db/list";
        Integer expected = 200;
        final Integer[] actual = new Integer[1];

        new Thread(new Runnable() {
            @Override
            public void run() {
                Http http = new Http(ExampleUnitTest.this, url);
                http.send();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        actual[0] = http.getStatusCode();

                        assertEquals(expected, actual[0]);
                    }
                });
            }
        }).start();
    }
}