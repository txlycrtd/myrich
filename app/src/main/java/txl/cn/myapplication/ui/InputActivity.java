package txl.cn.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import txl.cn.myapplication.R;

/**
 * 作者：tangxl on 2018/9/27 14:44
 */
public class InputActivity extends AppCompatActivity {
    private TextView tv;
    private Button button;
    private static String SSS="sss";
    private static String CONUT="ssss";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        initView();
    }

    private void initView() {
        button=findViewById(R.id.bt_copy);
        tv=findViewById(R.id.tv_input);
        String text=getIntent().getStringExtra(SSS);
        int cont=getIntent().getIntExtra(CONUT,0);
        button.setText("共"+cont+"注,点击复制");
        tv.setText(text);
    }
    public static Intent InPutInit(Context context,String datatext, int count){
        Intent intent=new Intent(context,InputActivity.class);
        intent.putExtra(SSS,datatext);
        intent.putExtra(CONUT,count);
        return intent;
    }
}
