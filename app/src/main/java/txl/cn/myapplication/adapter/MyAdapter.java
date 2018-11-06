package txl.cn.myapplication.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import txl.cn.myapplication.R;
import txl.cn.myapplication.data.DbData;
import txl.cn.myapplication.data.NumData;
import txl.cn.myapplication.ui.DataLookActivity;

public class MyAdapter extends RecyclerView.Adapter {
    private List<DbData> dataLists;
    private Context context;
    public MyAdapter(Context context, List<DbData> dataList){
        this.context=context;
        this.dataLists=dataList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_data_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).bind(dataLists.get(position),position);
    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }
    private class MyViewHolder extends RecyclerView.ViewHolder{
        private Button btDelete,btXG;
        private TextView tvNumText,tvCount;
        public MyViewHolder(View itemView) {
            super(itemView);
            btDelete=itemView.findViewById(R.id.bt_delete);
            btXG=itemView.findViewById(R.id.bt_xg);
            tvCount=itemView.findViewById(R.id.tv_num_count);
            tvNumText=itemView.findViewById(R.id.tv_num);
        }
        public void bind(final DbData data, final int p){
            if(p==dataLists.size()-1){
                btDelete.setVisibility(View.VISIBLE);
            }else {
                btDelete.setVisibility(View.GONE);
            }
            NumData datas=new NumData(data.getNum());
            tvNumText.setText(datas.numStr());
            tvCount.setText((data.getNumCount()+1)+"");
            btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("确定删除该条数据？");
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dataLists.remove(p);
                          notifyDataSetChanged();
                            ((DataLookActivity)context).getManager().deleteNum(data.getNumCount());
                            dialog.dismiss();

                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });


            btXG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final EditText et = new EditText(context);
                    et.setInputType(InputType.TYPE_CLASS_NUMBER);
                    new AlertDialog.Builder(context).setTitle("请输入新的号码")
                            .setIcon(android.R.drawable.sym_def_app_icon)
                            .setView(et)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //按下确定键后的事件
                                   String inPutText=et.getText().toString();
                                   if(inPutText.isEmpty()||inPutText.length()!=3){
                                       Toast.makeText(context,"输入不合法",Toast.LENGTH_SHORT).show();
                                   }else {
                                       int num=Integer.parseInt(inPutText);
                                       data.setNum(num);
                                       notifyItemChanged(p);
                                       ((DataLookActivity)context).getManager().updataData(data);
                                       dialogInterface.dismiss();
                                   }

                                }
                            }).setNegativeButton("取消",null).show();

                }
            });
        }
    }
}
