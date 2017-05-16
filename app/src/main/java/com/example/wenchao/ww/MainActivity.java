package com.example.wenchao.ww;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File f = new File("/dev/ttyS4");

        if(f!=null && f.exists()){
            Toast.makeText(this, "ttys4存在", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "ttys4不存在！", Toast.LENGTH_LONG).show();
        }
//        if (!f.canRead() || !f.canWrite()) {
//            try {
//				/* Missing read/write permission, trying to chmod the file */
//                Process su;
//                su = Runtime.getRuntime().exec("/system/bin/su");
//                String cmd = "chmod 666 " + f.getAbsolutePath() + "\n"
//                        + "exit\n";
//                su.getOutputStream().write(cmd.getBytes());
//                if ((su.waitFor() != 0) || !f.canRead()
//                        || !f.canWrite()) {
//                    Toast.makeText(this, "c错误！---", Toast.LENGTH_LONG).show();
//                    throw new SecurityException();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                Toast.makeText(this, "c错误！---"+e.getMessage(), Toast.LENGTH_LONG).show();
//                throw new SecurityException();
//            }
//        }
//
        try{
            SerialPort port = new SerialPort(f,9600,0);
            if (port!=null){
                Toast.makeText(this, "打开串口成功！", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "打开串口错误！", Toast.LENGTH_LONG).show();
        }

    }
}
