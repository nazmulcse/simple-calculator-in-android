package com.example.nazmul.nazmulscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private EditText textScreen;
    public boolean isOperator = true;
    public boolean isPoint = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.result);
        textScreen = findViewById(R.id.textScreen);

        //number1 = findViewById(R.id.number1);
       // number2 = findViewById(R.id.number2);
    }

    public void showResult(View view)
    {
       try{

            // Clear screen
           if(view.getId() == R.id.btnClear){
               textScreen.setText("");
               resultView.setText("");
               isOperator = true;
           }

           // Clear single char
           if(view.getId() == R.id.btnC){

               String text = textScreen.getText().toString();
               textScreen.setText(text.substring(0, text.length() - 1));

               isPoint = true;

               // Check if last character is operator then user will not be able to enter operator
               String text1 = textScreen.getText().toString();
               String lastValue = text1.substring(text1.length()-1, text1.length());
               if(lastValue.equals("+") || lastValue.equals("-") || lastValue.equals("*") || lastValue.equals("/"))
                   this.isOperator = false;
               else
                   this.isOperator = true;

           }


            // Set numeric value
           if(view.getId() == R.id.btn1){
              textScreen.setText(textScreen.getText()+"1");
               isOperator = true;
           }
           if(view.getId() == R.id.btn2){
              textScreen.setText(textScreen.getText()+"2");
               isOperator = true;
           }
           if(view.getId() == R.id.btn3){
               textScreen.setText(textScreen.getText()+"3");
               isOperator = true;
           }
           if(view.getId() == R.id.btn4){
               textScreen.setText(textScreen.getText()+"4");
               isOperator = true;
           }
           if(view.getId() == R.id.btn5){
               textScreen.setText(textScreen.getText()+"5");
               isOperator = true;
           }
           if(view.getId() == R.id.btn6){
               textScreen.setText(textScreen.getText()+"6");
               isOperator = true;
           }
           if(view.getId() == R.id.btn7){
               textScreen.setText(textScreen.getText()+"7");
               isOperator = true;
           }
           if(view.getId() == R.id.btn8){
               textScreen.setText(textScreen.getText()+"8");
               isOperator = true;
           }
           if(view.getId() == R.id.btn9){
               textScreen.setText(textScreen.getText()+"9");
               isOperator = true;
           }
           if(view.getId() == R.id.btn0){
               textScreen.setText(textScreen.getText()+"0");
               isOperator = true;
           }

           //set Point
           if(view.getId() == R.id.btnPoint){
               if (isPoint)
                   textScreen.setText(textScreen.getText()+".");
               isPoint = false;
           }
           //set Operator
           if(view.getId() == R.id.btnAdd){
               if (isOperator)
                    textScreen.setText(textScreen.getText()+"+");
               isOperator = false;
               isPoint = true;
           }
           if(view.getId() == R.id.btnSub){
               if (isOperator)
                    textScreen.setText(textScreen.getText()+"-");
               isOperator = false;
               isPoint = true;
           }
           if(view.getId() == R.id.btnMul){
               if (isOperator)
                    textScreen.setText(textScreen.getText()+"*");
               isOperator = false;
               isPoint = true;
           }
           if(view.getId() == R.id.btnDiv){
               if (isOperator)
                textScreen.setText(textScreen.getText()+"/");
               isOperator = false;
               isPoint = true;
           }

           // Process result
           if(view.getId() == R.id.btnEqual){
               String txt = textScreen.getText().toString();
               Expression expression = new ExpressionBuilder(txt).build();
               BigDecimal result = new BigDecimal(expression.evaluate()).setScale(14,BigDecimal.ROUND_HALF_UP);
               resultView.setText("= " + result.stripTrailingZeros().toPlainString());
           }


       } catch (Exception e){
           Toast.makeText(MainActivity.this,"Please Enter Number Correctly", Toast.LENGTH_SHORT).show();
       }
    }

}
