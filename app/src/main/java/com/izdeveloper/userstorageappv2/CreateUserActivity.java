package com.izdeveloper.userstorageappv2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.view.View;

public class CreateUserActivity extends AppCompatActivity {

    private EditText name, sname, email;
    private RadioGroup rgProgramChoise, rgAvatar;
    private CheckBox chbKand, chbDI, chbTek, chbUim;
    boolean Kand, DI, Tek, Uim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        name = findViewById(R.id.txtName);
        sname = findViewById(R.id.txtSurname);
        email = findViewById(R.id.txtDefaultEmail);
        rgProgramChoise = findViewById(R.id.rgProgramChoise);
        rgAvatar = findViewById(R.id.rgAvatars);
        chbKand = findViewById(R.id.chbKand);
        chbDI = findViewById(R.id.chbDI);
        chbTek = findViewById(R.id.chbTek);
        chbUim = findViewById(R.id.chbUim);
    }

    public void addUsertoList(View view) {
        String Name, Surname, Email;
        String Degree = "";
        int Avatar = 0;

        Name = name.getText().toString();
        Surname = sname.getText().toString();
        Email = email.getText().toString();

        switch (rgProgramChoise.getCheckedRadioButtonId()) {

            case R.id.radioButton:
                Degree = "Tietotekniikka";
                break;

            case R.id.radioButton2:
                Degree = "Tuotantotalous";
                break;

            case R.id.radioButton3:
                Degree = "Laskennallinen tekniikka";
                break;

            case R.id.radioButton4:
                Degree = "Sähkötekniikka";
                break;
        }

        switch (rgAvatar.getCheckedRadioButtonId()) {

            case R.id.radioButton5:
                Avatar = 1;
                break;

            case R.id.radioButton6:
                Avatar = 2;
                break;

            case R.id.radioButton7:
                Avatar = 3;
                break;

            case R.id.radioButton8:
                Avatar = 4;
                break;
        }


        Kand = chbKand.isChecked();
        DI = chbDI.isChecked();
        Tek = chbTek.isChecked();
        Uim = chbUim.isChecked();


        User newUser = new User(Name, Surname, Email, Degree, Avatar, Kand, DI, Tek, Uim);
        UserStorage.getSingle().addUser(newUser);
        UserStorage.getSingle().listSave(getApplicationContext());
    }
}