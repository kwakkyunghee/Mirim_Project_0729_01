package kr.hs.emirims2117.mirim_project_0729_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    int sum;//필드로 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1",0);//num1이 없을때 0으로 대처
        int num2 = intent.getIntExtra("num2",0);//num2가 없을때 0으로 대처
        int op = intent.getIntExtra("op", 0);
       // sum = num1 + num2; //필드로 선언 안하고 여기서 int sum으로 선언해주면 지역변수로 OnClickListener에서 사용할수없음

        switch (op){
            case MainActivity.PLUS:
                sum = num1 + num2;
                break;
            case MainActivity.MINUS:
                sum = num1 - num2;
                break;
            case MainActivity.MULTI:
                sum = num1 * num2;
                break;
            case MainActivity.DIVIDE:
                sum = num1 / num2;
                break;
        }
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(btnBackListener);
    }
    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("sum", sum);//"sum" 과 , sum은 달라도 된다.
            setResult(RESULT_OK, intent);//결과코드
            finish();
        }
    };
}