package kr.hs.emirim.dodo1305.userdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textName, textEmail;
    EditText editName, editEmail;
    TextView text_toast;
    View digv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button)findViewById(R.id.but);
        but.setOnClickListener(this);
        textName = (TextView)findViewById(R.id.text_name);
        textEmail=(TextView)findViewById(R.id.text_email);
    }

    @Override
    public void onClick(View view) {
        final View digV = View.inflate(getApplicationContext(),R.layout.dialog,null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Input User Information");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setView(digV);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                editName = (EditText)digV.findViewById(R.id.edit_name);
                editEmail = (EditText)digV.findViewById(R.id.edit_email);
                textName.setText(editName.getText());
                textEmail.setText(editEmail.getText());

            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast toast = new Toast(MainActivity.this);
                View toastV = View.inflate(MainActivity.this, R.layout.toast,null);
                TextView text_toast = (TextView)toastV.findViewById(R.id.text_toast);
                text_toast.setText("취소됨");
                toast.setView(toastV);
                toast.show();
            }
        });
        dialog.show();

    }
}
