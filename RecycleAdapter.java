package com.example.user.groceriesfinal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<DataModel> dataModelArrayList;

    public RecycleAdapter(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView shop,loc,des,veg1,pr1,veg2,pr2,veg3,pr3,veg4,pr4,veg5,pr5;

        public Myholder(View itemView) {
            super(itemView);

            shop =  itemView.findViewById(R.id.shop);
            loc =  itemView.findViewById(R.id.loc);
            des =  itemView.findViewById(R.id.des);
            veg1 =  itemView.findViewById(R.id.veg1);
            veg2=  itemView.findViewById(R.id.veg2);
            veg3=  itemView.findViewById(R.id.veg3);
            veg4=  itemView.findViewById(R.id.veg4);
            veg5=  itemView.findViewById(R.id.veg5);
            pr1=  itemView.findViewById(R.id.pr1);
            pr2 =  itemView.findViewById(R.id.pr2);
            pr3 =  itemView.findViewById(R.id.pr3);
            pr4 =  itemView.findViewById(R.id.pr4);
            pr5 =  itemView.findViewById(R.id.pr5);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);
        holder.shop.setText(dataModel.getShop());
        holder.loc.setText(dataModel.getLoc());
        holder.des.setText(dataModel.getDes());
        holder.veg1.setText(dataModel.getVeg1());
        holder.veg2.setText(dataModel.getVeg2());
        holder.veg3.setText(dataModel.getVeg3());
        holder.veg4.setText(dataModel.getVeg4());
        holder.veg5.setText(dataModel.getVeg5());
        holder.pr1.setText(dataModel.getPr1());
        holder.pr2.setText(dataModel.getPr2());
        holder.pr3.setText(dataModel.getPr3());
        holder.pr4.setText(dataModel.getPr4());
        holder.pr5.setText(dataModel.getPr5());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}

