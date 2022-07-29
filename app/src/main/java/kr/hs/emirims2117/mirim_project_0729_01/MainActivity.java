package kr.hs.emirims2117.mirim_project_0729_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    RadioGroup rg;
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MULTI = 2;
    public static final int DIVIDE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        rg = findViewById(R.id.rg);
        Button btncalculation = findViewById(R.id.btn_calculation);
        btncalculation.setOnClickListener(btncalculationListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //setResult 에서 이 부분을 호출함
        //resultCode, Intent data 중요
        if(resultCode == RESULT_OK){
            int sum = data.getIntExtra("sum", 0);//data는 매개변수
            Toast.makeText(getApplicationContext(), "계산결과: "+sum, Toast.LENGTH_LONG).show();
        }
    }

    View.OnClickListener btncalculationListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
            intent.putExtra("num2",Integer.parseInt(edit2.getText().toString()));
            int op = 0;
            switch (rg.getCheckedRadioButtonId()){
                case R.id.plus:
                    op = PLUS;
                    break;
                case R.id.minus:
                    op = MINUS;
                    break;
                case R.id.multiply:
                    op = MULTI;
                    break;
                case R.id.divide:
                    op = DIVIDE;
                    break;
            }
            intent.putExtra("op", op);
            startActivityForResult(intent, 0);
        }
    };
}