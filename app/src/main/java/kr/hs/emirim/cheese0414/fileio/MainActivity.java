package kr.hs.emirim.cheese0414.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button butOut, butIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut=(Button)findViewById(R.id.but_output);
        butIn=(Button)findViewById(R.id.but_input);
        butOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out=openFileOutput("1017myoung.txt", Context.MODE_WORLD_WRITEABLE);
                    String massage="미림여자정보과학고 학생들이 제일 예쁘다~~!";
                    out.write(massage.getBytes());
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        butIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in=openFileInput("1017ok.txt");
                    byte[] readMassage=new byte[200];
                    in.read(readMassage);
                    Toast.makeText(getApplicationContext(), new String(readMassage), Toast.LENGTH_LONG).show();
                    in.close();
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "파일이 존재하지 않습니다~!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
