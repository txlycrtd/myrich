package txl.cn.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import txl.cn.myapplication.R;
import txl.cn.myapplication.data.DbData;
import txl.cn.myapplication.ui.DataLookActivity;

public class MyAdapter extends RecyclerView.Adapter {
    private List<DbData> data;
    private Context context;
    public MyAdapter(Context context, List<DbData> dataList){
        this.context=context;
        this.data=dataList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_data_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
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
        public void bind(DbData data){
            tvNumText.setText(data.getNum()+"");
            tvCount.setText((data.getNumCount()+1)+"");
            btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            btXG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
