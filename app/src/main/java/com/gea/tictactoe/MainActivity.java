package com.gea.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String _x = "X";
    String _o = "O";
    boolean xplayer = true;
    int counter = 0;
    String win = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                play(btn1);
                break;
            case R.id.btn2:
                play(btn2);
                break;
            case R.id.btn3:
                play(btn3);
                break;
            case R.id.btn4:
                play(btn4);
                break;
            case R.id.btn5:
                play(btn5);
                break;
            case R.id.btn6:
                play(btn6);
                break;
            case R.id.btn7:
                play(btn7);
                break;
            case R.id.btn8:
                play(btn8);
                break;
            case R.id.btn9:
                play(btn9);
                break;
        }
    }



    private void play(Button btn){

        if (xplayer){
            btn.setTextColor(Color.parseColor("#ff4444"));
            btn.setText(_x);
            xplayer = false;
            btn.setClickable(false);
            counter++;
            if (win == null)
                checkWinner();
            if (counter < 8){
                ai_player();
                if (win == null)
                    checkWinner();
            }


        }

    }

    private void checkWinner(){

        if (btn1.getText().equals(_x) && btn2.getText().equals(_x) && btn3.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn1.getText().equals(_o) && btn2.getText().equals(_o) && btn3.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else if(btn1.getText().equals(_x) && btn4.getText().equals(_x) && btn7.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn1.getText().equals(_o) && btn4.getText().equals(_o) && btn7.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else if(btn4.getText().equals(_x) && btn5.getText().equals(_x) && btn6.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn4.getText().equals(_o) && btn5.getText().equals(_o) && btn6.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else if(btn7.getText().equals(_x) && btn8.getText().equals(_x) && btn9.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn7.getText().equals(_o) && btn8.getText().equals(_o) && btn9.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else if(btn2.getText().equals(_x) && btn5.getText().equals(_x) && btn8.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn2.getText().equals(_o) && btn5.getText().equals(_o) && btn8.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else if(btn3.getText().equals(_x) && btn6.getText().equals(_x) && btn9.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn3.getText().equals(_o) && btn6.getText().equals(_o) && btn9.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else if(btn1.getText().equals(_x) && btn5.getText().equals(_x) && btn9.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn1.getText().equals(_o) && btn5.getText().equals(_o) && btn9.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else if(btn3.getText().equals(_x) && btn5.getText().equals(_x) && btn7.getText().equals(_x)){
            showAlertDialog("X Выигрывает");
            win = _x;
        }else if(btn3.getText().equals(_o) && btn5.getText().equals(_o) && btn7.getText().equals(_o)){
            showAlertDialog("O Выигрывает");
            win = _o;
        }else{
            if (counter == 9){
                win = "draw";
            showAlertDialog("Ничья");
            }
        }
    }

    private void showAlertDialog(String txt){

        new AlertDialog.Builder(this)
                .setTitle(txt)
                .setNeutralButton("еще раз", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        restartGame();
                    }
                })
                .setCancelable(false)
                .show();
    }
    private void restartGame(){
        xplayer = true;
        win = null;
        counter = 0;
        btn1.setClickable(true);
        btn1.setText("");
        btn2.setClickable(true);
        btn2.setText("");
        btn3.setClickable(true);
        btn3.setText("");
        btn4.setClickable(true);
        btn4.setText("");
        btn5.setClickable(true);
        btn5.setText("");
        btn6.setClickable(true);
        btn6.setText("");
        btn7.setClickable(true);
        btn7.setText("");
        btn8.setClickable(true);
        btn8.setText("");
        btn8.setText("");
        btn9.setClickable(true);
        btn9.setText("");
    }

    private void ai_player(){
        while (true){
            if (counter < 8){
                Button btn = getButton();
                if(btn.isClickable()){
                    btn.setText(_o);
                    btn.setTextColor(Color.parseColor("#4285F4"));
                    xplayer = true;
                    btn.setClickable(false);
                    break;
                }
            }else{
                break;
            }

        }
        counter++;
    }

    private Button getButton(){
            Random random = new Random();
            Button button = btn1;
            int i = random.nextInt(10-1)+1;
            System.out.println(i);
            switch (i) {
                case 0:
                    button = btn1;
                    break;
                case 1:
                    button = btn2;
                    break;
                case 2:
                    button = btn3;
                    break;
                case 3:
                    button = btn4;
                    break;
                case 4:
                    button = btn5;
                    break;
                case 5:
                    button = btn6;
                    break;
                case 6:
                    button = btn7;
                    break;
                case 7:
                    button = btn8;
                    break;
                case 8:
                    button = btn9;
                    break;
            }
            return button;
    }

//    private int minimax(){
//
//    }
}
